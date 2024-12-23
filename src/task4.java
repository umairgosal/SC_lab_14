// Lab Task 4: Simulation of Bank Transaction System
import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    private AtomicInteger balance = new AtomicInteger(0);

    public void deposit(int amount) {
        balance.addAndGet(amount);
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
    }

    public void withdraw(int amount) {
        if (balance.get() >= amount) {
            balance.addAndGet(-amount);
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw: " + amount + " (Insufficient funds)");
        }
    }

    public int getBalance() {
        return balance.get();
    }
}

public class task4 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable clientTask = () -> {
            for (int i = 0; i < 5; i++) {
                int action = (int) (Math.random() * 2);
                int amount = (int) (Math.random() * 100) + 1;
                if (action == 0) {
                    account.deposit(amount);
                } else {
                    account.withdraw(amount);
                }
            }
        };

        Thread client1 = new Thread(clientTask, "Client1");
        Thread client2 = new Thread(clientTask, "Client2");
        Thread client3 = new Thread(clientTask, "Client3");

        client1.start();
        client2.start();
        client3.start();

        client1.join();
        client2.join();
        client3.join();

        System.out.println("Final Account Balance: " + account.getBalance());
    }
}