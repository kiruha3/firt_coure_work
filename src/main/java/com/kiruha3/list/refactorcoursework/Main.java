package com.kiruha3.list.refactorcoursework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        enterEmployer(employeeService.employee);
        System.out.println("");
        float indexPercentPayday = 0.12f;
        System.out.println("------Индексация всех сотрудников на "
                + (indexPercentPayday * 100) + " процентов ");
        indexPayDay(employeeService.employee, indexPercentPayday);
        enterEmployer(employeeService.employee);

        int departmentForTest = 3;
        System.out.println("------");
        System.out.println("Минимальная зп - minSalaryToDepartment(employee,departmentForTest) = " +
                minSalaryToDepartment(employeeService.employee, departmentForTest));
        System.out.println("");
        System.out.println("Максимальная зп - maxSalaryToDepartment(employee,departmentForTest) = " +
                maxSalaryToDepartment(employeeService.employee, departmentForTest));
        System.out.println("");
        System.out.println(String.format("Сумма затрат на отдел по зп - summPayDayToDepartment(employee, %s) = %.2f",
                departmentForTest, summPayDayToDepartment(employeeService.employee, departmentForTest)));
        System.out.println("");
        System.out.println(String.format("Средняя зарплата по отделу - midPayDayPerMonthToDepartment(employee, %s) = %.2f",
                departmentForTest, midPayDayPerMonthToDepartment(employeeService.employee, departmentForTest)));

        float indexPercentPaydayToDepartment = 0.20f;
        System.out.println("------Индексация " + departmentForTest + "-того отдела на "
                + (indexPercentPaydayToDepartment * 100) + " процентов ");
        indexPayDaytoDepartment(employeeService.employee, indexPercentPaydayToDepartment, departmentForTest);
        enterEmployerWithoutDepartment(employeeService.employee, departmentForTest);
        System.out.println("");
        double payDayLessThenNumber = 3000.50;
        System.out.println("Всех сотрудников с зарплатой меньше числа " + payDayLessThenNumber);
        double payDayMoreOrEquareThenNumber = 3100.50;
        findAllEmployeeLessThenNumber(employeeService.employee, payDayLessThenNumber);
        System.out.println("");
        System.out.println("Всех сотрудников с зарплатой больше ли равной числу " + payDayMoreOrEquareThenNumber);
        findAllEmployeeMoreOrEquareThenNumber(employeeService.employee, payDayMoreOrEquareThenNumber);

    }

    private static void findAllEmployeeMoreOrEquareThenNumber(List<Employee> employee, double payDayMoreOrEquareThenNumber) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getPayday() >= payDayMoreOrEquareThenNumber) {
                System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                        employee.get(i).getId(),
                        employee.get(i).getName(),
                        employee.get(i).getSurname(),
                        employee.get(i).getPatronymic(),
                        employee.get(i).getPayday());
            }
        }
    }

    private static void findAllEmployeeLessThenNumber(List<Employee> employee, double payDayLessThenNumber) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getPayday() < payDayLessThenNumber) {
                System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                        employee.get(i).getId(),
                        employee.get(i).getName(),
                        employee.get(i).getSurname(),
                        employee.get(i).getPatronymic(),
                        employee.get(i).getPayday());
            }
        }
    }


    public static void enterEmployer(List<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            System.out.printf("Номер %s = %s%n", i, employee.get(i).toString());
        }
    }

    private static void enterEmployerWithoutDepartment(List<Employee> employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            System.out.printf("Сотрудники департамента №%s%n", department);
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                            employee.get(i).getId(),
                            employee.get(i).getName(),
                            employee.get(i).getSurname(),
                            employee.get(i).getPatronymic(),
                            employee.get(i).getPayday());
                }
            }
        } else System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");

    }


    public static double summPayDay(List<Employee> employee) {
        double summ = 0;
        for (int i = 0; i < employee.size(); i++) {
            summ += employee.get(i).getPayday();
        }
        return summ;
    }

    public static double summPayDayToDepartment(List<Employee> employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            double summ = 0;
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    summ += employee.get(i).getPayday();
                }
            }
            return summ;
        } else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return 0;
        }
    }

    public static Employee minSalary(List<Employee> employee) {
        Employee minSalary = employee.get(0);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getPayday() < minSalary.getPayday()) {
                minSalary = employee.get(i);
            }
        }
        return minSalary;
    }

    public static Employee minSalaryToDepartment(List<Employee> employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            Employee minSalaryToDepartment;
            int counterFormethod = 0;
            while (true) {
                if (employee.get(counterFormethod).getDepartment() == department) {
                    minSalaryToDepartment = employee.get(counterFormethod);
                    break;
                }
                counterFormethod++;
            }
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    if (employee.get(i).getPayday() < minSalaryToDepartment.getPayday()) {
                        minSalaryToDepartment = employee.get(i);
                    }
                }
            }
            return minSalaryToDepartment;
        } else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return null;
        }
    }

    public static Employee maxSalary(List<Employee> employee) {
        Employee maxSalary = employee.get(0);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getPayday() > maxSalary.getPayday()) {
                maxSalary = employee.get(i);
            }
        }
        return maxSalary;
    }

    public static Employee maxSalaryToDepartment(List<Employee> employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            Employee maxSalaryToDepartment;
            int counterForMethod = 0;
            while (true) {
                if (employee.get(counterForMethod).getDepartment() == department) {
                    maxSalaryToDepartment = employee.get(counterForMethod);
                    break;
                }
                counterForMethod++;
            }
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    if (employee.get(i).getPayday() > maxSalaryToDepartment.getPayday()) {
                        maxSalaryToDepartment = employee.get(i);
                    }
                }
            }
            return maxSalaryToDepartment;
        } else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return null;
        }
    }

    public static double midPayDayPerMonth(List<Employee> employee) {
        EmployeeService employeeService = new EmployeeService();
        return (double) summPayDay(employeeService.employee) / employee.size();
    }

    public static double midPayDayPerMonthToDepartment(List<Employee> employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            int counterForMethod = 0;
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    counterForMethod++;
                }
            }
            return (double) summPayDayToDepartment(employee, department) / counterForMethod;
        } else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return 0;


        }
    }

    public static void personalFIO(List<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            System.out.printf("Фамилия: %s Имя: %s Отчетсво: %s %n", employee.get(i).getSurname(), employee.get(i).getName(), employee.get(i).getPatronymic());
        }
    }

    public static void indexPayDay(List<Employee> employee, float indexPercent) {
        for (int i = 0; i < employee.size(); i++) {
            employee.get(i).setPayday(employee.get(i).getPayday() * (1 + indexPercent));
        }
    }

    public static void indexPayDaytoDepartment(List<Employee> employee, float indexPercentToDepartment, int department) {
        int counter = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getDepartment() == department) {
                    employee.get(i).setPayday(employee.get(i).getPayday() * (1 + indexPercentToDepartment));
                }
            }
        } else System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
    }

}