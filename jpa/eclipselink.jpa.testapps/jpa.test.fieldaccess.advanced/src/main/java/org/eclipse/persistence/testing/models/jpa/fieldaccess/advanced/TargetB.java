/*
 * Copyright (c) 2012, 2022 Oracle and/or its affiliates. All rights reserved.
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
//     May 28, 2012 - ailitchev
//        - Bug 341709 - Delete fails with DB constraint violation due to an internal update
package org.eclipse.persistence.testing.models.jpa.fieldaccess.advanced;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CMP3_FA_TARGET_B")
public class TargetB implements Serializable {
    @Id
    private String id;
    private String description;

    @OneToOne
    @JoinColumn(name="SOURCE_ID")
    private Source source;

    /**
     *
     */
    public TargetB() {
    }

    public TargetB(String id) {
        this.id = id;
    }

    public TargetB(String id, String description) {
        this(id);
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Source getSource() {
        return this.source;
    }
    public void setSource(Source source) {
        this.source = source;
    }
}
