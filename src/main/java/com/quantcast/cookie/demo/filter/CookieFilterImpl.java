package com.quantcast.cookie.demo.filter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quantcast.cookie.demo.exception.LogsParseException;
import com.quantcast.cookie.demo.model.CookieLog;

@Component
public class CookieFilterImpl implements CookieFilter {

    @Override
    public List<String> filterByDate(List<CookieLog> cookieLogs, LocalDate date) throws LogsParseException {
        List<String> filteredCookieLogs = new ArrayList<>();
        for (CookieLog cookieLog : cookieLogs) {
            String cookie = cookieLog.getCookie();
            LocalDate cookieLogDate = cookieLog.getDateTime().toLocalDate();
            if (cookieLogDate.equals(date)) {
                filteredCookieLogs.add(cookie);
            }
        }
        return filteredCookieLogs;
    }

}
