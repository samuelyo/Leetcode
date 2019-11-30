package com.leetcode.BuildingH2O;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class H2O2 {
    private Semaphore semO;
    private Semaphore semH;
    private Phaser phaser;

    public H2O2() {
        semO = new Semaphore(1);
        semH = new Semaphore(2);
        phaser = new Phaser(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        semH.acquire();

        releaseHydrogen.run();
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndAwaitAdvance();

        semH.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire();

        phaser.arriveAndAwaitAdvance();
        releaseOxygen.run();
        phaser.arriveAndAwaitAdvance();

        semO.release();
    }
}
