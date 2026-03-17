package EX2_GK;

public class Elephant extends Animal {
    private double trunkLength;

    public Elephant(String name, int age, double trunkLength) {
        super(name, age);
        this.trunkLength = trunkLength;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("maneLength: " + trunkLength);
        System.out.println("===============================");
    }

    public void makeSound() {
        System.out.println("Elephant sound: ");
    }

    public void move() {
        System.out.println("Elephant move ...");
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    public void setTrunkLength(double trunkLength) {
        this.trunkLength = trunkLength;
    }
}
