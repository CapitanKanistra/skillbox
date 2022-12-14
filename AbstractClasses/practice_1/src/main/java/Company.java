import java.util.*;

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public static int getIncome() {
        return 1_000;
    }


    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> highestSalary = new ArrayList<>(employees);
        highestSalary.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        return highestSalary.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> lowestSalary = new ArrayList<>(employees);
        lowestSalary.sort(Comparator.comparing(Employee::getMonthSalary));
        return lowestSalary.subList(0, count);
    }

    public int countEmployees() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
