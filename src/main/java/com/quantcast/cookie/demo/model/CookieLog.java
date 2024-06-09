package com.quantcast.cookie.demo.model;

import java.time.LocalDateTime;

public class CookieLog {

    private String cookie;
    private LocalDateTime dateTime;

    public CookieLog(String cookie, LocalDateTime dateTime) {
        this.cookie = cookie;
        this.dateTime = dateTime;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
