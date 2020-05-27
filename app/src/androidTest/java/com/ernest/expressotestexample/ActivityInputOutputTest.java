package com.ernest.expressotestexample;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(
            MainActivity.class
            );

    @Test
    public void activityLaunch(){

        //performs a click on the button_main
        onView(withId(R.id.button_main)).perform(click());
        //checks if the text_header view is displayed
        onView(withId(R.id.text_header)).check(matches(isDisplayed()));

        //performs a click on the button_second
        onView(withId(R.id.button_second)).perform(click());
        //checks if the text_header_reply text view is displayed
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));

    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.ernest.expressotestexample", appContext.getPackageName());
    }
}
