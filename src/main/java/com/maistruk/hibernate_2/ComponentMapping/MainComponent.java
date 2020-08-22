package com.maistruk.hibernate_2.ComponentMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainComponent {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
      //  saveEmployeeAddress(sessionFactory);
        
      //  getEmployeeAddress(sessionFactory);
        
        updateEmployeeAddress(sessionFactory);
        
        deleteEmployeeAddress(sessionFactory);

    }
    
    public static void saveEmployeeAddress(SessionFactory sessionFactory) {
        AddressComponent address = new AddressComponent();
        address.setCity("Oslo");
        address.setState("Oslo");
        address.setStreet("Hovedgata");
        address.setZipcode("2447");
        EmployeeComponent employee = new EmployeeComponent();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setSalary(1000);
        employee.setAddress(address);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getEmployeeAddress(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EmployeeComponent> employees = session.createQuery("FROM EmployeeComponent").list();
        for(EmployeeComponent employee : employees) {
            System.out.println(employee);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployeeAddress(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeComponent employee = (EmployeeComponent) session.get(EmployeeComponent.class, 1);
        employee.getAddress().setCity("Hamar");
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteEmployeeAddress(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeComponent employee = (EmployeeComponent) session.get(EmployeeComponent.class, 1);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    /*
      
     create table EMPLOYEE_ADDRESS (
       id SERIAL NOT  NULL PRIMARY KEY ,
       first_name  VARCHAR(20) default NULL,
       last_name   VARCHAR(20) default NULL,
       salary      INT  default NULL,
       street_name VARCHAR(40) default NULL,
       city_name   VARCHAR(40) default NULL,
       state_name  VARCHAR(40) default NULL,
       zipcode     VARCHAR(10) default NULL); 
      
      
      
    
     * */

}
