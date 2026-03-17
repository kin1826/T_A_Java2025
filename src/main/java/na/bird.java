package na;


public class bird extends Animal {
    private double wingspan;
    public bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }

    public String bird(double wingspan) {
        return ("độ dài cánh" + wingspan);
    }

    public void showInfo() {

    }

    public void makeSound() {
        System.out.println("chip chip chip chip");
    }
    public void move() {

    }
}
