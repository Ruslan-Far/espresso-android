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

public class SettingsPage
{
    public void isSettingsActivity()
    {
        onView(withId(R.xml.preferences)).check(matches(isDisplayed()));
    }

    public void isThemeSepia()
    {
        WaitService.delay(1);
        onView(allOf(withText("Sepia"))).check(matches(isDisplayed()));
    }

    public ThemePage clickTheme()
    {
        WaitService.delay(2);
        onView(allOf(withText("App theme"), isDisplayed()))
                .perform(click());
        return new ThemePage();
    }

    public LogoutPage clickLogout()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.logoutButton), isDisplayed()))
                .perform(click());
        return new LogoutPage();
    }
}
