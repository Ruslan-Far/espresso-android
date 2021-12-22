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

public class RegistrationPage
{
    public void isRegistrationActivity()
    {
        onView(withId(R.layout.activity_create_account)).check(matches(isDisplayed()));
    }

    public LoginPage clickLogin()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.create_account_login_button), withText("Log in"), isDisplayed()))
                .perform(click());
        return new LoginPage();
    }
}
