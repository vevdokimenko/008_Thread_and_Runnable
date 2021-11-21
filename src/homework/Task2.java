package homework;

/*
 * Задание 2
 * Задержка потока.
 * Необходимо создать 3 потока, каждых из этих потоков запустить
 * (например: main, second, first), и когда эти потоки успешно отработают –
 * вывести на экран сообщение (завершение потом first, second и main).
 * */

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread first = new MyThread();
        MyThread second = new MyThread();

        Thread firstThread = new Thread(first, "first");
        Thread secondThread = new Thread(second, "second");

        System.out.println("завершение");
        secondThread.start();
        firstThread.start();

        firstThread.join();
        secondThread.join();
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000_000; i++);
        System.out.println(Thread.currentThread().getName());
    }
}
