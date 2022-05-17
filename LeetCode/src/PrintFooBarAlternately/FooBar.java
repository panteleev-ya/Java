package PrintFooBarAlternately;

import java.util.concurrent.atomic.AtomicBoolean;

public class FooBar {
    private final int n;
    AtomicBoolean fooTime = new AtomicBoolean(true);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooTime.get() != true) {}
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooTime.set(false);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooTime.get() != false) {}
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooTime.set(true);
        }
    }
}
