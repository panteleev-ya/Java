package PrintInOrder;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

    AtomicInteger number = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        number.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(number.get() != 1) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        number.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(number.get() != 2) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
