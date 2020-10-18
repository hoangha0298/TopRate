package Restaurant.Information;

public class Restaurant {

    private final static String DEFAULT_NAME = "NHA HANG HOANG HA";
    private final static String DEFAULT_ADDRESS = "HANG MA, PHO CO, HA NOI";
    private final static Restaurant restaurant = new Restaurant(DEFAULT_NAME, DEFAULT_ADDRESS);

    private String name;
    private String address;

    private Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Restaurant getInstance() {
        return restaurant;
    }

}
