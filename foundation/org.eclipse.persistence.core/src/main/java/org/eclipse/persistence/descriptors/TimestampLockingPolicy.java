/*
 * Copyright (c) 1998, 2025 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2022 IBM Corporation. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.descriptors;

import org.eclipse.persistence.exceptions.OptimisticLockException;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.internal.helper.ClassConstants;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.internal.sessions.AbstractRecord;
import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.queries.ModifyQuery;

import java.sql.Timestamp;

/**
 * <p><b>Purpose</b>: Used to allow a single version timestamp to be used for optimistic locking.
 *
 * @since TOPLink/Java 2.0
 */
public class TimestampLockingPolicy extends VersionLockingPolicy {
    protected int retrieveTimeFrom;
    public final static int SERVER_TIME = 1;
    public final static int LOCAL_TIME = 2;

    /**
     * PUBLIC:
     * Create a new TimestampLockingPolicy.
     * Defaults to using the time retrieved from the server.
     */
    public TimestampLockingPolicy() {
        super();
        this.useServerTime();
    }

    /**
     * PUBLIC:
     * Create a new TimestampLockingPolicy.
     * Defaults to using the time retrieved from the server.
     * @param fieldName the field where the write lock value will be stored.
     */
    public TimestampLockingPolicy(String fieldName) {
        super(fieldName);
        this.useServerTime();
    }

    /**
     * INTERNAL:
     * Create a new TimestampLockingPolicy.
     * Defaults to using the time retrieved from the server.
     * @param field the field where the write lock value will be stored.
     */
    public TimestampLockingPolicy(DatabaseField field) {
        super(field);
        this.useServerTime();
    }

    /**
     * INTERNAL:
     * This method compares two writeLockValues.
     * The writeLockValues should be non-null and of type java.sql.Timestamp.
     * Returns:
     * -1 if value1 is less (older) than value2;
     *  0 if value1 equals value2;
     *  1 if value1 is greater (newer) than value2.
     * Throws:
     *  NullPointerException if the passed value is null;
     *  ClassCastException if the passed value is of a wrong type.
     */
    @Override
    public int compareWriteLockValues(Object value1, Object value2) {
        java.sql.Timestamp timestampValue1 = (java.sql.Timestamp)value1;
        java.sql.Timestamp timestampValue2 = (java.sql.Timestamp)value2;
        return timestampValue1.compareTo(timestampValue2);
    }

    /**
     * INTERNAL:
     * Return the default timestamp locking filed java type, default is Timestamp.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    protected <T> Class<T> getDefaultLockingFieldType() {
        return (Class<T>) ClassConstants.TIMESTAMP;
    }

    /**
     * INTERNAL:
     * This is the base value that is older than all other values, it is used in the place of
     * null in some situations.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getBaseValue(){
        return (T) new Timestamp(0);
    }

    /**
     * INTERNAL:
     * returns the initial locking value
     */
    @Override
    @SuppressWarnings({"unchecked"})
    protected <T> T getInitialWriteValue(AbstractSession session) {
        if (usesLocalTime()) {
            return (T) new Timestamp(System.currentTimeMillis());
        }
        if (usesServerTime()) {
            AbstractSession readSession = session.getSessionForClass(getDescriptor().getJavaClass());
            while (readSession.isUnitOfWork()) {
                readSession = readSession.getParent().getSessionForClass(getDescriptor().getJavaClass());
            }

            return (T) readSession.getDatasourceLogin().getDatasourcePlatform().getTimestampFromServer(session, readSession.getName());
        }
        return null;

    }

    /**
     * INTERNAL:
     * Returns the new Timestamp value.
     */
    @Override
    public <T> T getNewLockValue(ModifyQuery query) {
        return getInitialWriteValue(query.getSession());
    }

    /**
     * INTERNAL:
     * Return the value that should be stored in the identity map.  If the value
     * is stored in the object, then return a null.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getValueToPutInCache(AbstractRecord row, AbstractSession session) {
        if (isStoredInCache()) {
            return (T) session.getDatasourcePlatform().convertObject(row.get(getWriteLockField()), ClassConstants.TIMESTAMP);
        } else {
            return null;
        }
    }

    /**
     * INTERNAL:
     * Return the number of versions different between these objects.
     */
    @Override
    public int getVersionDifference(Object currentValue, Object domainObject, Object primaryKeys, AbstractSession session) {
        java.sql.Timestamp writeLockFieldValue;
        java.sql.Timestamp newWriteLockFieldValue = (java.sql.Timestamp)currentValue;
        if (newWriteLockFieldValue == null) {
            return 0;//merge it as either the object is new or being forced merged.
        }
        if (isStoredInCache()) {
            writeLockFieldValue = (java.sql.Timestamp)session.getIdentityMapAccessorInstance().getWriteLockValue(primaryKeys, domainObject.getClass(), getDescriptor());
        } else {
            writeLockFieldValue = (java.sql.Timestamp)lockValueFromObject(domainObject);
        }
        if ((writeLockFieldValue != null) && (newWriteLockFieldValue.equals(writeLockFieldValue))) {
            return 0;
        }
        if ((writeLockFieldValue != null) && !(newWriteLockFieldValue.after(writeLockFieldValue))) {
            return -1;
        }

        return 1;
    }

    /**
     * INTERNAL:
     * This method will return the optimistic lock value for the object.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T getWriteLockValue(Object domainObject, Object primaryKey, AbstractSession session) {
        java.sql.Timestamp writeLockFieldValue = null;
        if (isStoredInCache()) {
            writeLockFieldValue = (java.sql.Timestamp)session.getIdentityMapAccessorInstance().getWriteLockValue(primaryKey, domainObject.getClass(), getDescriptor());
        } else {
            //CR#2281 notStoredInCache prevent ClassCastException
            Object lockValue = lockValueFromObject(domainObject);
            if (lockValue != null) {
                if (lockValue instanceof java.sql.Timestamp) {
                    writeLockFieldValue = (java.sql.Timestamp)lockValueFromObject(domainObject);
                } else {
                    throw OptimisticLockException.needToMapJavaSqlTimestampWhenStoredInObject();
                }
            }
        }
        return (T) writeLockFieldValue;
    }

    /**
     * INTERNAL:
     * Return an expression that updates the write lock
     */
    @Override
    public Expression getWriteLockUpdateExpression(ExpressionBuilder builder, AbstractSession session) {
        return builder.currentTimeStamp();
    }

    /**
     * INTERNAL:
     * Timestamp versioning should not be able to do this.  Override the superclass behavior.
     */
    @Override
    protected Number incrementWriteLockValue(Number numberValue) {
        return null;
    }

    /**
     * INTERNAL:
     * Compares the value with the value from the object (or cache).
     * Will return true if the currentValue is newer than the domainObject.
     */
    @Override
    public boolean isNewerVersion(Object currentValue, Object domainObject, Object primaryKey, AbstractSession session) {
        java.sql.Timestamp writeLockFieldValue;
        java.sql.Timestamp newWriteLockFieldValue = (java.sql.Timestamp)currentValue;
        if (isStoredInCache()) {
            writeLockFieldValue = (java.sql.Timestamp)session.getIdentityMapAccessorInstance().getWriteLockValue(primaryKey, domainObject.getClass(), getDescriptor());
        } else {
            writeLockFieldValue = (java.sql.Timestamp)lockValueFromObject(domainObject);
        }

        return isNewerVersion(newWriteLockFieldValue, writeLockFieldValue);
    }

    /**
     * INTERNAL:
     * Compares the value from the row and from the object (or cache).
     * Will return true if the row is newer than the object.
     */
    @Override
    public boolean isNewerVersion(AbstractRecord databaseRow, Object domainObject, Object primaryKey, AbstractSession session) {
        java.sql.Timestamp writeLockFieldValue;
        java.sql.Timestamp newWriteLockFieldValue = session.getDatasourcePlatform().convertObject(databaseRow.get(getWriteLockField()), ClassConstants.TIMESTAMP);
        if (isStoredInCache()) {
            writeLockFieldValue = (java.sql.Timestamp)session.getIdentityMapAccessorInstance().getWriteLockValue(primaryKey, domainObject.getClass(), getDescriptor());
        } else {
            writeLockFieldValue = (java.sql.Timestamp)lockValueFromObject(domainObject);
        }

        return isNewerVersion(newWriteLockFieldValue, writeLockFieldValue);
    }

    /**
     * INTERNAL:
     * Compares two values.
     * Will return true if the firstLockFieldValue is newer than the secondWriteLockFieldValue.
     */
    @Override
    public boolean isNewerVersion(Object firstLockFieldValue, Object secondWriteLockFieldValue) {
        java.sql.Timestamp firstValue = (java.sql.Timestamp)firstLockFieldValue;
        java.sql.Timestamp secondValue = (java.sql.Timestamp)secondWriteLockFieldValue;

        // 2.5.1.6 if the write lock value is null, then what ever we have is treated as newer.
        if (firstValue == null) {
            return false;
        }

        // bug 6342382: first is not null, second is null, so we know first>second.
        if(secondValue == null) {
            return true;
        }

        if (firstValue.after(secondValue)){
            return true;
        }
        return false;
    }

    /**
     * PUBLIC:
     * Set if policy uses server time.
     */
    public void setUsesServerTime(boolean usesServerTime) {
        if (usesServerTime) {
            useServerTime();
        } else {
            useLocalTime();
        }
    }

    /**
     * PUBLIC:
     * set this policy to get the time from the local machine.
     */
    public void useLocalTime() {
        retrieveTimeFrom = LOCAL_TIME;
    }

    /**
     * PUBLIC:
     * set this policy to get the time from the server.
     */
    public void useServerTime() {
        retrieveTimeFrom = SERVER_TIME;
    }

    /**
     * PUBLIC:
     * Return true if policy uses local time.
     */
    public boolean usesLocalTime() {
        return (retrieveTimeFrom == LOCAL_TIME);
    }

    /**
     * PUBLIC:
     * Return true if policy uses server time.
     */
    public boolean usesServerTime() {
        return (retrieveTimeFrom == SERVER_TIME);
    }
}
