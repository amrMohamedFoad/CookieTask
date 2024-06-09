package com.quantcast.cookie.demo.filter;

import java.time.LocalDate;
import java.util.List;

import com.quantcast.cookie.demo.exception.LogsParseException;
import com.quantcast.cookie.demo.model.CookieLog;

/*
  * contains all filter options on cookie logs
 */
public interface CookieFilter {

  List<String> filterByDate(List<CookieLog> cookieLogs, LocalDate date) throws LogsParseException;
}
