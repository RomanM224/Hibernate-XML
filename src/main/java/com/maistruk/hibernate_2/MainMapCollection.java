package com.maistruk.hibernate_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.model.MapCollection.CertificateMap;
import com.maistruk.hibernate_2.model.MapCollection.EmployeeMap;

public class MainMapCollection {

    public static void main(String[] args) {
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        //addEmployeeCertificate(sessionFactory);
        
        //getEmployeeCertificate(sessionFactory);
        
       // updateEmployeeCertificate(sessionFactory);
        
        deleteEmployeeCertificate(sessionFactory);
        
        
        
    }
    
    public static void addEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Map<String, CertificateMap> certificates = new HashMap<>();
        certificates.put("ComputerScience", new CertificateMap("MCA"));
        certificates.put("BusinessManagement", new CertificateMap("MBA"));
        certificates.put("ProjectManagement", new CertificateMap("PMP"));
        EmployeeMap employee = new EmployeeMap();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setCertificates(certificates);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EmployeeMap> employees =  session.createQuery("from EmployeeMap").list();
        for(EmployeeMap employee : employees) {
            System.out.println(employee);
        }
        
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeMap employee =  (EmployeeMap) session.get(EmployeeMap.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeMap employee =  (EmployeeMap) session.get(EmployeeMap.class, 1);
        session.delete(employee);
        
        session.getTransaction().commit();
        session.close();
    }

    

    /*
    
    drop table CERTIFICATE_MAP;
    drop table EMPLOYEE_MAP;
    
    create table EMPLOYEE_MAP (
            id SERIAL NOT NULL PRIMARY KEY,
            first_name VARCHAR(20) default NULL,
            last_name  VARCHAR(20) default NULL
         );
         
         
   create table CERTIFICATE_MAP (
            id SERIAL NOT NULL PRIMARY KEY,
            certificate_name VARCHAR(20) default NULL,
            certificate_type VARCHAR(40) default NULL, 
            employee_id INTEGER,
            FOREIGN KEY (employee_id) REFERENCES employee_MAP (id)
            );
            
    */
}
