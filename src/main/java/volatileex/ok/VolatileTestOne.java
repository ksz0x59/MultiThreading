package volatileex.ok;


class VolatileTestOne {

    static volatile boolean running = true;

    public static void main(String[] args) {

        new Thread(() -> {
            int i = 0;
            while (running) {
                i = i + 2;
            }
            System.out.println("done ! i is : " + i);
        }).start();

        new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            running = false;

        }).start();
    }
}
