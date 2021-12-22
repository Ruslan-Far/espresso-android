package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class MenuPage
{
    public void isMenuActivity()
    {
        onView(withId(R.layout.view_main_drawer)).check(matches(isDisplayed()));
    }

    public RegistrationPage clickRegistration()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.main_drawer_login_button), isDisplayed()))
                .perform(click());
        return new RegistrationPage();
    }

    public SettingsPage clickSettings()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.main_drawer_settings_container), isDisplayed()))
                .perform(click());
        return new SettingsPage();
    }
}
