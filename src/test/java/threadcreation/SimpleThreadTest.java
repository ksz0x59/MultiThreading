package threadcreation;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class SimpleThreadTest {
    @Test
    public void singleThreadedProcessing(){

        SimpleThread threadExample = new SimpleThread();

        LocalDateTime start = LocalDateTime.now();

        threadExample.doSingleThreadedWork();

        System.out.println(String.format("doSingleThreadedWork took %s ms",
                ChronoUnit.MILLIS.between(start, LocalDateTime.now())));
    }

    @Test
    public void multiThreadedProcessing() throws InterruptedException{

        SimpleThread threadExample = new SimpleThread();

        LocalDateTime start = LocalDateTime.now();

        threadExample.doMultiThreadedWork();

        System.out.println(String.format("doMultiThreadedWork took %s ms",
                ChronoUnit.MILLIS.between(start, LocalDateTime.now())));
    }
}

