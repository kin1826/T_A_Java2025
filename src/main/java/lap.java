import java.util.Scanner;

public class lap {
    static Scanner scan = new Scanner(System.in);

    public static void rect() {
        System.out.println("Input length: ");
        int a = scan.nextInt();
        System.out.println("Input width: ");
        int b = scan.nextInt();

        System.out.println("Area: " + a * b);
        System.out.println("Perimeter: " + 2 * (a + b));
    }

    public static double area_circle(double r) {
        return 3.14 * r * r;
    }
    public static double per_circle(double r) {
        return 2 * 3.14 * r;
    }

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    rect();
                    break;
                case 2:
                    System.out.println("Enter radius: ");
                    double r = scan.nextDouble();
                    System.out.println("Area: " + area_circle(r));
                    System.out.println("Perimeter: " + per_circle(r));
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

}
