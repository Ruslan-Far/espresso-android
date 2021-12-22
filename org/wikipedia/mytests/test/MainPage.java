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

public class MainPage
{
    public void isMainActivity()
    {
        onView(withId(R.layout.fragment_main)).check(matches(isDisplayed()));
    }

    public void processToastLogout()
    {
        onView(withText(R.string.toast_logout_complete)).check(matches(isDisplayed()));
    }

    public MenuPage clickMenu()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.nav_more_container), isDisplayed()))
                .perform(click());
        return new MenuPage();
    }

    public SearchPage clickSearch()
    {
        WaitService.delay(3);
        onView(allOf(withText("Search"), isDisplayed()))
                .perform(click());
        return new SearchPage();
    }
}
