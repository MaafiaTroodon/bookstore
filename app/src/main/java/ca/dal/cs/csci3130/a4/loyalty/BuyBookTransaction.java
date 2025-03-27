package ca.dal.cs.csci3130.a4.loyalty;


public class BuyBookTransaction implements Transaction {

    int points2Buy;
    int MINIMUM_POINTS = 1000;

    public BuyBookTransaction(int points2Buy) {
        this.points2Buy = points2Buy;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard card) {
        if (isLowPoints(card.getCurrentPoints()) || points2Buy > card.getCurrentPoints()) {
            return false;
        }
        card.setCurrentPoints(card.getCurrentPoints() - points2Buy);
        return true;
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }


}
