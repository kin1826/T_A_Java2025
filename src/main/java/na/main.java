package na;

import java.util.ArrayList;

public class main {
    ArrayList<Animal> animals = new ArrayList<>();
    public static void main(String[] args) {
        Animal A1 = new Elephant("Chung",19,20.0);
        Animal A2 = new Lion("Thuy",17,15.0);
        Animal A3 = new bird("hoa nam", 19, 20);
        A1.showInfo();
        A2.showInfo();
        A3.showInfo();
    }
}
