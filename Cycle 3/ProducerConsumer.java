import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class representing the shared buffer
class SharedBuffer {
    private List<Integer> buffer = new ArrayList<>();
    private int capacity; // Maximum capacity of the buffer

    // Constructor to set the buffer capacity
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Method for the Producer to put data into the buffer
    public synchronized void put(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full. Producer waiting...");
            wait();
        }

        buffer.add(item);
        System.out.println("Producer produced: " + item);

        notifyAll();
    }

    // Method for the Consumer to take data from the buffer
    public synchronized int take() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer is empty. Consumer waiting...");
            wait();
        }

        // Remove and return the first item from the buffer
        int item = buffer.remove(0);
        System.out.println("Consumer consumed: " + item);

        notifyAll();

        return item;
    }
}

// Class representing the Producer thread
class Producer implements Runnable {
    private SharedBuffer buffer;
    private int numItemsToProduce;

    // Constructor to link the producer to the buffer and set production count
    public Producer(SharedBuffer buffer, int numItemsToProduce) {
        this.buffer = buffer;
        this.numItemsToProduce = numItemsToProduce;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < numItemsToProduce; i++) {
            int item = random.nextInt(100);
            try {
                buffer.put(item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
                return;
            }
        }
        System.out.println("Producer finished producing.");
    }
}

// Class representing the Consumer thread
class Consumer implements Runnable {
    private SharedBuffer buffer;
    private int numItemsToConsume;

    // Constructor to link the consumer to the buffer and set consumption count
    public Consumer(SharedBuffer buffer, int numItemsToConsume) {
        this.buffer = buffer;
        this.numItemsToConsume = numItemsToConsume;
    }

    @Override
    public void run() {
        for (int i = 0; i < numItemsToConsume; i++) {
            try {
                buffer.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted.");
                return;
            }
        }
        System.out.println("Consumer finished consuming.");
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        int bufferCapacity = 3;
        int itemsToProcess = 6;

        // Create the shared buffer
        SharedBuffer buffer = new SharedBuffer(bufferCapacity);

        // Create Producer and Consumer tasks
        Producer producerTask = new Producer(buffer, itemsToProcess);
        Consumer consumerTask = new Consumer(buffer, itemsToProcess);

        // Create threads for the Producer and Consumer
        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Producer/Consumer.");
        }

        System.out.println("\nProducer-Consumer example finished.");
    }
}
