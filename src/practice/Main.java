package practice;

/*
* Создайте класс PrintRunnable, который будет имплементировать интерфейс Runnable
с двумя полями:
- message - сообщение, которое будет выводиться
- time - время, на которое будет засыпать поток (передается в метод Thread.sleep())
В методе run данного класса должно выводиться 10 раз сообщение с поля message и с задержкой time.
Создайте два отдельных потока и запустите их таким образом, чтобы на экране вывелось следующее сообщение
A .
. B
. B
A .
. B
A .
. B
A .
. B
A .
A .
. B
. B
A .
A .
. B
A .
. B
A .
. B
=====
 C
 C
 C
 C
 C
 C
 C
 C
 C
 C

* где A и B выводяться новыми потоками одновременно,
* а С выводиться в потоке main после того, как завершат работу предыдущие потоки
* */

class PrintRunnable implements Runnable {
    private String message;
    private int time;

    public PrintRunnable(String message, int time) {
        this.message = message;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t1 = new Thread(new PrintRunnable("A .", 100));
                Thread t2 = new Thread(new PrintRunnable(". B", 100));
                Thread t3 = new Thread(new PrintRunnable(" C", 0));

                t1.start();
                t2.start();

                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t3.start();
            }
        });
        thread.start();
    }
}
