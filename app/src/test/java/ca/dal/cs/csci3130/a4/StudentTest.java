package ca.dal.cs.csci3130.a4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.discount.DalWallet;
import ca.dal.cs.csci3130.a4.discount.DiscountCalculator;
import ca.dal.cs.csci3130.a4.discount.IStudent;
import ca.dal.cs.csci3130.a4.discount.IWallet;
import ca.dal.cs.csci3130.a4.discount.Membership;
import ca.dal.cs.csci3130.a4.discount.Student;
import ca.dal.cs.csci3130.a4.discount.StudentSRP;

public class StudentTest {

    @Test
    public void testStudent() {
        IStudent student = new Student("Jane", "Doe");
        IWallet wallet = new DalWallet(200);
        student.setWallet(wallet);
        assertEquals(30, (int) student.calculateDiscount());
        assertNotEquals(35, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithSilverMembership() {
        StudentSRP student = new StudentSRP("John", "Doe");
        IWallet wallet = new DalWallet(300);
        student.setWallet(wallet);

        DiscountCalculator silverDiscountCalculator = new DiscountCalculator(AppConstants.SILVER_RATE);
        Membership silver = new Membership(silverDiscountCalculator);
        student.setMembership(silver);
        assertEquals(30, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithGoldMembership() {
        StudentSRP student = new StudentSRP("Max", "Payne");
        IWallet wallet = new DalWallet(300);
        student.setWallet(wallet);

        DiscountCalculator goldDiscountCalculator = new DiscountCalculator(AppConstants.GOLD_RATE);
        Membership gold = new Membership(goldDiscountCalculator);
        student.setMembership(gold);
        assertEquals(45, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithPlatinumMembership() {
        StudentSRP student = new StudentSRP("Jane", "Doe");
        IWallet wallet = new DalWallet(300);
        student.setWallet(wallet);

        DiscountCalculator goldDiscountCalculator = new DiscountCalculator(AppConstants.PLATINUM_RATE);
        Membership gold = new Membership(goldDiscountCalculator);
        student.setMembership(gold);
        assertEquals(60, (int) student.calculateDiscount());
    }
}
