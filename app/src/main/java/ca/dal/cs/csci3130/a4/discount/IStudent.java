package ca.dal.cs.csci3130.a4.discount;

public interface IStudent {
    public void setWallet(IWallet wallet);

    public IWallet getWallet();

    public double calculateDiscount();
}
