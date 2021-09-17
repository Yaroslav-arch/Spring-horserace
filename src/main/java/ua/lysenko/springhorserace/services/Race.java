package ua.lysenko.springhorserace.services;

import ua.lysenko.springhorserace.entities.Horse;
import java.util.Random;
import java.util.concurrent.Callable;

public class Race implements Callable<Horse> {
    private int number;

    public Race(int number) {
        this.number = number;
    }

    public Horse call() throws Exception {
        Horse horse = new Horse();
        int distance = 0;
        long time = System.currentTimeMillis();
        Random random = new Random();
        while (distance < 1000) {
            distance += random.nextInt(100) + 100;
            Thread.sleep(random.nextInt(100) + 400);
        }
        horse.setResultTime(System.currentTimeMillis() - time);
        horse.setNumber(number);
        return horse;
    }
}
