package com.maistruk.hibernate_2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.model.Employee;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        LocalTime time = LocalTime.now();
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
      //  addEmploye(sessionFactory);
        
      //  addEmployeeQuery(sessionFactory);
        
      // getListEmployees(sessionFactory);
        
        getEmployee(sessionFactory);
        
     //   deleteEmployee(sessionFactory);
        
     //   deleteEmployeeQuery(sessionFactory);
        
     //   updateEmployee(sessionFactory);
        
        LocalTime time2 = LocalTime.now();
        System.out.println(Duration.between(time, time2).toMillis() / 1000);
    }
    
    public static void addEmploye(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = new Employee("Zara", "Ali", 1000);
        session.save(employee);
        employee = new Employee("Daisy", "Das", 5000);
        session.save(employee);
        employee = new Employee("John", "Paul", 10000);
        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }
    
    public static void addEmployeeQuery(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("INSERT INTO employee (id, first_name, last_name, salary) VALUES(DEFAULT, 'Roman', 'Mai', 123)");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getListEmployees(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> employies = query.list();
      //  session.getTransaction().commit();
        System.out.println(employies);
    }
    
    public static void getEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, 3);
        session.getTransaction().commit();
        session.close();
        System.out.println(employee);
    }
    
    public static void deleteEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, 2);
        if(employee != null) {
            session.delete(employee);
            session.getTransaction().commit();
            session.close();
        }
    }
    
    public static void deleteEmployeeQuery(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("DELETE FROM employee WHERE id = 1");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    
    public static void updateEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, 3);
        employee.setSalary(532);
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

}

