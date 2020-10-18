package Restaurant.Employee;

import Restaurant.Complain.LevelProblem;

/*
nhân viên trong nhà hàng
*/
public abstract class Employee {

    public final static String DEFAULT_NAME = "DEFAULT NAME";
    public final static int DEFAULT_OLD = 0;

    // thông tin nhân viên
    private String name;
    private int age;

    // trách nhiệm của nhân viên hiện tại
    protected LevelProblem levelProblem;
    // nhân viên tiếp theo xử lý trách nhiệm
    protected Employee nextEmployeeHandler;

    // khởi tạo bằng thông tin chi tiết
    public Employee(String name, int age, LevelProblem levelProblem) {
        this.name = name;
        this.age = age;
        this.levelProblem = levelProblem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) age = 0;
        this.age = age;
    }

    public LevelProblem getLevelProblem() {
        return levelProblem;
    }

    public void setLevelProblem(LevelProblem levelProblem) {
        this.levelProblem = levelProblem;
    }

    // set người tiếp theo xử lý yêu cầu
    public Employee setNext(Employee nextEmployeeHandler) {
        this.nextEmployeeHandler = nextEmployeeHandler;
        return nextEmployeeHandler;
    }

    // xử lý yêu cầu của khách
    public void process(LevelProblem severity, String msg) {
        if (levelProblem.getLevel() <= severity.getLevel()) {
            writeMessage(msg);
        }
        if (nextEmployeeHandler != null) {
            nextEmployeeHandler.process(severity, msg);
        }
    }

    // cách xử lý chi tiết
    protected abstract void writeMessage(String msg);

}
