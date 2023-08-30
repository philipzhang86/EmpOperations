package com.curpatient.empoperations.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;

    @Column(name = "NAME", length = 45)
    private String name;

    @Column(name = "PHONE_NUMBER", length = 45)
    private String phoneNumber;

    @Column(name = "SUPERVISORS", length = 45)
    private String supervisors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", supervisors='" + supervisors + '\'' +
                '}';
    }
}