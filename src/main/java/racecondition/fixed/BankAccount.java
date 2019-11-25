package racecondition.fixed;

public class BankAccount {

    private double balance;

    public synchronized void credit(double amount) {
        balance = balance + amount;
    }

    public void debit(double amount) {
        synchronized (this)
        {
            balance = balance - amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
