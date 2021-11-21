package homework;

/*
 * Задание 3
 * Демонстрация приоритетов.
 * Создать 2 класса PriorityRunner и PriorityThread.
 * Запустить 3 потока с приоритетами (min, max, norm).
 * При помощи цикла for выведем на экран значения от 1 до 50 и укажем,
 * какой именно поток данную операцию делает.
 * */

public class PriorityRunner {
    public static void main(String[] args) {
        PriorityThread pt1 = new PriorityThread();
        PriorityThread pt2 = new PriorityThread();
        PriorityThread pt3 = new PriorityThread();

        pt1.setPriority(Thread.MAX_PRIORITY);
        pt2.setPriority(Thread.MIN_PRIORITY);
        pt3.setPriority(Thread.NORM_PRIORITY);

        pt1.start();
        pt2.start();
        pt3.start();
    }
}

class PriorityThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + " in thread: " + Thread.currentThread().getName());
        }
    }
}