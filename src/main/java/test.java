import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {}

    public void display() {
        System.out.println("id: " + id + " name: " + name + " age: " + age);
    }
}

public class test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Student s1 = new Student(1, "John", 30);
        Student s2 = new Student(2, "Jane", 30);

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(s1);
        students.add(s2);

        System.out.println(students);
        System.out.println("Input name: ");
        String name = sc.next();

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
            }
        }
    }
}
