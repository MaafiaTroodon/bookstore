package ca.dal.cs.csci3130.a4.factory;

import java.util.ArrayList;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class ItemCRUD {

    ArrayList<Item> items;

    public ItemCRUD() {
        this.items = new ArrayList<>();
        this.loadSampleItems();
    }

    protected void loadSampleItems() {
        this.loadBooks();
        this.loadFood();
    }

    protected void loadBooks() {
        //Incomplete method, add the feature!
    }

    protected void loadFood() {
        ItemFactory factory = ItemFactoryProducer.getFactory(false);
        Item chickenBurger = factory.getItem(AppConstants.CHICKEN_BURGER);
        this.items.add(chickenBurger);
        Item classicPoutine = factory.getItem(AppConstants.CLASSIC_POUTINE);
        this.items.add(classicPoutine);
        Item cheesePizza = factory.getItem(AppConstants.CHEESE_PIZZA);
        this.items.add(cheesePizza);
    }

    public ArrayList<Item> collectRetrievedItems(String category) {
        //buggy method, fix the bug!
        return null;
    }

    public ArrayList<String> collectItemHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Item");
        headers.add("Price");
        return headers;
    }

    public Item deliverTopItem(ArrayList<Item> items) {
        if (!items.isEmpty()) {
            Item topItem = items.get(0);
            items.remove(topItem);
            return topItem;
        } else return null;
    }
}
