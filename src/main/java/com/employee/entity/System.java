package com.employee.entity;

import javax.persistence.*;

@Entity
@Table(name="system")
public class System {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="model")
    private String model;

    @OneToOne(mappedBy = "system")
    private Employee employee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
