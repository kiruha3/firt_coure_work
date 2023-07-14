import java.rmi.dgc.VMID;

public class Main {
    public static void main(String[] args) {
        Employee olga = new Employee("Ольга", "Васнецова", "Ильинична", 1, 2500.10);
        Employee vasya = new Employee("Василий", "Синицин", "Артемьев", 3, 5000);
        Employee inga = new Employee("Инга", "Третьякова", "Владимировна", 4, 1400.43);
        Employee vitaly = new Employee("Виталя", "Носков", "Владимирович", 3, 3200.14);
        Employee zina = new Employee("Зина", "Зинаидов", "Зинаидовна", 1, 1200);
        Employee ula = new Employee("Уля", "Таккаяко", "Владимировна", 5, 4000.34);
        Employee lena = new Employee("Лена", "Кудрявцева", "Владимировна", 1, 1400.34);
        Employee ida = new Employee("Ида", "Горшановна", "Артемьевна", 1, 1000.20);
        Employee aglaya = new Employee("Аглая", "Осиповна", "Владимировна", 2, 2500.104);
        Employee zara = new Employee("Зара", "Мальдер", "Ильинична", 3, 3500.1);
        Employee[] employee = new Employee[]{olga, vasya, inga, vitaly, zina, ula, lena, ida, aglaya, zara};
        enterEmployer(employee);
//        System.out.println("Сумму затрат на зарплаты в месяц: " + summPayDay(employee));
//        System.out.println("Минимальный размер зарпалата у сотрудника " + minSalary(employee).toString());
//        System.out.println("Максимальный размер зарпалаты у сотрудника " + maxSalary(employee).toString());
//        System.out.println("Cреднее значение зарплат " + midPayDayPerMonth(employee));
//        personalFIO(employee);
        System.out.println("");
        float indexPercentPayday = 0.12f;
        System.out.println("------Индексация всех сотрудников на "
                + (indexPercentPayday * 100) + " процентов ");
        indexPayDay(employee, indexPercentPayday);
        enterEmployer(employee);

        int departmentForTest = 3;
        System.out.println("------");
        System.out.println("Минимальная зп - minSalaryToDepartment(employee,departmentForTest) = " + minSalaryToDepartment(employee, departmentForTest));
        System.out.println("");
        System.out.println("Максимальная зп - maxSalaryToDepartment(employee,departmentForTest) = " + maxSalaryToDepartment(employee, departmentForTest));
        System.out.println("");
        System.out.println(String.format("Сумма затрат на отдел по зп - summPayDayToDepartment(employee, %s) = %.2f", departmentForTest, summPayDayToDepartment(employee, departmentForTest)));
        System.out.println("");
        System.out.println(String.format("Средняя зарплата по отделу - midPayDayPerMonthToDepartment(employee, %s) = %.2f", departmentForTest, midPayDayPerMonthToDepartment(employee, departmentForTest)));

        float indexPercentPaydayToDepartment = 0.20f;
        System.out.println("------Индексация " + departmentForTest + "-того отдела на "
                + (indexPercentPaydayToDepartment * 100) + " процентов ");
        indexPayDaytoDepartment(employee, indexPercentPaydayToDepartment, departmentForTest);
        enterEmployerWithoutDepartment(employee, departmentForTest);
        System.out.println("");
        double payDayLessThenNumber = 3000.50;
        System.out.println("Всех сотрудников с зарплатой меньше числа " + payDayLessThenNumber);
        double payDayMoreOrEquareThenNumber = 3100.50;
        findAllEmployeeLessThenNumber(employee, payDayLessThenNumber);
        System.out.println("");
        System.out.println("Всех сотрудников с зарплатой больше ли равной числу " + payDayMoreOrEquareThenNumber);
        findAllEmployeeMoreOrEquareThenNumber(employee, payDayMoreOrEquareThenNumber);

    }

    private static void findAllEmployeeMoreOrEquareThenNumber(Employee[] employee, double payDayMoreOrEquareThenNumber) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getPayday() >= payDayMoreOrEquareThenNumber) {
                System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                        employee[i].getId(),
                        employee[i].getName(),
                        employee[i].getSurname(),
                        employee[i].getPatronymic(),
                        employee[i].getPayday());
            }
        }
    }

    private static void findAllEmployeeLessThenNumber(Employee[] employee, double payDayLessThenNumber) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getPayday() < payDayLessThenNumber) {
                System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                        employee[i].getId(),
                        employee[i].getName(),
                        employee[i].getSurname(),
                        employee[i].getPatronymic(),
                        employee[i].getPayday());
            }
        }
    }


    public static void enterEmployer(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.printf("Номер %s = %s%n", i, employee[i].toString());
        }
    }

    private static void enterEmployerWithoutDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            System.out.printf("Сотрудники департамента №%s%n", department);
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    System.out.printf("Айди :%s|Ф.И.О - %s %s %s| Зарплата :%.2f%n",
                            employee[i].getId(),
                            employee[i].getName(),
                            employee[i].getSurname(),
                            employee[i].getPatronymic(),
                            employee[i].getPayday());
                }
            }
        } else System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");

    }


    public static double summPayDay(Employee[] employee) {
        double summ = 0;
        for (int i = 0; i < employee.length; i++) {
            summ += employee[i].getPayday();
        }
        return summ;
    }

    public static double summPayDayToDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            double summ = 0;
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    summ += employee[i].getPayday();
                }
            }
            return summ;
        } else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return 0;
        }
    }

    public static Employee minSalary(Employee[] employee) {
        Employee minSalary = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getPayday() < minSalary.getPayday()) {
                minSalary = employee[i];
            }
        }
        return minSalary;
    }

    public static Employee minSalaryToDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            Employee minSalaryToDepartment;
            int counterFormethod = 0;
            while (true) {
                if (employee[counterFormethod].getDepartment() == department) {
                    minSalaryToDepartment = employee[counterFormethod];
                    break;
                }
                counterFormethod++;
            }
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    if (employee[i].getPayday() < minSalaryToDepartment.getPayday()) {
                        minSalaryToDepartment = employee[i];
                    }
                }
            }
            return minSalaryToDepartment;
        }else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return null;
        }
    }

    public static Employee maxSalary(Employee[] employee) {
        Employee maxSalary = employee[0];
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getPayday() > maxSalary.getPayday()) {
                maxSalary = employee[i];
            }
        }
        return maxSalary;
    }

    public static Employee maxSalaryToDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            Employee maxSalaryToDepartment;
            int counterForMethod = 0;
            while (true) {
                if (employee[counterForMethod].getDepartment() == department) {
                    maxSalaryToDepartment = employee[counterForMethod];
                    break;
                }
                counterForMethod++;
            }
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    if (employee[i].getPayday() > maxSalaryToDepartment.getPayday()) {
                        maxSalaryToDepartment = employee[i];
                    }
                }
            }
            return maxSalaryToDepartment;
        }else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return null;
        }
    }

    public static double midPayDayPerMonth(Employee[] employee) {
        return (double) summPayDay(employee) / employee.length;
    }

    public static double midPayDayPerMonthToDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            int counterForMethod = 0;
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    counterForMethod++;
                }
            }
            return (double) summPayDayToDepartment(employee, department) / counterForMethod;
        }else {
            System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
            return 0;
        }
    }

    public static void personalFIO(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.printf("Фамилия: %s Имя: %s Отчетсво: %s %n", employee[i].getSurname(), employee[i].getName(), employee[i].getPatronymic());
        }
    }

    public static void indexPayDay(Employee[] employee, float indexPercent) {
        for (int i = 0; i < employee.length; i++) {
            employee[i].setPayday(employee[i].getPayday() * (1 + indexPercent));
        }
    }

    public static void indexPayDaytoDepartment(Employee[] employee, float indexPercentToDepartment, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
                break;
            }
        }
        if (counter > 0) {
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getDepartment() == department) {
                    employee[i].setPayday(employee[i].getPayday() * (1 + indexPercentToDepartment));
                }
            }
        }else System.out.println("Ошибка! перепроверьте данные! В данном отделе нет сотруднков");
    }

}