package com.maistruk.hibernate_2.OneToMany;

import java.util.Set;

public class EmployeeOneToMany {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Set<CertificateOneToMany> certificates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<CertificateOneToMany> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<CertificateOneToMany> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "EmployeeOneToMany [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
                + salary + ", certificates=" + certificates + "]";
    }

}
