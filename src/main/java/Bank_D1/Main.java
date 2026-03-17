package Bank_D1;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Bank acc = new Bank(1, "John", 999999, 10000);

        while (true) {
            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    acc.showBalance();
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    double num_Dep = scan.nextDouble();
                    acc.deposit(num_Dep);
                    break;
                case 3:
                    System.out.println("Enter amount: ");
                    double num_With = scan.nextDouble();
                    if (acc.withdraw(num_With)) {
                        System.out.println("Withdraw successful");
                    } else {
                        System.out.println("Insufficient funds");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
