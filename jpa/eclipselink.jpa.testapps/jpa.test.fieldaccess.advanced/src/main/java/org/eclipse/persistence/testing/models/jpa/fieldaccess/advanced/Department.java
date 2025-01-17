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
//     11/06/2009-2.0 Guy Pelletier
//       - 286317: UniqueConstraint xml element is changing (plus couple other fixes, see bug)
package org.eclipse.persistence.testing.models.jpa.fieldaccess.advanced;

import java.io.Serializable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MapKey;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.TABLE;

import org.eclipse.persistence.annotations.PrivateOwned;

/**
 * <p><b>Purpose</b>: Represents the department of an Employee
 * <p><b>Description</b>: Held in a private 1:1 relationship from Employee
 * @see Employee
 */
@Entity(name="Department")
@Table(name="CMP3_FA_DEPT")
@NamedNativeQuery(
    name="findAllSQLDepartments",
    query="select * from CMP3_FA_DEPT",
    resultClass=org.eclipse.persistence.testing.models.jpa.fieldaccess.advanced.Department.class
)
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy=TABLE, generator="FA_DEP_TABLE_GENERATOR")
    @TableGenerator(
        name="FA_DEP_TABLE_GENERATOR",
        table="CMP3_FA_DEPARTMENT_SEQ",
        pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT",
        pkColumnValue="DEPT_SEQ"
    )
    private Integer id;
    private String name;

    @OneToMany(mappedBy="department")
    private Collection<Employee> employees;
    @OneToMany(cascade=PERSIST)
    private Collection<Employee> managers;
    @OneToMany(mappedBy="department")
    @MapKey
    @PrivateOwned
    private Map<Integer, Equipment> equipment;

    public Department() {
        this("");
    }

    public Department(String name) {
        this.name = name;
        this.managers = new Vector<>();
        this.equipment = new HashMap<>();
    }

    public void addEquipment(Equipment e) {
        this.equipment.put(e.getId(), e);
        e.setDepartment(this);
    }

    public void addManager(Employee employee) {
        if (employee != null && managers != null && !managers.contains(employee)) {
            this.managers.add(employee);
        }
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public Map<Integer, Equipment> getEquipment() {
        return equipment;
    }

    public Integer getId() {
        return id;
    }

    //To test default 1-M mapping
    public Collection<Employee> getManagers() {
        return managers;
    }

    public String getName() {
        return name;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public void setEquipment(Map<Integer, Equipment> equipment) {
        this.equipment = equipment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setManagers(Collection<Employee> managers) {
        this.managers = managers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
