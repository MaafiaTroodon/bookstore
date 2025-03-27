package ca.dal.cs.csci3130.a4.notification;

public class Reader extends IReader {
    BookCollector collector;
    String notification;

    public Reader(BookCollector collector) {
        this.collector = collector;
        this.collector.attach(this); // Attach this reader to the collector
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
