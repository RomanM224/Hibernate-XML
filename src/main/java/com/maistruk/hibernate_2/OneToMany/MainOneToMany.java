package com.maistruk.hibernate_2.OneToMany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainOneToMany {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
       // saveEmployeeCertificate(sessionFactory);
        
      //  getEmployeeCertificate(sessionFactory);
        
      //  updateEmployeeCertificate(sessionFactory);
        
        deleteEmployeeCertificate(sessionFactory);
        

    }
    
    public static void saveEmployeeCertificate(SessionFactory sessionFactory) {
        CertificateOneToMany certificate1 = new CertificateOneToMany("CPA");
        CertificateOneToMany certificate2 = new CertificateOneToMany("MMP");
        Set<CertificateOneToMany> certificates = new HashSet<>(Arrays.asList(certificate1, certificate2));
        EmployeeOneToMany employee = new EmployeeOneToMany();
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
        List<EmployeeOneToMany> employees = session.createQuery("FROM EmployeeOneToMany").list();
        for(EmployeeOneToMany employee : employees) {
            System.out.println(employee);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeOneToMany employee = (EmployeeOneToMany) session.get(EmployeeOneToMany.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);
        session.getTransaction().commit();
    }
    
    public static void deleteEmployeeCertificate(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeOneToMany employee = (EmployeeOneToMany) session.get(EmployeeOneToMany.class, 1);
        session.delete(employee);
        session.getTransaction().commit();
    }
    
    /*  
     
      DROP TABLE CERTIFICATE_ONE_TO_MANY;
      DROP TABLE EMPLOYEE_ONE_TO_MANY;
      
      create table EMPLOYEE_ONE_TO_MANY (
           id SERIAL NOT NULL PRIMARY KEY,
           first_name VARCHAR(20) default NULL,
           last_name  VARCHAR(20) default NULL,
           salary     INT  default NULL);
      
      create table CERTIFICATE_ONE_TO_MANY (
           id SERIAL NOT NULL PRIMARY KEY,
           certificate_name VARCHAR(30) default NULL,
           employee_id INT default NULL,
           FOREIGN KEY (employee_id) REFERENCES employee_one_to_many(id));
     
     */

}
