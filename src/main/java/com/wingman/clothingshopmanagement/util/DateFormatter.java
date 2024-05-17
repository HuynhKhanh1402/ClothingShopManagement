/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DateFormatter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
    
    public static String formatDateAndTime(Date date) {
        return DATE_AND_TIME_FORMAT.format(date);
    }
}
