package Ex2;

import java.util.Random;

public class Consumer implements Runnable {
    private ProducerConsumer producerConsumer;

    public Consumer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                String document = producerConsumer.printDocument();
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
