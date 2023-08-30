package com.kiruha3.list.refactorcoursework.controller;

import com.kiruha3.list.refactorcoursework.Employee;
import com.kiruha3.list.refactorcoursework.EmployeeService;
import com.kiruha3.list.selfexceptions.EmployeeNotFoundException;
import com.kiruha3.list.selfexceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    private final EmployeeService employeeService;

    public EmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employeeService.employee.size() == employeeService.maxCountEmployee) {
            throw new EmployeeStorageIsFullException();
        } else
            employeeService.employee.add(employee);
    }


    @Override
    public void removeEmployee(Integer i) {
        if (employeeService.employee.size() > i) {
           Employee removeEmpl = employeeService.employee.get(i);
           employeeService.employee.remove(removeEmpl);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(Integer i) {
        if (employeeService.employee.size() <= i) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeService.employee.get(i);
        }

    }
}
