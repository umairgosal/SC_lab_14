// Lab Task 3: Concurrent Data Structures
import java.util.concurrent.CopyOnWriteArrayList;

public class task3 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> sharedList = new CopyOnWriteArrayList<>();

        Runnable writerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                sharedList.add(i);
                System.out.println(Thread.currentThread().getName() + " added: " + i);
            }
        };

        Runnable readerTask = () -> {
            for (int i = 0; i < sharedList.size(); i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + sharedList.get(i));
            }
        };

        Thread writer1 = new Thread(writerTask, "Writer1");
        Thread writer2 = new Thread(writerTask, "Writer2");
        Thread reader = new Thread(readerTask, "Reader");

        writer1.start();
        writer2.start();
        reader.start();
    }
}