package com.leetcode.PrintInOrder;

import java.util.concurrent.CountDownLatch;

public class Foo {

    private final CountDownLatch l2;
    private final CountDownLatch l3;

    public Foo() {
        l2 = new CountDownLatch(1);
        l3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        l2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        l2.await();
        printSecond.run();
        l3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        l3.await();
        printThird.run();
    }
}
