package com.kiruha3.list.refactorcoursework;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    final Integer maxCountEmployee = 20;
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Ольга", "Васнецова", "Ильинична", 1, 2500.10),
            new Employee("Василий", "Синицин", "Артемьев", 3, 5000),
            new Employee("Инга", "Третьякова", "Владимировна", 4, 1400.43),
            new Employee("Виталя", "Носков", "Владимирович", 3, 3200.14),
            new Employee("Зина", "Зинаидов", "Зинаидовна", 1, 1200),
            new Employee("Уля", "Таккаяко", "Владимировна", 5, 4000.34),
            new Employee("Лена", "Кудрявцева", "Владимировна", 1, 1400.34),
            new Employee("Ида", "Горшановна", "Артемьевна", 1, 1000.20),
            new Employee("Аглая", "Осиповна", "Владимировна", 2, 2500.104),
            new Employee("Зара", "Мальдер", "Ильинична", 3, 3500.1)
    ));
}