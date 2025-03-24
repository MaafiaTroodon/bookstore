package ca.dal.cs.csci3130.a4.factory;

public class ItemFactoryProducer {
    public static ItemFactory getFactory(boolean isBook) {
        if (isBook) {
            return new BookFactory();
        } else {
            return new FoodFactory();
        }
    }
}
