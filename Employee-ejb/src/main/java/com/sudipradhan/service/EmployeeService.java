/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudipradhan.service;

import com.sudipradhan.entity.Employee;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee findByName(String name);

    public Employee addEmployee(String name, String address);

    public Employee updateEmployee(int id, String name, String address);

    public Employee deleteById(int id);

}
