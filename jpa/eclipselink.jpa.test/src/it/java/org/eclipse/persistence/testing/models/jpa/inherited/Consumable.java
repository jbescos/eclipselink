/*
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     tware - initial implementation
package org.eclipse.persistence.testing.models.jpa.inherited;

import jakarta.persistence.MappedSuperclass;

import org.eclipse.persistence.testing.models.jpa.inheritance.GenericTestInterface1;

/**
 * This class was added as a test for bug 411560
 * @author tware
 *
 */

@MappedSuperclass
public class Consumable<PK> implements GenericTestInterface1<PK>{


}
