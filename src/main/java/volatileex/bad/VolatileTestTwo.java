package volatileex.bad;

public class VolatileTestTwo {

    static int temperature = 0;
    static boolean running = true;

    public static void main(String[] args) {

        new Thread(() -> {
            int noOfBacterias = 4550000;
            while (temperature < 100){
                --noOfBacterias;
            }
            running = false;
            System.out.println("Water boiling ! Number of bacterias :" + noOfBacterias);

        }).start();

        new Thread( () -> {
            while(running)
            {
                ++temperature;
                System.out.println("incremented temperature :" + temperature );
            }

        }).start();
    }
}


