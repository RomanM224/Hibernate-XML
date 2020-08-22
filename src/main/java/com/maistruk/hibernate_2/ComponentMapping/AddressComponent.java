package com.maistruk.hibernate_2.ComponentMapping;

public class AddressComponent {
    
    private int id;
    private String street;     
    private String city;     
    private String state;    
    private String zipcode;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString() {
        return "AddressComponent [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state
                + ", zipcode=" + zipcode + "]";
    } 
    
    

}
