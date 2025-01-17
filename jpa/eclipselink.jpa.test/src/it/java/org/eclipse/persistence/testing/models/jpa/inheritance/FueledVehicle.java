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


package org.eclipse.persistence.testing.models.jpa.inheritance;

import jakarta.persistence.*;

@Entity
@EntityListeners(org.eclipse.persistence.testing.models.jpa.inheritance.listeners.FueledVehicleListener.class)
@Table(name="CMP3_FUEL_VEH")
@DiscriminatorValue("F")
public class FueledVehicle extends Vehicle implements Cloneable {
    private Integer fuelCapacity;
    private String description;
    private String fuelType;
    private String colour;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new InternalError(exception.toString());
        }
    }

    @Override
    public void change() {
        this.setPassengerCapacity(100);
        this.setFuelType("HOT AIR");
    }

    @Override
    @Column(name="COLOUR")
    public String getColor() {
        return colour;
    }

    @Column(name="DESCRIP")
    public String getDescription() {
        return description;
    }

    @Column(name="FUEL_CAP")
    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    @Column(name="FUEL_TYP")
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void setColor(String colour) {
        this.colour = colour;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public void setFuelCapacity(Integer capacity) {
        fuelCapacity = capacity;
    }

    public void setFuelType(String type) {
        fuelType = type;
    }
}
