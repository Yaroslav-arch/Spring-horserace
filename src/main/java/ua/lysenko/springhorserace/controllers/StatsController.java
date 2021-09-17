package ua.lysenko.springhorserace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.lysenko.springhorserace.entities.RaceModel;
import ua.lysenko.springhorserace.repositories.RaceModelRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final RaceModelRepository raceModelRepository;

    @Autowired
    public StatsController(RaceModelRepository raceModelRepository) {
        this.raceModelRepository = raceModelRepository;
    }

    @GetMapping
    public List<String> horseInfo(@RequestParam long horseId) {
        List<RaceModel> races = raceModelRepository.getAllRacemodelsByHorseId(horseId);
        List<String> result = new ArrayList<>();
        if (races.isEmpty()) {
            result.add("This horse hasn't participated any race");
        } else {
            result.add("Selected horse has participated in " + races.size() + " races:");
            for (RaceModel model : races) {
                result.add(model.getDate() + "; Race #" + model.getRaceId() + "; Position: " + model.getPosition());

            }
        }
        return result;
    }
}