package EX2_GK;

public class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, int age, double wingSpan) {
        super(name, age);
        this.wingSpan = wingSpan;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("maneLength: " + wingSpan);
        System.out.println("===============================");
    }

    public void makeSound() {
        System.out.println("Bird sound: ");
    }

    public void move() {
        System.out.println("Bird move ...");
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}
