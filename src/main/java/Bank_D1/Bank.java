package Bank_D1;

public class Bank {
    private int ID;
    private String username;
    private int numAcc;
    private double balance;

    public Bank(int ID, String username, int numAcc, double balance) {
        this.ID = ID;
        this.username = username;
        this.numAcc = numAcc;
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumAcc() {
        return numAcc;
    }

    public void setNumAcc(int numAcc) {
        this.numAcc = numAcc;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank() {}

    public void showBalance() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }
}
