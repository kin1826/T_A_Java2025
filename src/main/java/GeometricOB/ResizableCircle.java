package GeometricOB;

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    public void resize(int percent) {
        radius = radius * percent / 100;
    }

    public void display() {
        System.out.println(radius);
    }
}

class Main {
    public static void main(String[] args) {
        ResizableCircle circle = new ResizableCircle(100);
        circle.display();
        circle.resize(50);
        circle.display();

        circle.resize(25);
        circle.display();
    }
}
