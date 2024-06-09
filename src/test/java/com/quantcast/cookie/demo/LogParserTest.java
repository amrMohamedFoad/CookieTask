package com.quantcast.cookie.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.quantcast.cookie.demo.exception.LogsParseException;
import com.quantcast.cookie.demo.model.CookieLog;
import com.quantcast.cookie.demo.parser.csv.LogParser;

class LogParserTest {

    private final String FILE_PATH = "../logs/cookie_log.csv";
    private LogParser logParser;

    @BeforeEach
    public void setUp() {
        logParser = new LogParser();
    }

    @Test
    void testParseValidLogFile() {
        List<CookieLog> cookieLogs = logParser.parseLogFile(FILE_PATH);
        assertEquals(8, cookieLogs.size());
    }

    @Test
    void testInvalidPathLogFile() {
        Exception exception = assertThrows(LogsParseException.class, () -> {
            logParser.parseLogFile("invalid_file.csv");
        });

        assertEquals("Error parsing log file, the file path not exist ", exception.getMessage());
    }

}
