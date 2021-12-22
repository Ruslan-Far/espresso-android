package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class ThemePage
{
    public void isThemeActivity()
    {
        onView(withId(R.layout.dialog_theme_chooser)).check(matches(isDisplayed()));
    }

    public void clickThemeSepia()
    {
        WaitService.delay(2);
        onView(allOf(withId(R.id.button_theme_sepia), isDisplayed()))
                .perform(click());
    }

    public SettingsPage clickBack()
    {
        WaitService.delay(1);
        onView(allOf(withId(android.R.id.content), isDisplayed()))
                .perform(pressBack());
        return new SettingsPage();
    }
}
