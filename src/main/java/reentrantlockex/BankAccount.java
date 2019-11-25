package reentrantlockex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private Lock lock = new ReentrantLock(true);


    public void credit(double amount) {
        try{
            lock.lock();
            balance = balance + amount;
        }
        finally{
            lock.unlock();
        }
    }

    public void debit(double amount)  {
        try{
            lock.lock();
            balance = balance - amount;
        }
        finally{
            lock.unlock();
        }
    }

    public double getBalance(){
        return balance;
    }

}
