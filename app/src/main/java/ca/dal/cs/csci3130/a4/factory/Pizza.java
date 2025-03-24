package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class Pizza implements Item {
    @Override
    public String getName() {
        return AppConstants.CHEESE_PIZZA;
    }

    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public String getCategory() {
        return AppConstants.FOOD;
    }
}
