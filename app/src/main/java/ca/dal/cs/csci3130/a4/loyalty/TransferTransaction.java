package ca.dal.cs.csci3130.a4.loyalty;

public class TransferTransaction implements Transaction {

    ILoyaltyCard card;
    int MINIMUM_POINTS = 500;

    public TransferTransaction(ILoyaltyCard anotherCard) {
        this.card = anotherCard;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard card) {
        //buggy method, fix the bug!
        return false;
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }
}
