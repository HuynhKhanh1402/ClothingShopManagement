/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wingman.clothingshopmanagement.util;

import java.text.DecimalFormat;

/**
 *
 * @author Administrator
 */
public class NumberFormatter {
    private static DecimalFormat FORMAT = new DecimalFormat("###,###.##");
    
    public static String format(double num) {
        return FORMAT.format(num);
    }
}
