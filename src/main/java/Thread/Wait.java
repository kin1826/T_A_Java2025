package Thread;

import java.lang.Thread;

class Data {

    synchronized void waitMethod() {
        System.out.println("Thread 1: Đang chờ");

        try {
            wait();
        } catch (Exception e) {}

        System.out.println("Thread 1: Được đánh thức");
    }

    synchronized void notifyMethod() {
        System.out.println("Thread 2: Đánh thức thread 1");
        notify();
    }
}

class WaitThread extends Thread {

    Data d;

    WaitThread(Data d) {
        this.d = d;
    }

    public void run() {
        d.waitMethod();
    }
}

class NotifyThread extends Thread {

    Data d;

    NotifyThread(Data d) {
        this.d = d;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        d.notifyMethod();
    }
}

public class Wait {

    public static void main(String[] args) {

        Data d = new Data();

        WaitThread t1 = new WaitThread(d);
        NotifyThread t2 = new NotifyThread(d);

        t1.start();
        t2.start();
    }
}