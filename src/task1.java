// Task 1: Create and execute multiple threads
class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquarePrinter implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Square: " + (i * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class task1 {
    public static void main(String[] args) {
        Thread numberThread = new NumberPrinter();
        Thread squareThread = new Thread(new SquarePrinter());

        numberThread.start();
        squareThread.start();
    }
}
