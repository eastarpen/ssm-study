package com.eastarpen.demo06.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

    private static String defaultFormatStr = "yyyy-MM-dd";

    public static Date stringToDate(String dateStr) {
        return stringToDate(dateStr, defaultFormatStr);
    }

    public static Date stringToDate(String dateStr, String formatStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
