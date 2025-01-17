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
package org.eclipse.persistence.testing.models.jpa.fieldaccess.advanced;

import java.io.Serializable;

import jakarta.persistence.*;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.*;

@Entity(name = "Woman")
@Table(name = "CMP3_FA_WOMAN")
public class Woman implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "FA_WOMAN_SEQ_GENERATOR")
    @SequenceGenerator(name = "FA_WOMAN_SEQ_GENERATOR", sequenceName = "WOMAN_SEQ")
    private Integer id;
    @OneToOne(mappedBy = "woman", cascade = ALL)
    @CascadeOnDelete
    private PartnerLink partnerLink;

    private String name;

    public Woman() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PartnerLink getPartnerLink() {
        return partnerLink;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartnerLink(PartnerLink partnerLink) {
        this.partnerLink = partnerLink;
    }
}
