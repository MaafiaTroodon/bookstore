package ca.dal.cs.csci3130.a4.factory;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class FoodFactory implements ItemFactory {
    @Override
    public Item getItem(String itemType) {
        if (itemType.equals(AppConstants.CHICKEN_BURGER)) {
            return new Burger();
        } else if (itemType.equals(AppConstants.CLASSIC_POUTINE)) {
            return new Poutine();
        } else if (itemType.equals(AppConstants.CHEESE_PIZZA)) {
            return new Pizza();
        }
        return null;
    }
}
