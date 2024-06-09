package com.quantcast.cookie.demo;

import org.junit.jupiter.api.BeforeEach;

import com.quantcast.cookie.demo.filter.CookieFilter;
import com.quantcast.cookie.demo.filter.CookieFilterImpl;
import com.quantcast.cookie.demo.parser.csv.LogParser;
import com.quantcast.cookie.demo.service.CookieService;

public class CookieServiceTest {

    private CookieService cookieService;
    private LogParser logParser;
    private CookieFilter cookieFilter;

    @BeforeEach
    void setUp() {
        logParser = new LogParser();
        cookieFilter = new CookieFilterImpl();
        cookieService = new CookieService(logParser, cookieFilter);
    }

    // @Test
    // void testFindMostActiveCookies_HasOnlyOneMostActiveCookie() {
    // }

    // @Test
    // void testFindMostActiveCookies_HasNoMostActiveCookies() {

    // }

    // @Test
    // void testFindMostActiveCookies_HasMoreThanOneMostActiveCookies() {

    // }
}
