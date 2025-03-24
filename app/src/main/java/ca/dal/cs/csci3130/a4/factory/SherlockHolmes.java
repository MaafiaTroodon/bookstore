package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class SherlockHolmes implements Item {
    @Override
    public String getName() {
        return AppConstants.SHERLOCK_HOLMES;
    }

    @Override
    public double getPrice() {
        return 150;
    }

    @Override
    public String getCategory() {
        return AppConstants.BOOK;
    }
}
