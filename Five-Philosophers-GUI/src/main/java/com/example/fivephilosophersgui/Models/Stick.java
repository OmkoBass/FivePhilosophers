package com.example.fivephilosophersgui.Models;

import java.util.concurrent.Semaphore;

public class Stick {
    private final Semaphore semaphore = new Semaphore(1);

    void takeStick() throws InterruptedException {
        this.semaphore.acquire();
    }

    void returnStick() {
        this.semaphore.release();
    }
}
