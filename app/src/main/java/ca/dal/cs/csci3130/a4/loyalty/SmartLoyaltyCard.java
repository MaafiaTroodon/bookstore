package ca.dal.cs.csci3130.a4.loyalty;

public class SmartLoyaltyCard implements ILoyaltyCard {

    int currentPoints;

    public SmartLoyaltyCard(int points) {
        this.currentPoints = points;
    }

    public boolean performTransaction(Transaction transaction) {
        //buggy code, fix the bug!
        return false;
    }

    public int getCurrentPoints() {
        return this.currentPoints;
    }

    public void setCurrentPoints(int points) {
        this.currentPoints = points;
    }
}


