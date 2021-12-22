package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class LogoutPage
{
    public void isLogoutActivity()
    {
        onView(withId(R.layout.view_preference_logout)).check(matches(isDisplayed()));
    }

    public MainPage clickLogout()
    {
        WaitService.delay(1);
        onView(allOf(withText("LOG OUT"), isDisplayed())).perform(click());
        return new MainPage();
    }
}
