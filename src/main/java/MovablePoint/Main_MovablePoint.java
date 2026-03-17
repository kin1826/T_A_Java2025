package MovablePoint;

class MovablePoint implements Movable {
    private int x;
    private int y;
    private int speed_x;
    private int speed_y;

    public MovablePoint(int x, int speed_x, int y, int speed_y) {

        this.x = x;
        this.y = y;
        this.speed_x = speed_x;
        this.speed_y = speed_y;
    }

    public void moveUp() {
        y -= speed_y;
    }
    public void moveDown() {
        y += speed_y;
    }
    public void moveLeft() {
        x -= speed_x;
    }
    public void moveRight() {
        x += speed_x;
    }

    public void displayxy() {
        System.out.println("x=" + x + ", y=" + y);
    }
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}

class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public void moveUp() {
        center.moveUp();
    }
    public void moveDown() {
        center.moveDown();
    }
    public void moveLeft() {
        center.moveLeft();
    }
    public void moveRight() {
        center.moveRight();
    }

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    public void display() {
        System.out.println("Center=" + center.toString() + ", radius = " +radius);
    }
}

public class Main_MovablePoint {
    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(10, 1, 10, 2);

        MovableCircle c1 = new MovableCircle(10, p1);

        c1.display();
        c1.moveUp();
        c1.display();
    }
}
