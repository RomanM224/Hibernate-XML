package com.maistruk.hibernate_2.ComponentMapping;

public class EmployeeComponent {
    
    private int id;
    private String firstName; 
    private String lastName;   
    private int salary;
    private AddressComponent address;
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
    public AddressComponent getAddress() {
        return address;
    }
    public void setAddress(AddressComponent address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "EmployeeComponent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
                + salary + ", address=" + address + "]";
    }
    
    

}
