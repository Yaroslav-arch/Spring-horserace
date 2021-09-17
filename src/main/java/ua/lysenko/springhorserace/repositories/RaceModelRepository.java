package ua.lysenko.springhorserace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lysenko.springhorserace.entities.RaceModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaceModelRepository extends JpaRepository<RaceModel, Long> {
    List<RaceModel> getAllRacemodelsByRaceId(long raceId);

    List<RaceModel> getAllRacemodelsByHorseId(long horseId);

    @Query(nativeQuery = true, value = "SELECT r.race_id FROM race_models r ORDER BY race_id limit 1")
    Optional<Long> getLastRaceId();
}
