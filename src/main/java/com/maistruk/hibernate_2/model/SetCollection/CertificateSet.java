package com.maistruk.hibernate_2.model.SetCollection;

public class CertificateSet {
    
    private int id;
    private String name;
    
    public CertificateSet() {
    }
    
    public CertificateSet(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Certificate_2 [id=" + id + ", name=" + name + "]";
    } 
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        CertificateSet certificate = (CertificateSet)obj;
        if((this.id == certificate.getId()) && (this.name.equals(certificate.getName()))) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (id + name).hashCode();
        return tmp;
    }
    
    /*
    create table CERTIFICATE_SET (
            id SERIAL NOT NULL PRIMARY KEY,
            certificate_name VARCHAR(20) default NULL,
            employee_id INTEGER,
            FOREIGN KEY (employee_id) REFERENCES employee_set (id)
            );
            
    */

}
