package Restaurant.Employee;

import Restaurant.Complain.LevelProblem;

public class Manager extends Employee{

    /*
    chỉ có 1 giám đốc (employee)
    có thể thay đổi giám đốc setEmployee
    */
    private final static LevelProblem LEVEL_PROBLEM_DEFAULT = LevelProblem.FATAL;

    private static Manager manager = new Manager(DEFAULT_NAME, DEFAULT_OLD);

    private Manager(String name, int age) {
        super(name, age, LEVEL_PROBLEM_DEFAULT);
    }

    public static Manager getInstance() {
        return manager;
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("----------------------------");
        System.out.println("Manage process " + msg);
    }
}
