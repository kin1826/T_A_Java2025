import java.util.Scanner;

public class sincos {
    public static void main(String[] args) {

        //b1
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double num = scan.nextDouble();
        double sin = Math.sin(num);
        double cos = Math.cos(num);
        double can = Math.sqrt(num);
        System.out.println("sin = " + sin);
        System.out.println("cos = " + cos);


        //b2
//        System.out.println("Enter a number: ");
//        String text = scan.next();
//        System.out.println("length: " +text.length());

        //b3
        System.out.println("Input width: ");
        System.out.println("Input height: ");
        double width = scan.nextDouble();
        double height = scan.nextDouble();
        double perimeter = 2 * (width + height);
        double area = width * height;
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }
}
