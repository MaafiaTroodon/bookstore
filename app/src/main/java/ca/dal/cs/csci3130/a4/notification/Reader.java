package ca.dal.cs.csci3130.a4.notification;

public class Reader extends IReader {
    BookCollector collector;
    String notification;

    public Reader(BookCollector collector) {
        //Incomplete constructor, add necessary logic
    }

    @Override
    public void notifyMe(String newBookTitle) {
        this.notification = newBookTitle;
    }

    @Override
    public String getNotification() {
        return this.notification;
    }
}
