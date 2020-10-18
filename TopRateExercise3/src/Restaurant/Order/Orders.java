package Restaurant.Order;

import Restaurant.Information.Eating;

import java.util.ArrayList;

// danh sách mua hàng (món ăn của khách)
public class Orders {

    // danh sách các món và số lượng từng món
    private ArrayList<Eating> eatings;
    // giảm giá ( chưa dùng tới)
    private double discountMoney;
    private double discountPersent;

    public Orders() {
        eatings = new ArrayList<>();
        discountMoney = 0;
        discountPersent = 0;
    }

    public ArrayList<Eating> getEatings() {
        return eatings;
    }

    public double getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(double discountMoney) {
        this.discountMoney = discountMoney;
    }

    public double getDiscountPersent() {
        return discountPersent;
    }

    public void setDiscountPersent(double discountPersent) {
        this.discountPersent = discountPersent;
    }

    // báo cáo danh sách món và số lượng
    public void println () {
        String invoice = "";
        for (Eating eating : eatings) {
            invoice += getStringConstLength(eating.getName(), 23) + "| " + eating.getAmount() + '\n';
        }
        System.out.println(invoice);
    }

    // convert một String với độ dài nhỏ nhất bằng length, nếu ít hơn thêm khoảng cách vào sau
    private String getStringConstLength(String s, int length) {
        String result = new String(s);
        for (int i=s.length(); i<length; i++) {
            result += " ";
        }
        return result;
    }

    // thanh toán (chưa dùng)
    public void getInvoice () {
        String invoice = "";
        double totalMoney = 0;
        double moneyOfOneEating;
        for (Eating eating : eatings) {
            moneyOfOneEating = eating.getPrice() * eating.getAmount();
            totalMoney += moneyOfOneEating;
            invoice += eating.getName() + "  " + moneyOfOneEating + '\n';
        }
        invoice += "Total money  " + totalMoney + '\n';
        System.out.println(invoice);
    }

}
