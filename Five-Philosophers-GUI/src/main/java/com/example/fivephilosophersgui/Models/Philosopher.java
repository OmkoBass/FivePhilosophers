package com.example.fivephilosophersgui.Models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Philosopher implements Runnable {
    String name;
    Stick leftStick;
    Stick rightStick;
    boolean switchStick;
    Rectangle seat;

    public Philosopher(String name, Stick leftStick, Stick rightStick, boolean switchStick) {
        this.name = name;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
        this.switchStick = switchStick;
    }

    private void think(){
        System.out.println(this.name + " is thinking...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat(){
        System.out.println(this.name + " is eating...");
        Random random = new Random();
        try {
            int waitTime = random.nextInt(5 - 3) + 3;
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeSeat(Rectangle rectangle) {
        this.seat = rectangle;
    }

    @Override
    public void run() {
        while(true) {
            this.seat.setFill(Color.valueOf("#FA5252"));
            think();
            try {
                if(switchStick) {
                    rightStick.takeStick();
                    leftStick.takeStick();
                } else {
                    leftStick.takeStick();
                    rightStick.takeStick();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.seat.setFill(Color.valueOf("#51CF66"));
            eat();
            leftStick.returnStick();
            rightStick.returnStick();
        }
    }
}