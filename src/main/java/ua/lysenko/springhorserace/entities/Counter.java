package ua.lysenko.springhorserace.entities;

import ua.lysenko.springhorserace.repositories.RaceModelRepository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


public class Counter {
    private static AtomicInteger counter = new AtomicInteger();

    static {
        counter.set(0);
    }

    public static void incrementCounter() {
        counter.incrementAndGet();
    }

    public static int getCounter() {
        return counter.get();
    }
}
