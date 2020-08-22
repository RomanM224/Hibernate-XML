package com.maistruk.hibernate_2.model.ListCollection;

public class CertificateList {
    
    private int id;
    private String name;
    
    public CertificateList() {
    }
    
    public CertificateList(String name) {
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
   

}
