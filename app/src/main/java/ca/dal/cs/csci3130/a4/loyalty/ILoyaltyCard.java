package ca.dal.cs.csci3130.a4.loyalty;

public interface ILoyaltyCard {
    public boolean performTransaction(Transaction transaction);

    public int getCurrentPoints();

    public void setCurrentPoints(int points);
}
