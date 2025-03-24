package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class Burger implements Item {
    @Override
    public String getName() {
        return AppConstants.CHICKEN_BURGER;
    }

    @Override
    public double getPrice() {
        return 15;
    }

    @Override
    public String getCategory() {
        return AppConstants.FOOD;
    }
}
