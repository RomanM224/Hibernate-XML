package com.maistruk.hibernate_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.model.ListCollection.CertificateList;
import com.maistruk.hibernate_2.model.ListCollection.EmployeeList;

public class MainListCollection {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
     //   addEmployeeCertificate(sessionFactory);
//        
//        getEmployeeCertificate(sessionFactory);
//        
     //   updateEmployeeCertificate(sessionFactory);
        
        deleteEmployeeCertificate(sessionFactory);
        
    }
    
    public static void addEmployeeCertificate(SessionFactory sessionFactory) {
        CertificateList certificate1 = new CertificateList("MBA");
        CertificateList certificate2 = new CertificateList("PMP");
        CertificateList certificate3 = new CertificateList("MCA");
        CertificateList certificate4 = new CertificateList("MMT");
        List<CertificateList> certificates = new ArrayList<>(Arrays.asList(certificate1, certificate2, certificate3, certificate4));
        
        EmployeeList employee = new EmployeeList();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setCertificates(certificates);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EmployeeList> employees = session.createQuery("FROM EmployeeList").list();
        for(EmployeeList employee : employees) {
            System.out.println(employee);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeList employee = (EmployeeList)session.get(EmployeeList.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);
        
        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeList employee = (EmployeeList)session.get(EmployeeList.class, 1);

        session.delete(employee);
        
        session.getTransaction().commit();
        session.close();
    }
    
    

    /*
     
    drop table CERTIFICATE_LIST;
    drop table EMPLOYEE_LIST;
    
    create table EMPLOYEE_LIST (
            id SERIAL NOT NULL PRIMARY KEY,
            first_name VARCHAR(20) default NULL,
            last_name  VARCHAR(20) default NULL
         );
         
         
   create table CERTIFICATE_LIST (
            id SERIAL NOT NULL PRIMARY KEY,
            certificate_name VARCHAR(20) default NULL,
            idx INT default NULL, 
            employee_id INTEGER,
            FOREIGN KEY (employee_id) REFERENCES employee_list (id)
            );
            
    */

}
