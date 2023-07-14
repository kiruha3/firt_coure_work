import java.rmi.dgc.VMID;

public class Main {
    public static void main(String[] args) {
        Employee olga = new Employee("Ольга", "Васнецова", "Ильинична", 1, 2500.10);
        Employee vasya = new Employee("Василий", "Синицин", "Артемьев", 3, 5000);
        Employee inga = new Employee("Инга", "Третьякова", "Владимировна", 1, 1400.43);
        Employee vitaly = new Employee("Виталя", "Носков", "Владимирович", 3, 3200.14);
        Employee zina = new Employee("Зина", "Зинаидов", "Зинаидовна", 1, 1200);
        Employee ula = new Employee("Уля", "Таккаяко", "Владимировна", 4, 4000.34);
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
        float indexPercentPayday = 0.12f;
        System.out.println("(\"------\") = " + ("------"));
        indexPayDay(employee, indexPercentPayday);
        enterEmployer(employee);
        System.out.println("minSalaryToDepartment(employee,2) = " + minSalaryToDepartment(employee, 1));
        System.out.println("maxSalaryToDepartment(employee,3) = " + maxSalaryToDepartment(employee, 3));
        System.out.println(String.format("summPayDayToDepartment(employee,3) = %.2f", summPayDayToDepartment(employee, 3)));
        System.out.println(String.format("midPayDayPerMonthToDepartment(employee,3) = %.2f", midPayDayPerMonthToDepartment(employee, 3) ));
    }

    public static void enterEmployer(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.printf("Номер %s = %s%n", i, employee[i].toString());
        }
    }

    public static double summPayDay(Employee[] employee) {
        double summ = 0;
        for (int i = 0; i < employee.length; i++) {
            summ += employee[i].getPayday();
        }
        return summ;
    }

    public static double summPayDayToDepartment(Employee[] employee, int department) {
        double summ = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                summ += employee[i].getPayday();
            }
            ;
        }
        return summ;
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
        Employee minSalaryToDepartment;
        int counter = 0;
        while (true) {
            if (employee[counter].getDepartment() == department) {
                minSalaryToDepartment = employee[counter];
                break;
            }
            counter++;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                if (employee[i].getPayday() < minSalaryToDepartment.getPayday()) {
                    minSalaryToDepartment = employee[i];
                }
            }
        }
        return minSalaryToDepartment;
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
        Employee maxSalaryToDepartment;
        int counter = 0;
        while (true) {
            if (employee[counter].getDepartment() == department) {
                maxSalaryToDepartment = employee[counter];
                break;
            }
            counter++;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                if (employee[i].getPayday() > maxSalaryToDepartment.getPayday()) {
                    maxSalaryToDepartment = employee[i];
                }
            }
        }
        return maxSalaryToDepartment;
    }

    public static double midPayDayPerMonth(Employee[] employee) {
        return (double) summPayDay(employee) / employee.length;
    }

    public static double midPayDayPerMonthToDepartment(Employee[] employee, int department) {
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == department) {
                counter++;
            }
        }
        return (double) summPayDayToDepartment(employee, department) / counter;
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


}