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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.tests.jpa.fieldaccess.advanced;

import org.eclipse.persistence.testing.framework.jpa.junit.JUnitTestCase;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p><b>Purpose</b>: To collect the tests that will run in OSGi environment.
 */
public class OSGiTestSuite extends TestSuite {
    public static Test suite() {
        JUnitTestCase.initializePlatform();
        TestSuite suite = new TestSuite();
        suite.setName("Fieldaccess Advanced OSGiTestSuite");
        suite.addTest(AdvancedJPAJunitTest.suite());
        suite.addTest(AdvancedJunitTest.suite());
        suite.addTest(CallbackEventJUnitTest.suite());
        suite.addTest(ExtendedPersistenceContextJUnitTest.suite());
        suite.addTest(JoinedAttributeAdvancedJunitTest.suite());
        suite.addTest(NamedNativeQueryJUnitTest.suite());
        suite.addTest(OptimisticConcurrencyJUnitTest.suite());
        suite.addTest(ReportQueryConstructorExpressionTest.suite());
        suite.addTest(ReportQueryMultipleReturnTest.suite());
        suite.addTest(SQLResultSetMappingTest.suite());
        suite.addTest(UpdateAllQueryAdvancedJunitTest.suite());

        return suite;
    }
}
