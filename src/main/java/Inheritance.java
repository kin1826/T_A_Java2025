import java.util.ArrayList;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Students extends Person {
    private int score;

    public Students(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Score: " + score);
    }
}

class Teachers extends Person {
    private double salary;

    public Teachers(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salary: " + salary);
    }
}

public class Inheritance {
    static ArrayList<Person> persons = new ArrayList<>();
    static ArrayList<Students> students = new ArrayList<>();

    public static void main(String[] args) {
        Students student_1 = new Students("John Doe", 20, 10);
        Teachers teacher_1 = new Teachers("John Doe", 20, 100);
        Person std_2 = new Students("John Doe", 20, 9);

        persons.add(student_1);
        persons.add(teacher_1);
        persons.add(std_2);

        students.add(student_1);
    }
}
