package D2;

public class ex5_car {
    private int id;
    private String name;
    private String brand;
    private double max_speed;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(double max_speed) {
        this.max_speed = max_speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ex5_car(int id, String name, String brand, double max_speed, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.max_speed = max_speed;
        this.price = price;
    }

    public ex5_car() {}

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Max speed: " + max_speed + "km/h");
        System.out.println("Price: " + price + "VND");
    }
}
