package Restaurant;

import Restaurant.Complain.LevelProblem;
import Restaurant.Employee.Manager;
import Restaurant.Employee.Waiter;
import Restaurant.Employee.Watchman;
import Restaurant.Information.Eating;
import Restaurant.Information.Menu;
import Restaurant.Information.Restaurant;
import Restaurant.Order.OrderEating;
import Restaurant.Order.Orders;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProgramMain {

    private static Random random = new Random();
    private static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // thông tin nhà hàng
        Restaurant restaurant = Restaurant.getInstance();
        // nhân viên
        Manager manager = Manager.getInstance();
        Watchman watchman = Watchman.getInstance();
        Waiter waiter = Waiter.getInstance();

        String strChoice =
                "\n1. Thoát" +
                "\n2. Đặt món (random)" +
                "\n3. Khiếu nại";

        System.out.println(restaurant.toString());

        int iChoice = 0;
        while (iChoice != 1) {
            System.out.println(strChoice);
            iChoice = sc.nextInt();
            switch (iChoice) {
                case 1 :    // thoát
                    break;
                case 2 :    // order món
                    waiter.setOrder(new OrderEating(orderRandom()));
                    waiter.executeOrder();
                    break;
                case 3 :    // khiếu nại
                    Complain(waiter);
                    break;
                default:
                    break;
            }
        }

    }

    // xử lý khiếu nại của khách hàng
    private static void Complain(Waiter waiter) {
        String strChoice = "";
        int i = 0;
        for (LevelProblem problem : LevelProblem.values()) {
            strChoice += "\n" + i + ". " + problem.getMessage();
            i++;
        }
        strChoice += "\nNhấn số khác để thoát";
        System.out.println(strChoice);
        int level = sc.nextInt();
        for (LevelProblem problem : LevelProblem.values()) {
             if (problem.getLevel() == level) {
                 waiter.process(problem, problem.getMessage());
                 break;
             }
        }
    }

    // lấy về 1 order random
    private static Orders orderRandom() {
        // danh sách món trong menu
        Orders orders = new Orders();
        // random số món
        int count = random.nextInt(Menu.EATINGS.size() - 1) + 1;
        int j = 0;
        while (true) {
            Eating eating = Menu.EATINGS.get(random.nextInt(Menu.EATINGS.size()));
            if (!orders.getEatings().contains(eating)) {
                orders.getEatings().add(new Eating(eating));
                j++;
            }
            if (j == count) break;
        }
        for (Eating eating : orders.getEatings()) {
            eating.setAmount(random.nextInt(100) + 1);
        }
        return orders;
    }

}
