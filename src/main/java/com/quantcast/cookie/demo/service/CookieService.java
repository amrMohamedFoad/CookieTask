package com.quantcast.cookie.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quantcast.cookie.demo.filter.CookieFilter;
import com.quantcast.cookie.demo.model.CookieLog;
import com.quantcast.cookie.demo.parser.csv.LogParser;

@Service
public class CookieService {

    LogParser logParser;
    CookieFilter cookieFilter;

    @Autowired
    public CookieService(LogParser logParser, CookieFilter cookieFilter) {
        this.logParser = logParser;
        this.cookieFilter = cookieFilter;
    }

    public List<String> findMostActiveCookies(String fileName, LocalDate date) {
        List<CookieLog> cookieLogs = logParser.parseLogFile(fileName);
        List<String> filteredCookies = cookieFilter.filterByDate(cookieLogs, date);
        return mostActiveCookies(filteredCookies);
    }

    /*
     * Time: O(n), n is the number of cookie logs
     * Space: O(m), m is the number of unique cookies
     */
    private List<String> mostActiveCookies(List<String> cookies) {

        Map<String, Integer> cookieMap = new HashMap<>();
        // count cookie freqency
        for (String cookie : cookies) {
            if (cookieMap.containsKey(cookie)) {
                cookieMap.put(cookie, cookieMap.get(cookie) + 1);
            } else {
                cookieMap.put(cookie, 1);
            }
        }
        // get most active cookies
        List<String> mostActiveCookies = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> cookieEntry : cookieMap.entrySet()) {
            String cookie = cookieEntry.getKey();
            int cookieCount = cookieEntry.getValue();
            if (cookieCount > count) {
                mostActiveCookies.clear();
                mostActiveCookies.add(cookie);
                count = cookieCount;
            } else if (cookieCount == count) {
                mostActiveCookies.add(cookie);
            }
        }

        return mostActiveCookies;
    }

}
