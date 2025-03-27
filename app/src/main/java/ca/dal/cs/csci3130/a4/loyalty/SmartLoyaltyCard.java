package ca.dal.cs.csci3130.a4.loyalty;

public class SmartLoyaltyCard implements ILoyaltyCard {

    int currentPoints;

    public SmartLoyaltyCard(int points) {
        this.currentPoints = points;
    }

    @Override
    public boolean performTransaction(Transaction transaction) {
        return transaction.performTransaction(this);
    }

    public int getCurrentPoints() {
        return this.currentPoints;
    }

    public void setCurrentPoints(int points) {
        this.currentPoints = points;
    }
}


