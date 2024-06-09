package com.quantcast.cookie.demo.parser.commandline;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.stereotype.Component;

import com.quantcast.cookie.demo.exception.LogsParseException;

@Component
public class CommandArgsParser {

    public CommandLineArgs parse(String[] args) {
        try {
            Options options = getOptions();
            CommandLine cmd = parseCommandLineArgs(args, options);
            String fileName = getOptionValue(cmd, "f", "Filename not provided");
            LocalDate date = parseDate(getOptionValue(cmd, "d", "Date not provided"));
            return new CommandLineArgs(fileName, date);
        } catch (ParseException e) {
            throw new LogsParseException("Failed to parse command line arguments", e);
        }
    }

    private Options getOptions() {
        Options options = new Options();
        options.addRequiredOption("f", "filename", true, "The path of the cookie log CSV file");
        options.addOption("d", "date", true, "The date to get most active cookies for");
        return options;
    }

    private String getOptionValue(CommandLine cmd, String option, String errorMessage) {
        String value = cmd.getOptionValue(option);
        if (value == null)
            throw new IllegalArgumentException(errorMessage);

        return value;
    }

    private CommandLine parseCommandLineArgs(String[] args, Options options) throws ParseException {
        try {
            CommandLineParser parser = new DefaultParser();
            return parser.parse(options, args);
        } catch (ParseException e) {
            throw new LogsParseException("Failed to parse command line arguments", e);
        }
    }

    private LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format, expected yyyy-MM-dd", e);
        }
    }

}
