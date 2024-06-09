package com.quantcast.cookie.demo.parser.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quantcast.cookie.demo.exception.LogsParseException;
import com.quantcast.cookie.demo.model.CookieLog;

@Component
public class LogParser {

    public List<CookieLog> parseLogFile(String fileName) {

        List<CookieLog> cookieLogs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("logs/" + fileName))) {
            // Skip the first line
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // ignore the line if the format is not correct
                if (parts.length == 2) {
                    String cookie = parts[0];
                    LocalDateTime dateTime = LocalDateTime.parse(parts[1], DateTimeFormatter.ISO_DATE_TIME);
                    CookieLog cookieLog = new CookieLog(cookie, dateTime);
                    cookieLogs.add(cookieLog);
                }
            }
        } catch (IOException e) {
            throw new LogsParseException("Error parsing log file, the file path not exist ", e);
        }

        return cookieLogs;
    }

}
