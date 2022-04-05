/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudipradhan.employeedaoimp;

import com.sudipradhan.employeedao.EmployeeDao;
import com.sudipradhan.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
@Stateless
public class EmployeeDaoImp implements EmployeeDao {

    @PersistenceContext(unitName = "employee")
    EntityManager em;

//    finding list of employees
    @Override
    public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("Employee.findAll");
            employee = query.getResultList();

        } catch (Exception e) {
            System.out.println(e);

        }
        return employee;
    }

    //    find the employee with the id
    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            Query query = em.createNamedQuery("Employee.findById");
            query.setParameter("id", id);
            employee = (Employee) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e);

        }
        return employee;

    }

    @Override
    public Employee findByName(String name) {
        Employee emp = null;

        try {
            Query query = em.createNamedQuery("Employee.findByName");
            query.setParameter("name", name);
            emp = (Employee) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e);

        }
        return emp;
    }

    //    add the employee to the employee list
    @Override
    public Employee addEmployee(String name, String address) {
        Employee emp = null;
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        em.persist(employee);
        return emp;

    }


    @Override
    public Employee deleteById(int id) {
        Employee emp = null;
        try {
            Query query = em.createNamedQuery("Employee.findById");
            query.setParameter("id", id);
            Employee employee = (Employee) query.getSingleResult();
            if (employee != null) {
                em.remove(employee);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return emp;
    }

    @Override
    public Employee updateEmployee(int id, String name, String address) {
        Employee emp = null;
        try {
            System.out.println("Name : " + name);

            Query q = em.createNamedQuery("Employee.findById");
            q.setParameter("id", id);

            Employee e = (Employee) q.getSingleResult();

            if (e != null) {
                boolean isPresent = findEmployeeByName(name);
                if (isPresent) {
                    System.out.println(name + " already exists !!");
                } else {
                    System.out.println(name + " does not exists !! ");
                    e.setName(name);
                    e.setAddress(address);
                    em.merge(e);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return emp;
    }
    
    //by jikesh dai
    public boolean findEmployeeByName(String name) {
        try {
            Query q = em.createNamedQuery("Employee.findByName");
            q.setParameter("name", name.trim());

            List<Employee> employees = q.getResultList();
            if (employees.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
            return false;
        }
    }

}
