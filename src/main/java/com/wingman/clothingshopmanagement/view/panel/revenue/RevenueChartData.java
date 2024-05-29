package com.wingman.clothingshopmanagement.view.panel.revenue;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author ADMIN
 */
public class RevenueChartData {

    @Getter
    private final List<RevenueMonthy> data;

    public RevenueChartData(List<RevenueMonthy> data) {
        this.data = data;
    }
}