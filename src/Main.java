public class Main {
    public static void main(String[] args) {
        Employee olga = new Employee("olga", "takayato", "takayatovna", 1, 2500.10);
        Employee vasya = new Employee("vasya", "takayato", "takayatovna", 5, 5000);
        Employee inga = new Employee("olga", "takayato", "takayatovna", 1, 1400);
        Employee vitaly = new Employee("vasya", "takayato", "takayatovna", 3, 3200);
        Employee zina = new Employee("olga", "takayato", "takayatovna", 1, 1200);
        Employee ula = new Employee("vasya", "takayato", "takayatovna", 4, 4000);
        Employee lena = new Employee("lena", "takayato", "takayatovna", 1, 1400);
        Employee ida = new Employee("ida", "takayato", "takayatovna", 1, 1000);
        Employee aglaya = new Employee("aglaya", "takayato", "takayatovna", 2, 2500.10);
        Employee zara = new Employee("zara", "takayato", "takayatovna", 3, 3500.1);
        Employee[] employee = new Employee[]{olga, vasya, inga, vitaly, zina, ula, lena, ida, aglaya, zara};
        enterEmployer(employee);
        System.out.println("Сумму затрат на зарплаты в месяц: " + summPayDay(employee));
    }
    public static void enterEmployer (Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.printf("employee[%s] = %s%n", i, employee[i].toString());
        }
    }
    public static int summPayDay(Employee[] employee){
        int summ=0;
        for (int i = 0; i < employee.length; i++) {
            summ+= employee[i].getPayday();
        }
        return summ;
    }

}