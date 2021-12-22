package org.wikipedia.mytests.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import android.widget.EditText;

import org.wikipedia.R;
import org.wikipedia.mytests.services.WaitService;

public class LoginPage
{
    public void isLoginActivity()
    {
        onView(withId(R.layout.activity_login)).check(matches(isDisplayed()));
    }

    public void inputLogin(String login)
    {
        WaitService.delay(1);
        onView(allOf(withClassName(containsString(EditText.class.getSimpleName())), isDescendantOfA(withId(R.id.login_username_text))))
                .perform(replaceText(login), closeSoftKeyboard());
    }

    public void inputPassword(String password)
    {
        WaitService.delay(1);
        onView(allOf(withClassName(containsString(EditText.class.getSimpleName())), isDescendantOfA(withId(R.id.login_password_input))))
                .perform(replaceText(password), closeSoftKeyboard());
    }

    public MainPage clickLogin()
    {
        WaitService.delay(1);
        onView(withId(R.id.login_button))
                .perform(click()).check(matches(isDisplayed()));
        return new MainPage();
    }

    public MainPage login(String login, String password)
    {
        inputLogin(login);
        inputPassword(password);
        return clickLogin();
    }
}
