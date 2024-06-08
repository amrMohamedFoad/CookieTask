package com.quantcast.cookie.demo.parser.commandline;

import java.time.LocalDate;

public class CommandLineArgs {
    private String fileName;
    private LocalDate date;

    public CommandLineArgs(String fileName, LocalDate date) {
        this.fileName = fileName;
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
