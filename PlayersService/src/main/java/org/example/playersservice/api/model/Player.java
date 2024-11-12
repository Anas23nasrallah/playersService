package org.example.playersservice.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Table(name = "players", indexes = {@Index(name ="player_id_idx", columnList = "player_id")})
@Entity
public class Player {
    @Id
    @Column(name = "player_id", unique = true, nullable = false)
    private String playerID;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "birth_month")
    private Integer birthMonth;
    @Column(name = "birth_day")
    private Integer birthDay;
    @Column(name = "birth_country")
    private String birthCountry;
    @Column(name = "birth_state")
    private String birthState;
    @Column(name = "birth_city")
    private String birthCity;
    @Column(name = "death_year")
    private Integer deathYear;
    @Column(name = "death_month")
    private Integer deathMonth;
    @Column(name = "death_day")
    private Integer deathDay;
    @Column(name = "death_country")
    private String deathCountry;
    @Column(name = "death_state")
    private String deathState;
    @Column(name = "death_city")
    private String deathCity;
    @Column(name = "name_first")
    private String nameFirst;
    @Column(name = "name_last")
    private String nameLast;
    @Column(name = "name_given")
    private String nameGiven;
    private Integer weight;
    private Integer height;
    @Column(name = "bats")
    private String batting;
    @Column(name = "throws")
    private String throwing;
    private LocalDate debut;
    @Column(name = "final_game")
    private LocalDate finalGame;
    @Column(name = "retro_id")
    private String retroID;
    @Column(name = "bbref_ID")
    private String bbrefID;

}

