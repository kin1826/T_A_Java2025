package D3;

import java.util.ArrayList;

public class Account {
    protected String accNum;
    protected String accName;
    protected double balance;

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String accNum, String accName, double balance) {
        this.accNum = accNum;
        this.accName = accName;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void display() {
        System.out.println(this.balance);
    }
}

class NormalAccount extends Account {
    private double transactionFee;

    public NormalAccount(String accNum, String accName, double balance, double transactionFee) {
        super(accNum, accName, balance);
        this.transactionFee = transactionFee;
    }

    @Override
    public void withdraw(double amount) {
        balance -= (amount + transactionFee);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("normal account");
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accNum, String accName, double balance, double interestRate) {
        super(accNum, accName, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(double interest) {
        balance += balance * interestRate / 100;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("savings account");
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new NormalAccount("111", "a", 100, 2));
        accounts.add(new SavingsAccount("112", "b", 200, 3));

        accounts.getFirst().display();
        accounts.get(1).display();

    }
}