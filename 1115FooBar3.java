package com.leetcode.PrintFooBarAlternately;

public class FooBar3 {
    private int n;
    //flag 0->foo to be print  1->foo has been printed  using volatile
    private volatile int flag = 0;


    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (flag == 0) {
                    printFoo.run();
                    flag = 1;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (flag == 1) {
                    printBar.run();
                    flag = 0;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }
}
