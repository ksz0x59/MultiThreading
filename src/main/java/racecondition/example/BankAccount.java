package racecondition.example;

// there is a test to this class ...

public class BankAccount {
    private double balance;
    public void credit(double amount){
        balance = balance + amount;
    }
    public void debit(double amount){
        balance = balance - amount;
    }
    public double getBalance(){
        return balance;
    }
}
