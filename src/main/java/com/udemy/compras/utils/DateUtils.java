package com.udemy.compras.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    private static final String PATTERN = "dd/MM/yyyy HH:mm";

    private static final SimpleDateFormat sf = new SimpleDateFormat(PATTERN);

    static {
        sf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }

    public static String toString(Date d) {
        return sf.format(d);
    }

    public static Date toDate(String s) {
        try {
            return sf.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
