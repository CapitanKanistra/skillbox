public class TopManager implements Employee {
    public static int FIX_SALARY = 100_000;

    public int getMonthSalary() {
        return FIX_SALARY + Company.getIncome() > 10_000_000 ? (int) (FIX_SALARY * 1.5) : FIX_SALARY;
    }
}

