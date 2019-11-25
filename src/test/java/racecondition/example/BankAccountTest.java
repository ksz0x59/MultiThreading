package racecondition.example;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BankAccountTest {
    @Test
    public void testBankAccountWithoutSynchronization1(){
        BankAccount bankAccount = new BankAccount();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.rangeClosed(1, 100).forEach(i->{
            executorService.submit(()-> {
                bankAccount.debit(100);
            });
            executorService.submit(()-> {
                bankAccount.credit(100);
            });
        });

        executorService.shutdown();
        System.out.println("Final Balance: " + bankAccount.getBalance());
    }
}