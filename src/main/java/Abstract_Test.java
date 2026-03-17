abstract class Vehicle {
    protected String brand;
    protected String speed;

    Vehicle(String brand, String speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }

    abstract void run();
}

class Car extends Vehicle {
    private String color;
    private int numberOfSeats;

    Car(String brand, String speed, String color, int numberOfSeats) {
        super(brand, speed);
        this.color = color;
        this.numberOfSeats = numberOfSeats;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Color: " + color);
        System.out.println("Number of Seats: " + numberOfSeats);
    }

    public void run() {
        System.out.println("Car running ...........");
    }
}

public class Abstract_Test {
}
