package EX6_2;

public class Rectengle implements Geometric {
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
