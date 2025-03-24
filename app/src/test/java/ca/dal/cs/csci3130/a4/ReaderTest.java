package ca.dal.cs.csci3130.a4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.factory.Item;
import ca.dal.cs.csci3130.a4.factory.ItemFactory;
import ca.dal.cs.csci3130.a4.factory.ItemFactoryProducer;
import ca.dal.cs.csci3130.a4.notification.BookCollector;
import ca.dal.cs.csci3130.a4.notification.IReader;
import ca.dal.cs.csci3130.a4.notification.Reader;

public class ReaderTest {

    BookCollector collector;
    IReader student;
    IReader professor;
    IReader librarian;

    @Before
    public void setup() {
        this.collector = new BookCollector();
        this.student = new Reader(this.collector);
        this.professor = new Reader(this.collector);
        this.librarian = new Reader(this.collector);
    }

    @Test
    public void testNotifyNewBookAddition() {
        ItemFactory factory = ItemFactoryProducer.getFactory(true);
        Item newBook = factory.getItem(AppConstants.DA_VINCI_CODE);
        this.collector.addNewBook(newBook);
        String notificationMessage = "Added: " + newBook.getName();
        Assert.assertEquals(notificationMessage, student.getNotification());
        Assert.assertEquals(notificationMessage, professor.getNotification());
        Assert.assertEquals(notificationMessage, librarian.getNotification());
    }

    @Test
    public void testNotifyBookRemoval() {
        Item oldBook = this.collector.selectABook();
        Assert.assertNotNull(oldBook);
        this.collector.removeOldBook(oldBook);
        String notificationMessage = "Removed: " + oldBook.getName();
        Assert.assertEquals(notificationMessage, student.getNotification());
        Assert.assertEquals(notificationMessage, professor.getNotification());
        Assert.assertEquals(notificationMessage, librarian.getNotification());
    }
}
