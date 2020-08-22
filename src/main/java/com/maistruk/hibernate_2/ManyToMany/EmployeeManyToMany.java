package com.maistruk.hibernate_2.ManyToMany;

import java.util.Set;

import com.maistruk.hibernate_2.OneToMany.CertificateOneToMany;

public class EmployeeManyToMany {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Set<CertificateManyToMany> certificates;

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

    public Set<CertificateManyToMany> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<CertificateManyToMany> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "EmployeeOneToMany [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
                + salary + ", certificates=" + certificates + "]";
    }
}
