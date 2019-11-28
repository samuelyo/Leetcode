package com.leetcode.PrintFooBarAlternately;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar2 {
    private int n;
    //flag 0->foo to be print  1->foo has been printed
    private int flag = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition fooPrintedCondition = reentrantLock.newCondition();
    Condition barPrintedCondition = reentrantLock.newCondition();

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                reentrantLock.lock();
                while (flag == 1) {
                    barPrintedCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                fooPrintedCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            while (flag == 0) {
                fooPrintedCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = 0;
            barPrintedCondition.signalAll();
            reentrantLock.unlock();
        }
    }
}
