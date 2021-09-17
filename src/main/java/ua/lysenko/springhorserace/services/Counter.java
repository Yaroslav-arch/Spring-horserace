package ua.lysenko.springhorserace.services;

import org.springframework.stereotype.Component;
import ua.lysenko.springhorserace.repositories.RaceModelRepository;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {
    private AtomicInteger counter;

    public Counter(RaceModelRepository raceModelRepository) {
        Long lastRace = raceModelRepository.getLastRaceId().orElse(0L);
        counter = new AtomicInteger(Math.toIntExact(lastRace) + 1);
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
