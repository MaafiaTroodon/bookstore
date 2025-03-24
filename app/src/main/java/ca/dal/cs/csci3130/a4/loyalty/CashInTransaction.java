package ca.dal.cs.csci3130.a4.loyalty;

public class CashInTransaction implements Transaction {
    int point2Cash;
    int MINIMUM_POINTS = 1000;

    public CashInTransaction(int point2Cash) {
        this.point2Cash = point2Cash;
    }

    public boolean performTransaction(ILoyaltyCard card) {
        //buggy method, fix the bug!
        return false;
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }

}
