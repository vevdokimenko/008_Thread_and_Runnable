package homework;

/*
 * Задание
 * Создать 2 произвольных класса с полями и методами.
 * Необходимо синхронизировать методы этих классов между собой,
 * т.е. чтобы выводило на экран значения друг за другом
 * (1 класс, 2 класс, 1, 2 и т.д.).
 * */

public class Extra {
    public static void main(String[] args) {
        Cl1[] cl1s = {new Cl1(1), new Cl1(2), new Cl1(3), new Cl1(4)};

        Cl2 cl21 = new Cl2(1, cl1s);
        Cl2 cl22 = new Cl2(2, cl1s);
        Cl2 cl23 = new Cl2(3, cl1s);
        Cl2 cl24 = new Cl2(4, cl1s);

        cl21.start();
        cl22.start();
        cl23.start();
        cl24.start();
    }
}

class Cl1 {
    private int field;
    private boolean isBought;

    public Cl1(int field) {
        this.field = field;
    }

    synchronized void method(Cl2 cl2) {
        if (!isBought) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isBought = true;
            System.out.println(this.field + " класс " + cl2.getField() + " метод");
        }
    }
}

class Cl2 extends Thread {
    private int field;
    private Cl1[] cl1s;

    public Cl2(int field, Cl1[] cl1s) {
        this.field = field;
        this.cl1s = cl1s;
    }

    public int getField() {
        return field;
    }

    @Override
    public void run() {
        for (Cl1 item : cl1s) {
            item.method(this);
        }
    }
}