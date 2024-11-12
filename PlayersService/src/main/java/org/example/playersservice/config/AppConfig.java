package org.example.playersservice.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${app.csv_parser.csv_file_path}")
    @Getter
    private String csvFilePath;

    @Value("${app.csv_parser.should_parse}")
    private boolean shouldParse;

    public boolean shouldParseCsv() {
        return !csvFilePath.isEmpty() && shouldParse;
    }
}
