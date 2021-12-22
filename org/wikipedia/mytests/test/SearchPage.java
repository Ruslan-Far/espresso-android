package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class SearchPage
{
    public void isSearchActivity()
    {
        onView(withId(R.layout.view_history_header_with_search)).check(matches(isDisplayed()));
    }

    public void isSearchPage()
    {
        WaitService.delay(3);
        onView(allOf(withId(R.id.history_title))).check(matches(isDisplayed()));
    }
}
