package com.maistruk.hibernate_2.model.SetCollection;

import java.util.Set;

public class EmployeeSet {
    
    private int id;
    private String firstName; 
    private String lastName;   
    private Set<CertificateSet> certificates;
    
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
    public Set<CertificateSet> getCertificates() {
        return certificates;
    }
    public void setCertificates(Set<CertificateSet> certificates) {
        this.certificates = certificates;
    }
    @Override
    public String toString() {
        return "Employee_2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName 
                + ", certificates=" + certificates + "]";
    }
    
    /*
    create table EMPLOYEE_SET (
            id SERIAL NOT NULL PRIMARY KEY,
            first_name VARCHAR(20) default NULL,
            last_name  VARCHAR(20) default NULL
         );
    */
    
    

}
