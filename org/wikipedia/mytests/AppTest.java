package org.wikipedia.mytests;

import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import android.widget.EditText;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wikipedia.R;
import org.wikipedia.main.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AppTest
{
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void all()
    {
        login();
        search();
        setTheme();
        logout();
    }


    private void login()
    {
        Wait();
        onView(allOf(withId(R.id.fragment_onboarding_skip_button), isDisplayed()))
                .perform(click());
        Wait();
        onView(allOf(withId(R.id.nav_more_container), isDisplayed()))
                .perform(click());
        Wait();
        onView(allOf(withId(R.id.main_drawer_login_button), isDisplayed()))
                .perform(click());
        Wait();
        onView(allOf(withId(R.id.create_account_login_button), withText("Log in"), isDisplayed()))
                .perform(click());
        Wait();
        onView(allOf(withClassName(containsString(EditText.class.getSimpleName())), isDescendantOfA(withId(R.id.login_username_text))))
                .perform(replaceText("ruslan-far"), closeSoftKeyboard());
        Wait();
        onView(allOf(withClassName(containsString(EditText.class.getSimpleName())), isDescendantOfA(withId(R.id.login_password_input))))
                .perform(replaceText("123aW456"), closeSoftKeyboard());
        onView(withId(R.id.login_button))
                .perform(click()).check(matches(isDisplayed()));
    }


    private void search()
    {
        Wait();
        onView(allOf(withText("Search"),isDisplayed())).perform(click());
        Wait();
        onView(allOf(withId(R.id.history_title))).check(matches(isDisplayed()));
    }


    private void setTheme()
    {
        Wait();
        onView(allOf(withId(R.id.nav_more_container), isDisplayed())).perform(click());
        Wait();
        onView(allOf(withId(R.id.main_drawer_settings_container), isDisplayed())).perform(click());
        Wait();
        onView(allOf(withText("App theme"), isDisplayed())).perform(click());
        Wait();
        onView(allOf(withId(R.id.button_theme_sepia), isDisplayed())).perform(click());
        Wait();
        onView(allOf(withId(android.R.id.content), isDisplayed())).perform(pressBack());
        Wait();
        onView(allOf(withText("Sepia"))).check(matches(isDisplayed()));
    }


    private void logout()
    {
        Wait();
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
        Wait();
        onView(allOf(withId(R.id.logoutButton), isDisplayed())).perform(click());
        Wait();
        onView(allOf(withText("LOG OUT"), isDisplayed())).perform(click());
        Wait();
        onView(withText(R.string.toast_logout_complete)).check(matches(isDisplayed()));
    }


    private void Wait()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("error");
        }
    }
}
