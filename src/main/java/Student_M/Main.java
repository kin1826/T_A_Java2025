package Student_M;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //Khai báo
        ArrayList<Students> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        //Khai báo số lượng học sinh muốn nhập
        System.out.println("Enter number of students: ");
        int n = scan.nextInt();
        scan.nextLine(); //Xử lý rơi dòng sau khi nhập

        //Yêu cầu 1 - Nhập thông tin của n sinh viên
        for (int i = 0; i < n; i++) {
            //Nhập
            System.out.println("Enter student " + (i + 1) + "'s name: ");
            String name = scan.nextLine();

            System.out.println("Enter student " + (i + 1) + "'s age: ");
            int age = scan.nextInt();
            scan.nextLine(); //Xử lý rơi dòng sau khi nhập

            //Tạo student mới
            Students std = new Students(name, age);

            //Thêm vào ArrayList
            list.add(std);
        }

        //Yêu cầu 2 - Hiển thị thông tin các sinh viên
        for (Students std : list) {
            std.display();
        }

        //Yêu cầu 3 - Sửa tên sinh viên
        //Nhập tên cần sửa
        System.out.println("Enter student name want change:");
        String old_name = scan.nextLine();
        //Nhập tên mới
        System.out.println("Enter new name:");
        String new_name = scan.nextLine();

        //Duyệt qua danh sách, so sánh tên sinh viên
        for (Students std : list) {
            if (std.getName().equalsIgnoreCase(old_name)) {
                //Sửa tên
                std.setName(new_name);
            }
        }

        //Hiển thị thông tin các sinh viên sau khi sửa
        for (Students std : list) {
            std.display();
        }
    }
}
