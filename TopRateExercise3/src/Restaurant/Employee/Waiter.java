package Restaurant.Employee;

import Restaurant.Complain.LevelProblem;
import Restaurant.Order.Command;

public class Waiter extends Employee {

    /*
    mỗi ca chỉ có 1 phục vụ (employee)
    các ca có thể là employee là khác nhau ( có thể thay đổi setEmployee )
    */
    private final static LevelProblem LEVEL_PROBLEM_DEFAULT = LevelProblem.DEPORTMENT;
    private static Waiter waiter;

    // thực thi yêu cầu order của khách
    private Command order;

    // set luồng trách nhiệm xử lý vấn đề của khách
    static {
        waiter = new Waiter(DEFAULT_NAME, DEFAULT_OLD);
        waiter.setNext(Watchman.getInstance());
        Watchman.getInstance().setNext(Manager.getInstance());
    }

    private Waiter(String name, int age) {
        super(name, age, LEVEL_PROBLEM_DEFAULT);
    }

    public static Waiter getInstance() {
        return waiter;
    }

    // xác nhận order của khách
    public void setOrder(Command order) {
        this.order = order;
    }

    // gọi món cho khách
    public void executeOrder() {
        System.out.println("Khách hàng gọi món, (nếu số lượng món không đủ thì trả về 0)");
        order.execute();
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("----------------------------");
        System.out.println("Waiter process " + msg);
    }

}
