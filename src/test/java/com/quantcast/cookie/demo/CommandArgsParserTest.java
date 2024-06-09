package com.quantcast.cookie.demo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.quantcast.cookie.demo.exception.LogsParseException;
import com.quantcast.cookie.demo.parser.commandline.CommandArgsParser;
import com.quantcast.cookie.demo.parser.commandline.CommandLineArgs;

class CommandArgsParserTest {

    private CommandArgsParser commandLineParser;

    @BeforeEach
    public void setUp() {
        commandLineParser = new CommandArgsParser();
    }

    @Test
    void testValidArguments() {
        String[] args = new String[] { "-f", "logs/cookie_log.csv", "-d", "2018-12-09" };
        CommandLineArgs commandLineArgs = commandLineParser.parse(args);
        assertEquals("logs/cookie_log.csv", commandLineArgs.getFileName());
        assertEquals(LocalDate.parse("2018-12-09"), commandLineArgs.getDate());
    }

    @Test
    void testMissingDateArgument() {
        String[] args = new String[] { "-f", "logs/cookie_log.csv" };
        CommandLineArgs commandLineArgs = commandLineParser.parse(args);
        assertEquals("logs/cookie_log.csv", commandLineArgs.getFileName());
    }

    @Test
    void testInvalidDateFormat() {
        String[] args = new String[] { "-f", "logs/cookie_log.csv", "-d",
                "invalid-date" };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            commandLineParser.parse(args);
        });

        assertEquals("Invalid date format, expected yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testMissingFilenameArgument() {
        String[] args = new String[] { "-d", "2018-12-09" };
        Exception exception = assertThrows(LogsParseException.class, () -> {
            commandLineParser.parse(args);
        });

        assertEquals("Failed to parse command line arguments", exception.getMessage());
    }

}
