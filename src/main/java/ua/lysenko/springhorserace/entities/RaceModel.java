package ua.lysenko.springhorserace.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "race_models", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"race_id", "horse_id"}, name = "RACE_HORSE_CONSTRAINT"),
        @UniqueConstraint(columnNames = {"race_id", "position"}, name = "RACE_POSITION_CONSTRAINT")
})
@Entity
public class RaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "race_id")
    private long raceId;

    @Column(name = "horse_id")
    private long horseId;

    @Column(name = "result")
    private long result;

    @Column(name = "position")
    private long position;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "bet")
    private boolean bet;

}
