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
//     tware - add for testing JPA 2.0 delimited identifiers
package org.eclipse.persistence.testing.models.jpa.delimited;

import java.util.*;
import java.io.Serializable;
import jakarta.persistence.*;
import static org.eclipse.persistence.annotations.ExistenceType.CHECK_CACHE;
import static jakarta.persistence.GenerationType.*;
import static jakarta.persistence.InheritanceType.*;

import org.eclipse.persistence.annotations.BasicCollection;
import org.eclipse.persistence.annotations.CollectionTable;
import org.eclipse.persistence.annotations.ExistenceChecking;

/**
 * Employees have a many-to-many relationship with Projects through the
 * projects attribute.
 * Projects refer to Employees through the teamMembers attribute.
 * This class in used to test inheritance.
 * The field names intentionally do not match the property names to test method weaving.
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name="CMP3_DEL_PROJECT")
@Inheritance(strategy=JOINED)
@DiscriminatorColumn(name="PROJ_TYPE")
@DiscriminatorValue("P")
@NamedQuery(
    name="findProjectByName",
    query="SELECT OBJECT(project) FROM Project project WHERE project.name = :name"
)
@ExistenceChecking(CHECK_CACHE)
public class Project implements Serializable {
    public int pre_update_count = 0;
    public int post_update_count = 0;
    public int pre_remove_count = 0;
    public int post_remove_count = 0;
    public int pre_persist_count = 0;
    public int post_persist_count = 0;
    public int post_load_count = 0;

    private Integer m_id;
    private int m_version;
    private String m_name;
    private String m_description;
    protected Employee m_teamLeader;
    private Collection<Employee> m_teamMembers;
    private List<String> m_properties;

    public Project () {
        m_teamMembers = new Vector<>();
        m_properties = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="DEL_PROJECT_SEQUENCE_GENERATOR")
    @SequenceGenerator(name="DEL_PROJECT_SEQUENCE_GENERATOR", sequenceName="DEL_PROJECT_SEQ", allocationSize=10)
    @Column(name="PROJ_ID")
    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        this.m_id = id;
    }

    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return m_version;
    }

    protected void setVersion(int version) {
        this.m_version = version;
    }

    @Column(name="PROJ_NAME")
    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    @Column(name="DESCRIP")
    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        this.m_description = description;
    }


    @BasicCollection(valueColumn=@Column(name="PROPS"))
    @CollectionTable(name="CMP3_DEL_PROJ_PROPS")
    public List<String> getProperties() {
        return m_properties;
    }

    public void setProperties(List<String> properties) {
        this.m_properties = properties;
    }

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="LEADER_ID")
    public Employee getTeamLeader() {
        return m_teamLeader;
    }

    public void setTeamLeader(Employee teamLeader) {
        this.m_teamLeader = teamLeader;
    }

    @ManyToMany(targetEntity=Employee.class, mappedBy="projects")
    public Collection<Employee> getTeamMembers() {
        return m_teamMembers;
    }

    public void setTeamMembers(Collection<Employee> employees) {
        this.m_teamMembers = employees;
    }

    public void addTeamMember(Employee employee) {
        getTeamMembers().add(employee);
    }

    public void removeTeamMember(Employee employee) {
        getTeamMembers().remove(employee);
    }

    public String displayString() {
        StringBuilder sbuff = new StringBuilder();
        sbuff.append("Project ").append(getId()).append(": ").append(getName()).append(", ").append(getDescription());

        return sbuff.toString();
    }

    @PrePersist
    public void prePersist() {
        ++pre_persist_count;
    }

    @PostPersist
    public void postPersist() {
        ++post_persist_count;
    }

    @PreRemove
    public void preRemove() {
        ++pre_remove_count;
    }

    @PostRemove
    public void postRemove() {
        ++post_remove_count;
    }

    @PreUpdate
    public void preUpdate() {
        ++pre_update_count;
    }

    @PostUpdate
    public void postUpdate() {
        ++post_update_count;
    }

    @PostLoad
    public void postLoad() {
        ++post_load_count;
    }
}
