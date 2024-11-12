package org.example.playersservice.csv;

import jakarta.annotation.PostConstruct;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.playersservice.config.AppConfig;
import org.example.playersservice.api.model.Player;
import org.example.playersservice.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

@Service
public class CsvParser {
    private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);
    private final AppConfig appConfig;
    private final PlayerRepository repo;

    public CsvParser(AppConfig appConfig, PlayerRepository repo) {
        this.appConfig = appConfig;
        this.repo = repo;
    }

    @PostConstruct
    public void parseAndSave() {
        if (!appConfig.shouldParseCsv()){
            logger.info("No need to parse Csv");
            return;
        }

        List<Player> playersToSave = new ArrayList<>();
        logger.info("Starting csv parsing");

        try (CSVReader reader = new CSVReader(new FileReader(appConfig.getCsvFilePath()))) {
            String[] row;
            reader.readNext();
            row = reader.readNext();

            while (Objects.nonNull(row)) {
                try {
                    Player playerToSave = new Player();
                    playerToSave.setPlayerID(row[0]);
                    playerToSave.setBirthYear(parseInteger(row[1]));
                    playerToSave.setBirthMonth(parseInteger(row[2]));
                    playerToSave.setBirthDay(parseInteger(row[3]));
                    playerToSave.setBirthCountry(parseString(row[4]));
                    playerToSave.setBirthState(parseString(row[5]));
                    playerToSave.setBirthCity(parseString(row[6]));
                    playerToSave.setDeathYear(parseInteger(row[7]));
                    playerToSave.setDeathMonth(parseInteger(row[8]));
                    playerToSave.setDeathDay(parseInteger(row[9]));
                    playerToSave.setDeathCountry(parseString(row[10]));
                    playerToSave.setDeathState(parseString(row[11]));
                    playerToSave.setDeathCity(parseString(row[12]));
                    playerToSave.setNameFirst(parseString(row[13]));
                    playerToSave.setNameLast(parseString(row[14]));
                    playerToSave.setNameGiven(parseString(row[15]));
                    playerToSave.setWeight(parseInteger(row[16]));
                    playerToSave.setHeight(parseInteger(row[17]));
                    playerToSave.setThrowing(parseString(row[18]));
                    playerToSave.setBatting(parseString(row[19]));
                    playerToSave.setDebut(parseDate(row[20]));
                    playerToSave.setFinalGame(parseDate(row[21]));
                    playerToSave.setRetroID(parseString(row[22]));
                    playerToSave.setBbrefID(parseString(row[23]));

                    playersToSave.add(playerToSave);
                } catch (Exception exception) {
                  logger.error(String.format("Couldn't parse row: %s : %s", String.join("|", row), exception.getMessage()));
                }
                row = reader.readNext();
            }
            logger.info("Done csv parsing");

            repo.saveAll(playersToSave);
            logger.info("Saved all players");
        } catch (Exception exception) {
            logger.error(String.format("Csv parsing failed: %s", exception.getMessage()));
        }
    }

    private Integer parseInteger(String string) {
        if(Objects.isNull(string) || string.isBlank()) {
            return null;
        }

        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException exception) {
            logger.error(String.format("Parsing %s to Integer failed: %s", string, exception.getMessage()));
            return null;
        }
    }

    private LocalDate parseDate(String string) {
        if(Objects.isNull(string) || string.isBlank()) {
            return null;
        }

        try {
            return LocalDate.parse(string, DateTimeFormatter.ofPattern("yyy-MM-dd"));
        } catch (NumberFormatException exception) {
            logger.error(String.format("Parsing %s to LocalDate failed: %s", string, exception.getMessage()));
            return null;
        }
    }

    private String parseString(String string) {
        if(string.isBlank()) {
            return null;
        }

        return string;
    }
}
