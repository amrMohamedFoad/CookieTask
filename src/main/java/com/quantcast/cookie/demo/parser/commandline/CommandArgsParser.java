package com.quantcast.cookie.demo.parser.commandline;

import java.time.LocalDate;

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
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided");
        }

        Options options = getOptions();
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String fileName = cmd.getOptionValue("f");
            LocalDate date = LocalDate.parse(cmd.getOptionValue("d"));
            return new CommandLineArgs(fileName, date);
        } catch (ParseException exception) {
            throw new LogsParseException("Error parsing command line arguments", exception);
        }
    }

    private Options getOptions() {
        Options options = new Options();
        options.addRequiredOption("f", "filename", true, "The path of the cookie log CSV file");
        options.addOption("d", "date", true, "The date to get most active cookies for");
        return options;
    }

}
