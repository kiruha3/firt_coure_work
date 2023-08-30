package com.kiruha3.list.refactorcoursework;

import com.kiruha3.list.refactorcoursework.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public final Integer maxCountEmployee = 20;
    public List<Employee> employee = new ArrayList<>(List.of(
                new Employee("Ольга", "Васнецова"),
                new Employee("Василий", "Синицин"),
                new Employee("Инга", "Третьякова"),
                new Employee("Виталя", "Носков"),
                new Employee("Зина", "Зинаидов"),
                new Employee("Уля", "Таккаяко"),
                new Employee("Лена", "Кудрявцева"),
                new Employee("Ида", "Горшановна"),
                new Employee("Аглая", "Осиповна"),
                new Employee("Зара", "Мальдер")
        ));



    @Override
    public String toString() {
        return "EmployeeService{" +
                "maxCountEmployee=" + maxCountEmployee +
                ", employee=" + employee +
                "} " + super.toString();
    }
}