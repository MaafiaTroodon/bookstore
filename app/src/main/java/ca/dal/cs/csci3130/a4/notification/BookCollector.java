package ca.dal.cs.csci3130.a4.notification;

import java.util.ArrayList;

import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.factory.Item;
import ca.dal.cs.csci3130.a4.factory.ItemCRUD;

public class BookCollector {
    ArrayList<IReader> observers;
    ArrayList<Item> books;

    public BookCollector() {
        this.observers = new ArrayList<>();
        this.books = new ItemCRUD().collectRetrievedItems(AppConstants.BOOK);
    }

    public void addNewBook(Item book) {
        this.books.add(book);
        String message = getMessage(book, true);
        this.notifyAllReaders(message);
    }

    public void removeOldBook(Item book) {
        this.books.remove(book);
        String message = getMessage(book, false);
        this.notifyAllReaders(message);
    }

    public Item selectABook() {
        if (this.books.isEmpty()) {
            return null;
        } else return this.books.get(0);
    }

    protected String getMessage(Item book, boolean added) {
        if (added) {
            return "Added: " + book.getName();
        } else {
            return "Removed: " + book.getName();
        }
    }

    public void attach(IReader reader) {
        //Incomplete method, add the feature!
    }

    private void notifyAllReaders(String message) {
        //Incomplete method, add the feature!
    }
}
