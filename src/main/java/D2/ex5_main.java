package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class ex5_main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ex5_car> car_list = new ArrayList<>();

    static public void printMenu() {
        System.out.println("=========WELCOME=========");
        System.out.println("1. Tạo 1 xe mới.");
        System.out.println("2. Sửa giá của xe với ID nhập từ bàn phím.");
        System.out.println("3. Xoá xe với ID nhập từ bàn phím.");
        System.out.println("4. In ra toàn bộ xe trong cửa hàng.");
        System.out.println("5. In ra tất cả Tên của 1 hãng xe được nhập từ bàn phím.");
        System.out.println("6. Thoát.");
        System.out.println("=========================");
    }

    static public ex5_car createNewCar() {
        System.out.println("Nhập ID xe:");
        int id = sc.nextInt();
        System.out.println("Nhập tên xe: ");
        String name = sc.next();
        System.out.println("Nhập hãng xe:");
        String brand = sc.next();
        System.out.println("Nhập tốc độ tối đa:");
        double max_sp = sc.nextInt();
        System.out.println("Nhập giá xe:");
        int price = sc.nextInt();

        return new ex5_car(id, name, brand, max_sp, price);
    }

    static public void editPriceById(int id_find) {
        if (car_list.isEmpty()) {
            System.out.println("Chưa có xe nào trong list!!");
            return;
        }

        for (ex5_car car : car_list) {
            if (car.getId() == id_find) {
                System.out.println("Nhập giá mới của xe " + car.getName() +": ");
                int new_price = sc.nextInt();
                System.out.println(new_price);
                car.setPrice(new_price);
            }
        }
    }

    static public void deleteCarById(int id_find) {
        if (car_list.isEmpty()) {
            System.out.println("Chưa có xe nào trong list!!");
            return;
        }

        car_list.removeIf(car -> car.getId() == id_find);
    }

    static public void printAllCar() {
        if (car_list.isEmpty()) {
            System.out.println("Chưa có xe nào trong list!!");
            return;
        }

        for (ex5_car car : car_list) {
            car.display();
            System.out.println("==================");
        }
    }

    static public void printBrandInput(String brand) {
        if (car_list.isEmpty()) {
            System.out.println("Chưa có xe nào trong list!!");
            return;
        }

        for (ex5_car car : car_list) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                car.display();
                System.out.println("=================");
            }
        }
    }

    public static void main(String[] args) {
        int choice;

        while (true) {
            printMenu();
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ex5_car car = createNewCar();
                    car_list.add(car);
                    break;
                case 2:
                    System.out.println("Nhập ID xe muốn đổi: ");
                    int id = sc.nextInt();
                    editPriceById(id);
                    break;
                case 3:
                    System.out.println("Nhập ID xe muốn xóa: ");
                    int id_find = sc.nextInt();
                    deleteCarById(id_find);
                    break;
                case 4:
                    printAllCar();
                    break;
                case 5:
                    System.out.println("Nhập hãng xe bạn muốn in: ");
                    String brand = sc.next();
                    printBrandInput(brand);
                    break;
                case 6:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Không có lựa chọn hợp lệ!!");
            }
        }
    }
}
