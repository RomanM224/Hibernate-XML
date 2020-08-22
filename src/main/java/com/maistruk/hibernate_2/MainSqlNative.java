package com.maistruk.hibernate_2;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.maistruk.hibernate_2.model.Employee;

public class MainSqlNative {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        
        //getScalarValues(sessionFactory);
        
        getEntityValues(sessionFactory);
        
        //getByNamedQuery(sessionFactory);
        
    }
    
    public static void getScalarValues(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String sql = "SELECT first_name, salary FROM EMPLOYEE";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();
        for(Object object : results) {
            Map row = (Map)object;
            System.out.print("First Name: " + row.get("first_name")); 
            System.out.println(", Salary: " + row.get("salary")); 
         }        
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getEntityValues(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String sql = "SELECT * FROM EMPLOYEE";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        List<Employee> results = query.list();
        for(Employee employee : results) {
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary());
        }
        
        session.getTransaction().commit();
        session.close();
    }
    
    public static void getByNamedQuery(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        query.setParameter("employee_id", 2);
        List results = query.list();
        System.out.println(results);
        
        session.getTransaction().commit();
        session.close();
    }
    


}
