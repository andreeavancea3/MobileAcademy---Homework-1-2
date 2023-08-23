package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private ProducerConsumer producerConsumer;
    private String producerName;

    public Producer(ProducerConsumer producerConsumer, String producerName) {
        this.producerConsumer = producerConsumer;
        this.producerName = producerName;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 30; i++) {
            String document = producerName + ", Document " + i;
            try {
                producerConsumer.addToQueue(document);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}