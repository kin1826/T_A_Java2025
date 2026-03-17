package EX2_GK;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static ArrayList<Animal> animals = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("===========================");
        System.out.println("Welcome to the Animal Menu");
        System.out.println("1. Add Animal");
        System.out.println("2. Show All Animal");
        System.out.println("3. Delete Animal By Name");
        System.out.println("4. Show Information By Name");
        System.out.println("5. Exit");
        System.out.println("===========================");
    }

    public static Lion createLion() {
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter ManeLength: ");
        int length = sc.nextInt();
        return new Lion(name, age, length);
    }

    public static Elephant createElephant() {
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter TrunkLength: ");
        int trunkLength = sc.nextInt();
        return new Elephant(name, age, trunkLength);
    }

    public static Bird createBird() {
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter WingSpan: ");
        int wingSpan = sc.nextInt();
        return new Bird(name, age, wingSpan);
    }

    public static void showAllAnimals() {
        for (Animal animal : animals) {
            animal.showInfo();
        }
    }

    //Lưu luôn cái hàm xóa bằng tên này lại, nếu cô có bắt làm thì làm theo cách ni
    //Nếu cô yêu cầu xóa bằng cái khác thì tương tự, thay tham số truyền vào bằng cái muốn nhập
    //Thay cái a.getName() bằng get cái các bạn muốn so sánh để xóa
    public static void deleteAnimalByName(String name) {
        Iterator<Animal> it = animals.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Animal a = it.next();
            if (a.getName().equalsIgnoreCase(name)) {
                it.remove();  // chuẩn nhất
                found = true;
            }
        }

        if (!found) System.out.println("Animal not found");
        else System.out.println(name + " deleted.");
    }

    public static void showAnimalByName(String name) {
        boolean found = false;
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.showInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Animal with name " + name + " was not found.");
        }
    }

    public static void main(String[] args) {
        //Phần này anh tạo sẵn các đối tượng để test chức năng 2 3 4
        Animal lion1 = new Lion("LION1", 4, 12);
        Animal lion2 = new Lion("LION2", 2, 12);
        Animal Elephant1 = new Elephant("E1", 10, 5.5);
        Animal Bird1 = new Bird("Bird1", 3, 12.2);
        animals.add(lion1);
        animals.add(lion2);
        animals.add(Elephant1);
        animals.add(Bird1);

        while (true) {
            printMenu();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter type Animal to add (1. Lion | 2. Elephant | 3. Bird): ");
                    int animalType = sc.nextInt();
                    if (animalType == 1) {
                        animals.add(createLion());
                    } else if (animalType == 2) {
                        animals.add(createElephant());
                    } else if (animalType == 3) {
                        animals.add(createBird());
                    } else {System.out.println("Invalid choice"); break;}
                    break;
                case 2:
                    showAllAnimals();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Name of Animal you want to delete: ");
                    String nameDl = sc.nextLine();
                    deleteAnimalByName(nameDl);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter Name of Animal you want to show: ");
                    String nameShow = sc.nextLine();
                    showAnimalByName(nameShow);
                    break;
                case 5:
                    System.out.println("See you again!");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
