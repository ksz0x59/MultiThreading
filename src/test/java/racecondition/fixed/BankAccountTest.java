package racecondition.fixed;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

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
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(0.0, bankAccount.getBalance());
    }
}