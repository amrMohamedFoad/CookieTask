package com.quantcast.cookie.demo;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.quantcast.cookie.demo.filter.CookieFilterImpl;
import com.quantcast.cookie.demo.parser.csv.LogParser;
import com.quantcast.cookie.demo.service.CookieService;

class CookieServiceTest {

    private final String TEST_LOGS_PATH = "src/test/java/com/quantcast/cookie/demo/resources/logs/";
    private CookieService cookieService;

    @BeforeEach
    void setUp() {
        cookieService = new CookieService(new LogParser(), new CookieFilterImpl());
    }

    @Test
    void testFindMostActiveCookies_HasOnlyOneMostActiveCookie() {
        LocalDate date = LocalDate.parse("2018-12-09");
        List<String> mostActiveCookies = cookieService
                .findMostActiveCookies(TEST_LOGS_PATH + "cookie_log.csv", date);
        assertEquals(1, mostActiveCookies.size());
        assertEquals("AtY0laUfhglK3lC7", mostActiveCookies.get(0));
    }

    @Test
    void testFindMostActiveCookies_HasNoMostActiveCookies() {
        LocalDate date = LocalDate.parse("2018-12-10");
        List<String> mostActiveCookies = cookieService
                .findMostActiveCookies(TEST_LOGS_PATH + "cookie_log.csv", date);
        assertEquals(true, mostActiveCookies.isEmpty());
    }

    @Test
    void testFindMostActiveCookies_HasMoreThanOneMostActiveCookies() {
        LocalDate date = LocalDate.parse("2018-12-08");
        List<String> mostActiveCookies = cookieService
                .findMostActiveCookies(TEST_LOGS_PATH + "cookie_log.csv", date);
        assertEquals(true, mostActiveCookies.size() > 1);
    }
}
