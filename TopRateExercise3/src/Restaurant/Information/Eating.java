package Restaurant.Information;

public class Eating {

    private String name;
    private double price;
    private int amount;

    public Eating(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Eating(Eating eating) {
        this.name = eating.getName();
        this.price = eating.getPrice();
        this.amount = eating.getAmount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) price = 0;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Eating{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
