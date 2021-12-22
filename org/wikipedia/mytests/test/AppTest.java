package org.wikipedia.mytests.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wikipedia.main.MainActivity;
import org.wikipedia.mytests.config.ConfProperties;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AppTest
{
    private BeginPage beginPage = new BeginPage();
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private MainPage mainPage;
    private MenuPage menuPage;
    private RegistrationPage registrationPage;
    private SearchPage searchPage;
    private SettingsPage settingsPage;
    private ThemePage themePage;

    private SwipesClass swipesClass = new SwipesClass();

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void all()
    {
        beginPage.isBeginActivity();
        mainPage = beginPage.clickSkip();
        mainPage.isMainActivity();
        menuPage = mainPage.clickMenu();
        menuPage.isMenuActivity();
        registrationPage = menuPage.clickRegistration();
        registrationPage.isRegistrationActivity();
        loginPage = registrationPage.clickLogin();

        loginPage.isLoginActivity();
        mainPage = loginPage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        mainPage.isMainActivity();
        searchPage = mainPage.clickSearch();
        searchPage.isSearchActivity();
        searchPage.isSearchPage();

        menuPage = mainPage.clickMenu();
        menuPage.isMenuActivity();
        settingsPage = menuPage.clickSettings();
        settingsPage.isSettingsActivity();

        themePage = settingsPage.clickTheme();
        themePage.isThemeActivity();
        themePage.clickThemeSepia();
        settingsPage = themePage.clickBack();
        settingsPage.isSettingsActivity();
        settingsPage.isThemeSepia();

        swipesClass.swipeUp();

        logoutPage = settingsPage.clickLogout();
        logoutPage.isLogoutActivity();
        mainPage = logoutPage.clickLogout();

        mainPage.processToastLogout();
    }
}
