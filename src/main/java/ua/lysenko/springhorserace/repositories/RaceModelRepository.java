package ua.lysenko.springhorserace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lysenko.springhorserace.entities.RaceModel;

import java.util.List;

@Repository
public interface RaceModelRepository extends JpaRepository<RaceModel, Long> {
     List<RaceModel> getAllRacemodelsByRaceId(long raceId);

     List<RaceModel> getAllRacemodelsByHorseId(long horseId);
}
