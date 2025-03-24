package ca.dal.cs.csci3130.a4.loyalty;

public class LoyaltyCard {

    static int MINIMUM_POINTS = 500;
    final int CASH_IN = 1;
    final int TRANSFER_POINT = 2;
    int currentPoints;

    public LoyaltyCard(int points) {
        this.currentPoints = points;
    }

    public void performTransaction(int transactionType, int point2Cash,
                                   LoyaltyCard anotherCard) {
        switch (transactionType) {
            case CASH_IN:
                cashIn(point2Cash);
                break;

            case TRANSFER_POINT:
                transfer(anotherCard);
                break;
        }
    }

    public boolean cashIn(int points2Cash) {
        if (isLowPoints()) {
            notifyCardHolder("Failed to cash in due to low points!");
            return false;
        } else {
            if (points2Cash > this.currentPoints) return false;
            this.currentPoints = this.currentPoints - points2Cash;
            return true;
        }
    }

    public boolean transfer(LoyaltyCard anotherCard) {
        if (isLowPoints()) {
            notifyCardHolder("Failed to transfer due to low points!");
            return false;
        } else {
            //transferring points to another card
            anotherCard.currentPoints += this.currentPoints;
            this.currentPoints = 0;
            return true;
        }
    }


    protected boolean isLowPoints() {
        return this.currentPoints < MINIMUM_POINTS;
    }

    public int getCurrentPoints() {
        return this.currentPoints;
    }

    protected void notifyCardHolder(String message) {
        System.out.println("Message:" + message);
    }
}
