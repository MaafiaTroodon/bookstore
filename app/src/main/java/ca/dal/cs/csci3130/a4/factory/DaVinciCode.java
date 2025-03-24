package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class DaVinciCode implements Item {
    @Override
    public String getName() {
        return AppConstants.DA_VINCI_CODE;
    }

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String getCategory() {
        return AppConstants.BOOK;
    }
}
