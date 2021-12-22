package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;

public class SwipesClass
{
    public void swipeUp()
    {
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
    }

    public void swipeDown()
    {
        onView(withId(android.R.id.content)).perform(ViewActions.swipeDown());
    }

    public void swipeRight()
    {
        onView(withId(android.R.id.content)).perform(ViewActions.swipeRight());
    }

    public void swipeLeft()
    {
        onView(withId(android.R.id.content)).perform(ViewActions.swipeLeft());
    }
}
