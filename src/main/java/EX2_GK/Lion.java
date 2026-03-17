package EX2_GK;

public class Lion extends Animal {
    private int maneLength;

    public Lion(String name, int age, int maneLength) {
        super(name, age);
        this.maneLength = maneLength;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("maneLength: " + maneLength);
        System.out.println("===============================");
    }

    public void makeSound() {
        System.out.println("Lion sound: ");
    }

    public void move() {
        System.out.println("Lion move ...");
    }

    public int getManeLength() {
        return maneLength;
    }

    public void setManeLength(int maneLength) {
        this.maneLength = maneLength;
    }
}
