package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class Poutine implements Item {
    @Override
    public String getName() {
        return AppConstants.CLASSIC_POUTINE;
    }

    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public String getCategory() {
        return AppConstants.FOOD;
    }
}
