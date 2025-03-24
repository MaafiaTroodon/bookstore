package ca.dal.cs.csci3130.a4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.dal.cs.csci3130.a4.ui.LandingActivity;

@RunWith(AndroidJUnit4.class)
public class StudentEspressoTest {

    ActivityScenario<LandingActivity> activityScenario;

    @Test
    public void testStudentWithSilverMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Silver"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$20.00")));
    }

    @Test
    public void testStudentWithGoldMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Gold"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$30.00")));
    }

    @Test
    public void testStudentWithPlatinumMembership() {
        activityScenario = ActivityScenario.launch(LandingActivity.class);
        onView(withId(R.id.depositBox)).perform(typeText("200"));
        onView(withId(R.id.membershipSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Platinum"))).perform(click());
        onView(withId(R.id.calculateDiscountButton)).perform(click());
        onView(withId(R.id.totalDiscountLabel)).check(matches(withText("$40.00")));
    }
}
