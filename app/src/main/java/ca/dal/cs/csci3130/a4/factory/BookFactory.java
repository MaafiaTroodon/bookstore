package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class BookFactory implements ItemFactory {

    @Override
    public Item getItem(String itemType) {
        if (itemType.equals(AppConstants.DA_VINCI_CODE)) {
            return new DaVinciCode();
        } else if (itemType.equals(AppConstants.SHERLOCK_HOLMES)) {
            return new SherlockHolmes();
        }
        return null;
    }
}
