package com.kiruha3.list.refactorcoursework;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private int department;
    private double payday;
    public static int i = 0;

    public Employee(String name, String surname, String patronymic, int department, double payday) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.payday = payday;
        this.id = i++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getPayday() {
        return payday;
    }
    public void setPayday(double payday) {
        this.payday = payday;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return String.format("Идентефикатор : [%s] | Ф.И.О %s %s %s |, отдел %s, зарплата %.2f",
                getId(),
                getName(),
                getSurname(),
                getPatronymic(),
                getDepartment(),
                getPayday() );
    }


}
