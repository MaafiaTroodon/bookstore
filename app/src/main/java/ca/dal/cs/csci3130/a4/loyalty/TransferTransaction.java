package ca.dal.cs.csci3130.a4.loyalty;

public class TransferTransaction implements Transaction {


    ILoyaltyCard recipientCard;
    final int MINIMUM_POINTS = 500;

    public TransferTransaction(ILoyaltyCard anotherCard) {
        this.recipientCard = anotherCard;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard senderCard) {
        if (isLowPoints(senderCard.getCurrentPoints())) {
            return false;
        }
        int transferred = senderCard.getCurrentPoints();
        recipientCard.setCurrentPoints(recipientCard.getCurrentPoints() + transferred);
        senderCard.setCurrentPoints(0);
        return true;
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }
}
