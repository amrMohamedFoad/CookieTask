package com.quantcast.cookie.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.quantcast.cookie.demo.parser.commandline.CommandArgsParser;
import com.quantcast.cookie.demo.parser.commandline.CommandLineArgs;
import com.quantcast.cookie.demo.service.CookieService;

/*
  * the entry point of our cookie Application which contains run method 
*/
@Component
public class CookieApplicationRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieApplicationRunner.class);
    private final CommandArgsParser parser;
    private final CookieService cookieService;

    @Autowired
    public CookieApplicationRunner(CommandArgsParser parser, CookieService cookieService) {
        this.parser = parser;
        this.cookieService = cookieService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            LOGGER.info("Running Cookie Application");
            CommandLineArgs commandLineArgs = parser.parse(args);
            LOGGER.info("File Name: " + commandLineArgs.getFileName() + " Date: " + commandLineArgs.getDate());
            List<String> mostActiveCookies = cookieService.findMostActiveCookies(commandLineArgs.getFileName(),
                    commandLineArgs.getDate());
            LOGGER.info("Most active cookies for date: " + commandLineArgs.getDate());

            // print mostActiveCookies
            for (String cookie : mostActiveCookies) {
                LOGGER.info(cookie);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
