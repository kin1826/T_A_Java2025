package Geometric;

class Circle implements GeometricITF {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectengle implements GeometricITF {
    private double a;
    private double b;
    public Rectengle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectengle() {
    }

    public double getArea() {
        return a * b;
    }

    public double getPerimeter() {
        return 2*(a+b);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectengle rectangle = new Rectengle(5, 3);

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
