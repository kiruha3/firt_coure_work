package com.kiruha3.list.refactorcoursework.controller;

import com.kiruha3.list.refactorcoursework.Employee;
import com.kiruha3.list.selfexceptions.EmployeeNotFoundException;
import com.kiruha3.list.selfexceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceimpl) {
        this.employeeServiceImpl = employeeServiceimpl;
    }

    @GetMapping()
    public String logInPage() {
        return "Приветствую вас на стартовой странице";
    }

    @GetMapping(path = "/add")
    public String addEmployer(@RequestParam(value = "name", required = false) String name,
                              @RequestParam("surname") String surname) {
        try {
            Employee employee = new Employee(name, surname);
            employeeServiceImpl.addEmployee(employee);
            return "Сотрудник успешно добавлен ";
        } catch (EmployeeStorageIsFullException e) {
            return "что-то не так";
        }
    }

    @GetMapping(path = "/find")
    public String allEmployer(@RequestParam(value = "num",required = false) Integer i) {
        try {
            employeeServiceImpl.findEmployee(i);
            String str = employeeServiceImpl.findEmployee(i).toString();
            return "пользователь под номером " + i + "\n" + str;
        } catch (EmployeeNotFoundException e) {
            return "Какая то ошибка под номером  " + i;
        }
    }

    @GetMapping(path = "/remove")
    public String removeEmployer(@RequestParam(value = "num",required = false) Integer i) {
        try {
            employeeServiceImpl.removeEmployee(i);
            return "Успешно удален пользователем под номером " + i;
        } catch (EmployeeNotFoundException e) {
            return "Какая то ошибка под номером  " + i;
        }
    }

}
