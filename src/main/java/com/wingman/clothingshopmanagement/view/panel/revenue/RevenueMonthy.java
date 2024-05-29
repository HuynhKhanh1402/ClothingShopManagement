package com.wingman.clothingshopmanagement.view.panel.revenue;
import lombok.Getter;

/**
 *
 * @author ADMIN
 */
public class RevenueMonthy {

    @Getter
    private final int monthOfYear;
    @Getter
    private final int year;
    @Getter
    private final double revenue;

    public RevenueMonthy(int monthOfYear, int year, double revenue) {
        this.monthOfYear = monthOfYear;
        this.year = year;
        this.revenue = revenue;

    }
}