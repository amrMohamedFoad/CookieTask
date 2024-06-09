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

    private LogParser logParser;

    @BeforeEach
    public void setUp() {
        logParser = new LogParser();
    }

    @Test
    void testParseValidLogFile() {
        String file = "logs/test/valid_cookie_log.csv";
        List<CookieLog> cookieLogs = logParser.parseLogFile(file);
        assertEquals(3, cookieLogs.size());
    }

    @Test
    void testInvalidPathLogFile() {
        Exception exception = assertThrows(LogsParseException.class, () -> {
            logParser.parseLogFile("invalid_file.csv");
        });

        assertEquals("Error parsing log file, the file path not exist ", exception.getMessage());
    }

}
