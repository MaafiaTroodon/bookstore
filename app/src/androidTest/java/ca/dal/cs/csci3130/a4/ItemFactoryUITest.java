package ca.dal.cs.csci3130.a4;

import static android.content.Context.MODE_PRIVATE;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class ItemFactoryUITest {
    public String launcherPackage = "ca.dal.cs.csci3130.a4";
    public int TIME_OUT = 5000;
    UiDevice device;
    Context context;

    @Before
    public void setup() {
        device = UiDevice.getInstance(getInstrumentation());
        context = ApplicationProvider.getApplicationContext();
        Intent launcherIntent = context.getPackageManager().getLaunchIntentForPackage(launcherPackage);
        assert launcherIntent != null;
        launcherIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(launcherIntent);
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIME_OUT);
    }

    @Test
    public void testSearchForFood() throws UiObjectNotFoundException {
        UiObject depositBox=device.findObject(new UiSelector().text("Enter a deposit"));
        depositBox.setText("200");
        UiObject proceedButton=device.findObject(new UiSelector().text("PROCEED"));
        proceedButton.clickAndWaitForNewWindow();
        UiObject shoppingButton=device.findObject(new UiSelector().text("GO SHOPPING"));
        shoppingButton.clickAndWaitForNewWindow();
        UiObject categorySpinner = device.findObject(new UiSelector().text("Select a category"));
        categorySpinner.click();
        List<UiObject2> categories = device.findObjects(By.res("android:id/text1"));
        categories.get(1).click();
        UiObject searchButton=device.findObject(new UiSelector().text("SEARCH"));
        searchButton.click();
        UiScrollable recyclerView = new UiScrollable(new UiSelector().scrollable(false));
        assertTrue(recyclerView.exists());
        recyclerView.scrollIntoView(new UiSelector().text("Classic Poutine"));
        UiObject poutine = device.findObject(new UiSelector().text("Classic Poutine"));
        assertTrue(poutine.exists());
    }

    @Test
    public void testSearchForBooks() throws UiObjectNotFoundException {
        UiObject depositBox=device.findObject(new UiSelector().text("Enter a deposit"));
        depositBox.setText("200");
        UiObject proceedButton=device.findObject(new UiSelector().text("PROCEED"));
        proceedButton.clickAndWaitForNewWindow();
        UiObject shoppingButton=device.findObject(new UiSelector().text("GO SHOPPING"));
        shoppingButton.clickAndWaitForNewWindow();
        UiObject categorySpinner = device.findObject(new UiSelector().text("Select a category"));
        categorySpinner.click();
        List<UiObject2> categories = device.findObjects(By.res("android:id/text1"));
        categories.get(2).click();
        UiObject searchButton=device.findObject(new UiSelector().text("SEARCH"));
        searchButton.click();
        UiScrollable recyclerView = new UiScrollable(new UiSelector().scrollable(false));
        assertTrue(recyclerView.exists());
        recyclerView.scrollIntoView(new UiSelector().text("Da Vinci Code"));
        UiObject daVinciCode = device.findObject(new UiSelector().text("Da Vinci Code"));
        assertTrue(daVinciCode.exists());
    }

    @After
    public void tearDown(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstants.DAL_CARD, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
