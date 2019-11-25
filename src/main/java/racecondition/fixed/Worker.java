package racecondition.fixed;

/*
       this.count = 0;
   A:  Reads this.count into a register (0)
   B:  Reads this.count into a register (0)
   B:  Adds value 1 to register
   B:  Writes register value (1) back to memory. this.count now equals 1
   A:  Adds value 1 to register
   A:  Writes register value (1) back to memory. this.count now equals 1
 */

public class Worker {

    private int count = 0;

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }

    public synchronized void increment() {
        count++;
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {
        }
        System.out.println("Count is: " + count);
    }
}
