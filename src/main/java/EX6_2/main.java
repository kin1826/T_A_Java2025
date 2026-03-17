package EX6_2;

public class main {
    public static void main (String[] args) {
        Circle c = new Circle(5);
        Rectengle r = new Rectengle(5,3);

        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());

        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());
    }
}


