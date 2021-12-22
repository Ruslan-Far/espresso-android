package org.wikipedia.mytests.services;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeUnit;

public class WaitService
{
    public static void delay(long sec) {
        onView(isRoot()).perform(waitOnId(TimeUnit.SECONDS.toMillis(sec)));
    }

    private static ViewAction waitOnId(long millis)
    {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints()
            {
                return isRoot();
            }

            @Override
            public String getDescription()
            {
                return "Wait a specified amount of time.";
            }

            @Override
            public void perform(UiController uiController, View view)
            {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }
}
