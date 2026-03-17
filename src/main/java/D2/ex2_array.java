package D2;

import java.util.Scanner;

public class ex2_array {
    static Scanner sc = new Scanner(System.in);

    static public int[] inputArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer " +i +": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static public void displayArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static public int sumPartArray(int[] arr) {
        int sum = 0;
        for (int i = arr.length/2; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static public int[] sortArray(int[] arr) {
        if (arr == null) return null;
        int[] arr_sort = arr.clone();
        int n = arr_sort.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr_sort[j] > arr_sort[j + 1]) {
                    int tam = arr_sort[j];
                    arr_sort[j] = arr_sort[j + 1];
                    arr_sort[j + 1] = tam;
                }
            }
        }
        return arr_sort;
    }

    static public int countEven(int[] arr) {
        int countE = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                countE++;
            }
        }
        return countE;
    }
    static public int countOdd(int[] arr) {
        int countO = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                countO++;
            }
        }
        return countO;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = inputArray(n);

        displayArray(arr);

        System.out.println("The sum of the array from n/2 to n-1 is: " + sumPartArray(arr));

        arr = sortArray(arr);

        System.out.println("GT nho nhi: " + arr[1]);
        System.out.println("GT lon nhi: " + arr[n-2]);

        System.out.println("Have " + countEven(arr) + " even numbers");
        System.out.println("Have " + countOdd(arr) + " odd numbers");
    }
}
