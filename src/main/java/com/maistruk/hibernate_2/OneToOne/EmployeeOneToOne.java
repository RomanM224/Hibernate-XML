package com.maistruk.hibernate_2.OneToOne;

import com.maistruk.hibernate_2.manyToOne.AddressManyToOne;

public class EmployeeOneToOne {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private AddressOneToOne address;

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

    public AddressOneToOne getAddress() {
        return address;
    }

    public void setAddress(AddressOneToOne address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
                + ", address=" + address + "]";
    }
}
