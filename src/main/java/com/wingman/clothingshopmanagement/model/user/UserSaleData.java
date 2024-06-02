package com.wingman.clothingshopmanagement.model.user;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserSaleData {
    private User user;
    private long soldProductQty;
    private double revenue;
    
    public UserSaleData(User user, long soldProductQty, double revenue) {
        this.user = user;
        this.soldProductQty = soldProductQty;
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "{" + user.getEmail() + ", " + soldProductQty + ", " + revenue + "}";
    }
}
