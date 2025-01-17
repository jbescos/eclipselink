/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.testing.sdo.helper.xmlhelper.loadandsave.nodenullpolicy;

import java.util.ArrayList;
import java.util.List;

import static org.eclipse.persistence.sdo.SDOConstants.*;
import org.eclipse.persistence.testing.sdo.helper.xmlhelper.loadandsave.LoadAndSaveTestCases;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.XMLDocument;

public abstract class IsSetOptionalWithoutDefaultNumericPrimsTestCases extends LoadAndSaveTestCases {

    protected static final int ID_DEFAULT = 10;
    protected static final String FIRSTNAME_DEFAULT = "default-first";
    protected static final String LASTNAME_DEFAULT = "default-last";
    protected static final String task_DEFAULT = EMPTY_STRING;
    protected static final String ID_NAME = "id";
    protected static final String FIRSTNAME_NAME = "firstname";
    protected static final String LASTNAME_NAME = "lastname";
    protected static final String TASK_NAME = "task";

    /*
     * UC 1
    <xsd:element name='employee'>
    <xsd:complexType><xsd:sequence>
        <xsd:element name='fn' type='xsd:string' />
    </xsd:sequence></xsd:complexType>
    </xsd:element>
     */
    public IsSetOptionalWithoutDefaultNumericPrimsTestCases(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        super.setUp();
    }

    @Override
    protected String getSchemaName() {
        return "./org/eclipse/persistence/testing/sdo/schemas/DirectIsSetOptionalNodeNullPolicyWithoutDefaultsNumericPrimsElement.xsd";
    }

    @Override
    protected String getControlRootURI() {
        return NON_DEFAULT_URI;
    }

    @Override
    protected String getControlRootName() {
        return "employee";
    }

    @Override
    protected String getRootInterfaceName() {
        return "EmployeeType";
    }

    // Override package generation based on the JAXB 2.0 algorithm in SDOUtil.java
    @Override
    protected List<String> getPackages() {
        List<String> packages = new ArrayList<String>();
        packages.add(NON_DEFAULT_JAVA_PACKAGE_DIR);
        return packages;
    }

    @Override
    protected void verifyAfterLoad(XMLDocument doc) {
        super.verifyAfterLoad(doc);
        Object value;
        boolean isSet;
/*        value = doc.getRootObject().get(ID_NAME);
        boolean isSet = doc.getRootObject().isSet(ID_NAME);
        assertNull(value);
        assertTrue(isSet);

        value = doc.getRootObject().get(FIRSTNAME_NAME);
        isSet = doc.getRootObject().isSet(FIRSTNAME_NAME);
        assertNull(value);
        assertTrue(isSet);
*/
        value = doc.getRootObject().get(TASK_NAME);
        isSet = doc.getRootObject().isSet(TASK_NAME);
        assertTrue(value instanceof List);
        assertTrue(((List)value).size() == 0);
        assertFalse(isSet);

        value = doc.getRootObject().get(LASTNAME_NAME);
        isSet = doc.getRootObject().isSet(LASTNAME_NAME);
        assertNotNull(value);
        assertTrue(isSet);
    }

    @Override
    public void registerTypes() {
        Type stringType = typeHelper.getType(SDO_URL, STRING);
        Type intType = typeHelper.getType(SDO_URL, INT);
        Type shortType = typeHelper.getType(SDO_URL, SHORT);
        Type longType = typeHelper.getType(SDO_URL, LONG);
        Type characterType = typeHelper.getType(SDO_URL, CHARACTER);
        Type byteType = typeHelper.getType(SDO_URL, BYTE);
        Type doubleType = typeHelper.getType(SDO_URL, DOUBLE);
        Type floatType = typeHelper.getType(SDO_URL, FLOAT);
        Type booleanType = typeHelper.getType(SDO_URL, BOOLEAN);
        Type propertyType = typeHelper.getType(SDO_URL, PROPERTY);

        // create employee type
        DataObject employeeTypeDO = dataFactory.create(SDO_URL, TYPE);
        employeeTypeDO.set("uri", getControlRootURI());
        employeeTypeDO.set("name", getRootInterfaceName());

        // add id property
        DataObject employeeIDProperty = addProperty(employeeTypeDO, ID_NAME, intType, false, false, true);
        //employeeIDProperty.set("nullable", false);
        //employeeIDProperty.set("default", 10);

        // add firstname property
        DataObject employeeFirstnameProperty = addProperty(employeeTypeDO, FIRSTNAME_NAME, stringType, false, false, true);
        //employeeFirstnameProperty.set("nullable", false);
        //employeeFirstnameProperty.set("default", "default-first");

        // add task property
        DataObject employeeTaskProperty = addProperty(employeeTypeDO, TASK_NAME, stringType, false, true, true);
        //employeeTaskProperty.set("nullable", false);
        //employeeTaskProperty.set("default", new ArrayList());
        employeeTaskProperty.setBoolean("many", true);

        // add lastname property
        DataObject employeeLastnameProperty = addProperty(employeeTypeDO, LASTNAME_NAME, stringType, false, false, true);
        //employeeLastnameProperty.set("nullable", false);
        //employeeLastnameProperty.set("default", "default-last");

        // add simple single numeric primitive properties
        addProperty(employeeTypeDO, "int_prop", intType, false, false, true);
        addProperty(employeeTypeDO, "boolean_prop", booleanType, false, false, true);
        addProperty(employeeTypeDO, "short_prop", shortType, false, false, true);
        addProperty(employeeTypeDO, "long_prop", longType, false, false, true);
        addProperty(employeeTypeDO, "character_prop", characterType, false, false, true);
        addProperty(employeeTypeDO, "byte_prop", byteType, false, false, true);
        addProperty(employeeTypeDO, "double_prop", doubleType, false, false, true);
        addProperty(employeeTypeDO, "float_prop", floatType, false, false, true);

        // define type
        Type employeeSDOType = typeHelper.define(employeeTypeDO);
        // create a property of type employee - and associate the discriptor by QName
        DataObject propDO = dataFactory.create(propertyType);
        propDO.set("name", getControlRootName());
        propDO.set("type", employeeSDOType);
        typeHelper.defineOpenContentProperty(getControlRootURI(), propDO);
    }
}
