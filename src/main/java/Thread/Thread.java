package Thread;

//public class Thread {
//}


import java.util.Random;
import java.util.Scanner;

class RandomThread extends java.lang.Thread {

    public int num;

    public int getNum() {
        return num;
    }

    public void run() {
        Random rand = new Random();
        num = rand.nextInt(30 ) +1;
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Random number is: " + num);
    }
}

public class Thread {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws InterruptedException {
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            RandomThread t = new RandomThread();
            t.start();
            t.join();
            sum += t.num;
        }

        System.out.println(sum);
    }
}
