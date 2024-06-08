package com.quantcast.cookie.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quantcast.cookie.demo.parser.commandline.CommandArgsParser;
import com.quantcast.cookie.demo.parser.commandline.CommandLineArgs;

/*
  * the entry point of our cookie Application which contains run method 
*/
@Component
public class CookieApplicationRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieApplicationRunner.class);
    private final CommandArgsParser parser;

    @Autowired
    public CookieApplicationRunner(CommandArgsParser parser) {
        this.parser = parser;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            LOGGER.info("Running Cookie Application");
            CommandLineArgs commandLineArgs = parser.parse(args);
            LOGGER.info(commandLineArgs.getFileName());
            LOGGER.info(commandLineArgs.getDate().toString());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}