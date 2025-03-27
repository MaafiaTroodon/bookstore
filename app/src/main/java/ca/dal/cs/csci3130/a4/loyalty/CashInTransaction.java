package ca.dal.cs.csci3130.a4.loyalty;

public class CashInTransaction implements Transaction {
    int point2Cash;
    int MINIMUM_POINTS = 1000;

    public CashInTransaction(int point2Cash) {
        this.point2Cash = point2Cash;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard card) {
        if (isLowPoints(card.getCurrentPoints()) || point2Cash > card.getCurrentPoints()) {
            return false;
        }
        card.setCurrentPoints(card.getCurrentPoints() - point2Cash);
        return true;
    }
    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }

}
