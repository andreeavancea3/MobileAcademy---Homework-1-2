package Ex2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {
    private int hardwareLimit;
    private List<String> printQueue = new ArrayList<>();

    public ProducerConsumer(int hardwareLimit) {
        this.hardwareLimit = hardwareLimit;
    }

    public synchronized void addToQueue(String document) throws InterruptedException {
        while (printQueue.size() >= hardwareLimit) {
            wait();
        }
        printQueue.add(document);
        System.out.println("Added to queue: " + document);
        notifyAll();
    }

    public synchronized String printDocument() throws InterruptedException {
        while (printQueue.isEmpty()) {
            wait();
        }
        String document = printQueue.remove(0);
        System.out.println("Printing document: " + document);
        notifyAll();
        return document;
    }
}