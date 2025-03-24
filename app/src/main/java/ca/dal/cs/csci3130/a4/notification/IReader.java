package ca.dal.cs.csci3130.a4.notification;

public abstract class IReader {
    public abstract void notifyMe(String newBookTitle);
    public abstract String getNotification();
}
