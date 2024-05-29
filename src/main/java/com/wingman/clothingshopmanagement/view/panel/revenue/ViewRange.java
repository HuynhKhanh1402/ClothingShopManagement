/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.wingman.clothingshopmanagement.view.panel.revenue;

import java.util.Optional;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
public enum ViewRange {
    TODAY("Today"),
    WEEK("Week"),
    MONTH("Month"),
    THREE_MONTHS("3 Months"),
    YEAR("Year"),
    TOTAL("Total"),
    CUSTOM("Custom");
    
    @Getter
    private final String value;
    
    private ViewRange(String value) {    
        this.value = value;
    }
    
    public static Optional<ViewRange> parse(String value) {
        for (ViewRange vr: values()) {
            if (value.equalsIgnoreCase(vr.toString()) || value.equalsIgnoreCase(vr.getValue())) {
                return Optional.of(vr);
            }
        }
        return Optional.empty();
    }
}
