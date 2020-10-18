package Restaurant.Order;

import Restaurant.Information.Eating;
import Restaurant.Information.Menu;

// xử lý yêu cầu order đồ ăn của khách
public class OrderEating implements Command {
    Orders orders;

    public OrderEating(Orders orders) {
        this.orders = orders;
    }

    // thực hiện yêu cầu lấy món ăn
    @Override
    public void execute() {
        orders.println();
        for (Eating eating : orders.getEatings()) {
            Eating eatingInMenu = null;
            // lấy ra món trong menu ( để so sánh số lương)
            for (Eating eating1 : Menu.EATINGS) {
                if (eating1.getName() == eating.getName()) {
                    eatingInMenu = eating1;
                    break;
                }
            }
            // số lượng của món ăn còn lại < số lượng đặt
            if (eating.getAmount() > eatingInMenu.getAmount())
                eating.setAmount(0);
        }
        System.out.println("Trả cho khách :");
        orders.println();
    }

}
