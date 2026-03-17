package StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        //Khởi tạo 2 object Students
//        //Sử dụng constructor để khởi tạo
//        Students std1 = new Students("John", 1, 20, "Computer Science", 3);
//
//        //Sử dụng getter và setter để truy cập và thay đổi giá trị của các thuộc tính của object
//        Students std2 = new Students();
//
//        //Set giá trị cho std2
//        std2.setName("Jane");
//        std2.setID(1002);
//        std2.setAge(21);
//        std2.setMajor("Computer Science");
//        std2.setGPA(3);
//
//        //In thông tin 2 sinh viên đã khởi tạo (Lần 1)
//        std1.display();
//        std2.display();
//
//        //Thay đổi tên của std1 bằng cách sử dụng setter
//        std1.setName("Nana");
//
//        //In thông tin 2 sinh viên đã khởi tạo (Lần 2)
//        std1.display();
//        std2.display();
//
//        //In tuổi của std2 bằng cách sử dụng getter (Riêng từng thuộc tính)
//        System.out.print("Age of student std2: " +std2.getAge());


        //======================================================
        //2 Cái ví dụ riêng, chạy chung cũng được nhưng mà nên comment 1 trong 2 cái để chạy cho nhanh

        //Các bạn có thể tạo mới 1 Object và tự nhập từng giá trị vào ví dụ như:
        //Nhớ comment phần trên để không lỗi
        Students std3 = new Students();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student name: ");
        std3.setName(scan.nextLine());
        System.out.println("Enter student ID: ");
        std3.setID(scan.nextInt());
        System.out.println("Enter student age: ");
        std3.setAge(scan.nextInt());
        System.out.println("Enter student major: ");
        std3.setMajor(scan.nextLine());
        scan.nextLine(); //Những dòng này để bỏ qua rơi dòng sau khi nhập
        System.out.println("Enter student GPA: ");
        std3.setGPA(scan.nextInt());

        Students std4 = new Students();
        System.out.println("Enter student name: ");
        std4.setName(scan.nextLine());
        System.out.println("Enter student ID: ");
        std4.setID(scan.nextInt());
        System.out.println("Enter student age: ");
        std4.setAge(scan.nextInt());
        System.out.println("Enter student major: ");
        std4.setMajor(scan.nextLine());
        scan.nextLine(); //Những dòng này để bỏ qua rơi dòng sau khi nhập
        System.out.println("Enter student GPA: ");
        std4.setGPA(scan.nextInt());

        std3.display();
        std4.display();
    }
}
