package com.maistruk.hibernate_2.OneToOne;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.manyToOne.AddressManyToOne;
import com.maistruk.hibernate_2.manyToOne.EmployeeManyToOne;


public class MainOneToOne {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        //saveAdressEmployee(sessionFactory);
        
       // getAdressEmployee(sessionFactory);
        
       // updateAdressEmployee(sessionFactory);
        
        deleteAdressEmployee(sessionFactory);
    }
    
    public static void saveAdressEmployee(SessionFactory sessionFactory) {
        AddressOneToOne address = new AddressOneToOne();
        address.setCity("Oslo");
        address.setState("Oslo");
        address.setStreet("Hovergata");
        address.setZipcode("2847");
        EmployeeOneToOne employee = new EmployeeOneToOne();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setSalary(1000);
        employee.setAddress(address);
        EmployeeOneToOne employee2 = new EmployeeOneToOne();
        employee2.setFirstName("Vika");
        employee2.setLastName("Mai");
        employee2.setSalary(1200);
        employee2.setAddress(address);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.save(employee);
        session.save(employee2);
        session.getTransaction().commit();
        session.close();

    }
    
    public static void getAdressEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EmployeeOneToOne> employees = session.createQuery("FROM EmployeeOneToOne").list();
        for (EmployeeOneToOne employee : employees) {
            System.out.println(employee);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateAdressEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeOneToOne employee = (EmployeeOneToOne) session.get(EmployeeOneToOne.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteAdressEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeOneToOne employee = (EmployeeOneToOne) session.get(EmployeeOneToOne.class, 1);
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }

    /*
    
    drop table EMPLOYEE_ONE_TO_ONE; 
    drop table ADDRESS_ONE_TO_ONE;
    
    create table ADDRESS_ONE_TO_ONE ( 
             id SERIAL NOT NULL PRIMARY KEY,
             street_name VARCHAR(40) default NULL, 
             city_name VARCHAR(40) default NULL,
             state_name VARCHAR(40) default NULL, 
             zipcode VARCHAR(10) default NULL );
    
    create table EMPLOYEE_ONE_TO_ONE ( 
             id SERIAL NOT NULL PRIMARY KEY,
             first_name VARCHAR(20) default NULL, 
             last_name VARCHAR(20) default NULL,
             salary INT default NULL, 
             address INT NOT NULL, 
             FOREIGN KEY (address)
             REFERENCES ADDRESS_ONE_TO_ONE (id) );
    
   */
}
