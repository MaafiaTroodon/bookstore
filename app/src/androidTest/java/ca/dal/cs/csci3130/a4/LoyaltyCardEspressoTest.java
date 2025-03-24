package ca.dal.cs.csci3130.a4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.loyalty.SmartLoyaltyCard;
import ca.dal.cs.csci3130.a4.ui.LoyaltyActivity;

@RunWith(AndroidJUnit4.class)
public class LoyaltyCardEspressoTest {

    ActivityScenario<LoyaltyActivity> activityScenario;

    @Before
    public void setup() {
        activityScenario = ActivityScenario.launch(LoyaltyActivity.class);
        activityScenario.onActivity(activity -> {
            activity.smartLoyaltyCard = new SmartLoyaltyCard(AppConstants.INITIAL_LOYALTY_POINTS);
        });
    }

    @Test
    public void testCashIn() {
        onView(withId(R.id.point2DeductBox)).perform(typeText("500"));
        onView(withId(R.id.cashInButton)).perform(click());
        onView(withId(R.id.makeTransactionButton)).perform(click());
        onView(withText(AppConstants.TRANSACTION_SUCCESSFUL)).check(matches(isDisplayed()));
    }

    @Test
    public void testTransfer() {
        onView(withId(R.id.transferButton)).perform(click());
        onView(withId(R.id.makeTransactionButton)).perform(click());
        onView(withText(AppConstants.TRANSACTION_SUCCESSFUL)).check(matches(isDisplayed()));
    }

    @Test
    public void testBuyBook() {
        onView(withId(R.id.point2DeductBox)).perform(typeText("3000"));
        onView(withId(R.id.buyBookButton)).perform(click());
        onView(withId(R.id.makeTransactionButton)).perform(click());
        onView(withText(AppConstants.TRANSACTION_FAILED)).check(matches(isDisplayed()));
    }
}
