/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
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
//     06/16/2009-2.0 Guy Pelletier
//       - 277039: JPA 2.0 Cache Usage Settings
//     07/16/2009-2.0 Guy Pelletier
//       - 277039: JPA 2.0 Cache Usage Settings
//     06/09/2010-2.0.3 Guy Pelletier
//       - 313401: shared-cache-mode defaults to NONE when the element value is unrecognized
package org.eclipse.persistence.testing.tests.jpa.cacheable;

import junit.framework.*;

import org.eclipse.persistence.sessions.server.ServerSession;
import org.eclipse.persistence.testing.framework.jpa.junit.JUnitTestCase;
import org.eclipse.persistence.testing.models.jpa.cacheable.CacheableTableCreator;

/*
 * The test is testing against "MulitPU-1" persistence unit which has <shared-cache-mode> to be ALL
 */
public class CacheableModelJunitTestAll extends CacheableModelJunitTest {

    public CacheableModelJunitTestAll() {
        super();
    }

    public CacheableModelJunitTestAll(String name) {
        super(name);
        setPuName("MulitPU-1");
    }

    @Override
    public void setUp() {
        clearCache("MulitPU-1");
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.setName("CacheableModelJunitTestAll");

        if (! JUnitTestCase.isJPA10()) {
            suite.addTest(new CacheableModelJunitTestAll("testSetup"));
            suite.addTest(new CacheableModelJunitTestAll("testCachingOnALL"));
            suite.addTest(new CacheableModelJunitTestAll("testDetailsOrder_Shared"));
            suite.addTest(new CacheableModelJunitTestAll("testDetailsOrder_Shared_BeginEarlyTransaction"));
        }
        return suite;
    }

    /**
     * The setup is done as a test, both to record its failure, and to allow execution in the server.
     */
    @Override
    public void testSetup() {
        new CacheableTableCreator().replaceTables(JUnitTestCase.getServerSession("MulitPU-1"));
        clearCache("MulitPU-1");
    }

    /**
     * Convenience method.
     */
    @Override
    public ServerSession getPUServerSession(String puName) {
        return JUnitTestCase.getServerSession("MulitPU-1");
    }
}
