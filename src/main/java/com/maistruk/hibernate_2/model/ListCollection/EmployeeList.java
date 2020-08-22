package com.maistruk.hibernate_2.model.ListCollection;

import java.util.List;


public class EmployeeList {
    
    private int id;
    private String firstName; 
    private String lastName;   
    private List<CertificateList> certificates;
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
    public List<CertificateList> getCertificates() {
        return certificates;
    }
    public void setCertificates(List<CertificateList> certificates) {
        this.certificates = certificates;
    }
    
    @Override
    public String toString() {
        return "EmployeeList [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", certificates="
                + certificates + "]";
    }

    
}
