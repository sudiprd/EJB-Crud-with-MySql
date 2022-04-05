/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudipradhan.serviceimp;

import com.sudipradhan.employeedao.EmployeeDao;
import com.sudipradhan.entity.Employee;
import com.sudipradhan.service.EmployeeService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dell
 */
@Stateless
public class EmployeeServiceImp implements EmployeeService {

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();

    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public Employee addEmployee(String name, String address) {
       return  employeeDao.addEmployee(name, address);

    }

    @Override
    public Employee updateEmployee(int id, String name, String address) {
       return employeeDao.updateEmployee(id, name, address);
       
        
    }

    @Override
    public Employee deleteById(int id) {
        return employeeDao.deleteById(id);
    }

    @Override
    public Employee findByName(String name) {
        return this.employeeDao.findByName(name);
    }



}
