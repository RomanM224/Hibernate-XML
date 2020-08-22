package com.maistruk.hibernate_2.ManyToMany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainManyToMany {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
       // saveEmployeeCertificate(sessionFactory);
        
       // getEmployeeCertificate(sessionFactory);
        
      //  updateEmployeeCertificate(sessionFactory);
        
        deleteEmployeeCertificate(sessionFactory);
    }
    
    public static void saveEmployeeCertificate(SessionFactory sessionFactory) {
        CertificateManyToMany certificate1 = new CertificateManyToMany("MCA");
        CertificateManyToMany certificate2 = new CertificateManyToMany("FDA");
        Set<CertificateManyToMany> certificates = new HashSet<>(Arrays.asList(certificate1, certificate2));
        EmployeeManyToMany employee = new EmployeeManyToMany();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setSalary(1000);
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
        List<EmployeeManyToMany> employees = session.createQuery("FROM EmployeeManyToMany").list();
        for(EmployeeManyToMany employee : employees) {
            System.out.println(employee);
        }

        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeManyToMany employee = (EmployeeManyToMany) session.get(EmployeeManyToMany.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeManyToMany employee = (EmployeeManyToMany) session.get(EmployeeManyToMany.class, 1);
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }

    
    /*  
    
    DROP TABLE EMPLOYEE_CERTIFICATE_MANY_TO_MANY;
    DROP TABLE CERTIFICATE_MANY_TO_MANY;
    DROP TABLE EMPLOYEE_MANY_TO_MANY;
    
    create table EMPLOYEE_MANY_TO_MANY (
         id SERIAL NOT NULL PRIMARY KEY,
         first_name VARCHAR(20) default NULL,
         last_name  VARCHAR(20) default NULL,
         salary     INT  default NULL);
    
    create table CERTIFICATE_MANY_TO_MANY (
         id SERIAL NOT NULL PRIMARY KEY,
         certificate_name VARCHAR(30) default NULL);
   
   create table EMPLOYEE_CERTIFICATE_MANY_TO_MANY (
       employee_id INT NOT NULL,
       certificate_id INT NOT NULL,
       PRIMARY KEY (employee_id,certificate_id));
       
   */
}
