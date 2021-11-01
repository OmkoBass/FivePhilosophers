package com.example.fivephilosophersgui;

import com.example.fivephilosophersgui.Models.Philosopher;
import com.example.fivephilosophersgui.Models.Stick;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class FivePhilosophersController {
    @FXML
    public Button buttonStart;

    @FXML
    public Rectangle rectangleMarcus;

    @FXML
    public Rectangle rectangleZeno;

    @FXML
    public Rectangle rectanglePythagoras;

    @FXML
    public Rectangle rectangleSocrates;

    @FXML
    public Rectangle rectangleAristotle;

    Stick[] sticks = {
            new Stick(),
            new Stick(),
            new Stick(),
            new Stick(),
            new Stick(),
    };

    Philosopher[] philosophers = {
            new Philosopher("Marcus", sticks[0], sticks[1], false),
            new Philosopher("Zeno", sticks[1], sticks[2], false),
            new Philosopher("Pythagoras", sticks[2], sticks[3], false),
            new Philosopher("Socrates", sticks[3], sticks[4], false),
            new Philosopher("Aristotle", sticks[4], sticks[0], true),
    };

    Thread[] philosopherThreads = {
            new Thread(philosophers[0]),
            new Thread(philosophers[1]),
            new Thread(philosophers[2]),
            new Thread(philosophers[3]),
            new Thread(philosophers[4]),
    };

    public void start() {
        buttonStart.setVisible(false);

        philosophers[0].takeSeat(rectangleMarcus);
        philosophers[1].takeSeat(rectangleZeno);
        philosophers[2].takeSeat(rectanglePythagoras);
        philosophers[3].takeSeat(rectangleSocrates);
        philosophers[4].takeSeat(rectangleAristotle);

        for (Thread philosopher : philosopherThreads) {
            philosopher.start();
        }
    }
}
