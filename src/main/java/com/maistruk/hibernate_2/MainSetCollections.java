package com.maistruk.hibernate_2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.model.SetCollection.CertificateSet;
import com.maistruk.hibernate_2.model.SetCollection.EmployeeSet;

public class MainSetCollections {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
       // addEmployeCertificate(sessionFactory);
        
       // getEmployeeCertificate(sessionFactory);
        
       // updateEmployee(sessionFactory);
        
       // deleteEmployee(sessionFactory);
        
    }
    
    public static void addEmployeCertificate(SessionFactory sessionFactory) {
        CertificateSet certificate1 = new CertificateSet("MBA");
        CertificateSet certificate2 = new CertificateSet("PMP");
        CertificateSet certificate3 = new CertificateSet("MCA");
        
        //Ordinary Set
        //Set<CertificateSet> certificates = new HashSet<>();
        
        //Sorted Set
        Set<CertificateSet> certificates = new TreeSet<>(new CertificateCompare());
        certificates.add(certificate1);
        certificates.add(certificate2);
        certificates.add(certificate3);
        EmployeeSet employee = new EmployeeSet();
        employee.setFirstName("Roman");
        employee.setLastName("Mai");
        employee.setCertificates(certificates);
        CertificateSet certificate4 = new CertificateSet("PMP");
        CertificateSet certificate5 = new CertificateSet("MCA");
        
        //Ordinary Set
        //Set<CertificateSet> certificates2 = new HashSet<>();
        
        //Sorted Set
        Set<CertificateSet> certificates2 = new TreeSet<>(new CertificateCompare());
        certificates2.add(certificate4);
        certificates2.add(certificate5);
        EmployeeSet employee2 = new EmployeeSet();
        employee2.setFirstName("Vika");
        employee2.setLastName("Mai");
        employee2.setCertificates(certificates2);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.save(employee2);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getEmployeeCertificate(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EmployeeSet> employees = session.createQuery("from EmployeeSet").list();
        for(EmployeeSet employee : employees) {
            System.out.println(employee);
        }
        List<CertificateSet> certificate = session.createQuery("FROM CertificateSet").list();
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeSet employee = (EmployeeSet)session.get(EmployeeSet.class, 1);
        employee.setLastName("Maistruk");
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void deleteEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeSet employee = (EmployeeSet)session.get(EmployeeSet.class, 1);
        session.delete(employee);
        EmployeeSet employee2 = (EmployeeSet)session.get(EmployeeSet.class, 2);
        session.delete(employee2);
        session.getTransaction().commit();
        session.close();
    }

}
