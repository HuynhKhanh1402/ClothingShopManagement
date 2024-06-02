package com.wingman.clothingshopmanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
    
    public static String formatDateAndTime(Date date) {
        return DATE_AND_TIME_FORMAT.format(date);
    }
    
    public static Date parseDate(String stringDate) throws ParseException {
        return DATE_FORMAT.parse(stringDate);
    }
    
    public static Date parseDateAndTime(String stringDate) throws ParseException {
        return DATE_AND_TIME_FORMAT.parse(stringDate);
    }
}
