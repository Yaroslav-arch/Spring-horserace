package ua.lysenko.springhorserace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lysenko.springhorserace.entities.Bet;
import ua.lysenko.springhorserace.entities.Counter;
import ua.lysenko.springhorserace.entities.RaceModel;
import ua.lysenko.springhorserace.repositories.RaceModelRepository;
import ua.lysenko.springhorserace.services.RaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/race")
public class RaceController {
    private final RaceService raceService;
    private final RaceModelRepository raceModelRepository;

    @Autowired
    public RaceController(RaceService raceService, RaceModelRepository raceModelRepository) {
        this.raceService = raceService;
        this.raceModelRepository = raceModelRepository;
    }

    @GetMapping("/{id}")
    public List<String> raceInfo(@PathVariable String id) {
        List<RaceModel> raceById = raceModelRepository.getAllRacemodelsByRaceId(Long.parseLong(id));
        List<String> response = new ArrayList<>();
        if (raceById.isEmpty()) {
            response.add("No races have been registered. Please go to 'localhost:8080/race/start' ");
        } else {
            response.add("The race was held on " + raceById.get(0).getDate());
            response.add("We had " + raceById.size() + " competitors");
            for (RaceModel model : raceById) {
                if (model.isBet()) {
                    response.add("Position: " + model.getPosition() + "; Horse number: " + model.getHorseId() + " - Your bet");
                } else {
                    response.add("Position: " + model.getPosition() + "; Horse number: " + model.getHorseId());
                }
            }
        }
        return response;
    }

    @PostMapping("/start")
    public String startRace(@RequestParam long quantity,
                            @RequestParam long chosen) throws ExecutionException, InterruptedException {
        Counter.incrementCounter();
        Bet bet = new Bet();
        bet.setQuantity(quantity);
        bet.setChosen(chosen);
        raceService.start(bet);
        return "Race finished, results available at 'localhost:8080/race/" + Counter.getCounter();
    }
}
