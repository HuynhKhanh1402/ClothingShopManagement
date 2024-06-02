package com.wingman.clothingshopmanagement.util;

import java.text.DecimalFormat;


public class NumberFormatter {
    private static final DecimalFormat FORMAT = new DecimalFormat("#,##0.##");
    
    public static String format(double num) {
        return FORMAT.format(num).replace(".", " ");
    }
    
    public static String formatWithoutComma(double num) {
        return new DecimalFormat("#.##").format(num);
    }
}
