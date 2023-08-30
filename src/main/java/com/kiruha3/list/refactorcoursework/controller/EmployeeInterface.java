package com.kiruha3.list.refactorcoursework.controller;

import com.kiruha3.list.refactorcoursework.Employee;

public interface EmployeeInterface {
    void addEmployee(Employee employee);

    void removeEmployee(Integer i);

    Employee findEmployee(Integer i);
}
