package com.leetcode.PrintFooBarAlternately;

import java.util.concurrent.atomic.AtomicInteger;

public class FooBar4 {
    private int n;
    ////flag 0->foo to be print  1->foo has been printed
    private AtomicInteger flag = new AtomicInteger(0);


    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag.compareAndSet(0, 1)) {
                Thread.sleep(1);
            }
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag.compareAndSet(1, 0)) {
                Thread.sleep(1);
            }
            printBar.run();
        }
    }
}
