package com.example.employeemanager.service;

import com.example.employeemanager.Exception.ApiRequestException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private static Long iid=0L;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setId(++iid);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(
                        ()->new ApiRequestException("User By id "+id+" was not found")
                        //() -> new IllegalStateException("Ooops there is no employee with the id "+id)
                );
    }

    public Employee updateEmployee(Employee employee,Long id) {
        Employee updatedEmployee =employeeRepo.findEmployeeById(id)
                .orElseThrow(
                        ()->new ApiRequestException("User By id "+id+" was not found")
                );
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setImageUrl(employee.getImageUrl());
        updatedEmployee.setJobTitle(employee.getJobTitle());
        updatedEmployee.setPhone(employee.getPhone());
        return employeeRepo.save(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }




}
