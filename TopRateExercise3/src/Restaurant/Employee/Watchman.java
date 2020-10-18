package Restaurant.Employee;

import Restaurant.Complain.LevelProblem;

public class Watchman extends Employee {

    /*
    mỗi ca chỉ có 1 ng trực (employee)
    các ca có thể là employee là khác nhau ( có thể thay đổi setEmployee )
    */
    private final static LevelProblem LEVEL_PROBLEM_DEFAULT = LevelProblem.HYGIENE;

    private static Watchman watchman = new Watchman(DEFAULT_NAME, DEFAULT_OLD);

    private Watchman(String name, int age) {
        super(name, age, LEVEL_PROBLEM_DEFAULT);
    }

    public static Watchman getInstance() {
        return watchman;
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("----------------------------");
        System.out.println("Watchman process " + msg);
    }
}
