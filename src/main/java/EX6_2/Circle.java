package EX6_2;

public class Circle implements Geometric {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getPerimeter() {
        return Math.PI*radius*2;
    }
}
