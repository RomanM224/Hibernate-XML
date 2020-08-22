package com.maistruk.hibernate_2.model.MapCollection;

import java.util.Map;

public class EmployeeMap {

    private int id;
    private String firstName;
    private String lastName;
    private Map<String, CertificateMap> certificates;

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

    public Map<String, CertificateMap> getCertificates() {
        return certificates;
    }

    public void setCertificates(Map<String, CertificateMap> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "EmployeeMap [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", certificates="
                + certificates + "]";
    }

}
