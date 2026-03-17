package Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mian {
    static Scanner scan = new Scanner(System.in);

    public static int[] input(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        return arr;
    }

    public static void display(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
//        int[] arr =  input(3);
//
//        display(arr);

        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("ba");
        list.add("c");

        int count = 0;
        for (String s : list) {
            count += s.length();
        }
        System.out.println(count);
    }
}
