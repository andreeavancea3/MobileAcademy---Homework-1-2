package Ex2;

public class MainThreads {
    public static void main(String[] args) {
        int hardwareLimit = 5;
        ProducerConsumer producerConsumer = new ProducerConsumer(hardwareLimit);

        Thread thread1 = new Thread(new Producer(producerConsumer, "Producer 1"));
        Thread thread2 = new Thread(new Producer(producerConsumer, "Producer 2"));
        Thread thread3 = new Thread(new Producer(producerConsumer, "Producer 3"));

        Thread consumerThread = new Thread(new Consumer(producerConsumer));

        thread1.start();
        thread2.start();
        thread3.start();

        consumerThread.start();
    }
}