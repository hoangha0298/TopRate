package Restaurant.Information;

import java.util.ArrayList;

public class Menu {

    public final static ArrayList<Eating> EATINGS = new ArrayList<>();

    static {
        EATINGS.add(new Eating("Bò bít tết", 200000, 30));
        EATINGS.add(new Eating("Tôm hùm", 300000, 30));
        EATINGS.add(new Eating("Ghẹ", 300000, 0));
        EATINGS.add(new Eating("Trứng rán", 20000, 100));
        EATINGS.add(new Eating("Mì Tôm", 10000, 300));
        EATINGS.add(new Eating("bánh mỳ", 15000, 300));
        EATINGS.add(new Eating("CƠm trắng", 15000, 300));
    }

    private Menu() {
    }

}
