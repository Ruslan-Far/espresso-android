package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class BeginPage
{
    public void isBeginActivity()
    {
        onView(withId(R.layout.fragment_onboarding_pager)).check(matches(isDisplayed()));
    }

    public MainPage clickSkip()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.fragment_onboarding_skip_button), isDisplayed()))
                .perform(click());
        return new MainPage();
    }
}
