package com.example.a03matsevytyi;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4ClassRunner.class)
public class AppTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void countWordsButton_Clicked_DisplayResult() {

        Espresso.onView(ViewMatchers.withId(R.id.inputField))
                .perform(ViewActions.replaceText("This is a sample text"), ViewActions.closeSoftKeyboard());

        //choose "Count Words" in the spinner
        Espresso.onView(withId(R.id.chooseWhatToDo))
                .perform(click());
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Count Words"))).perform(click());

        //check whether correct option was chosen
        Espresso.onView(withId(R.id.chooseWhatToDo))
                .check(matches(withSpinnerText("Count Words")));

        Espresso.onView(withId(R.id.countWordsButton))
                .perform(click());

        //check if the result is displayed with the correct count
        Espresso.onView(withId(R.id.result))
                .check(matches(isDisplayed()))
                .check(matches(withText("You have 5 words")));
    }

    @Test
    public void countCharactersButton_Clicked_DisplayResult() {

        Espresso.onView(withId(R.id.inputField))
                .perform(ViewActions.replaceText("This is a sample text"), ViewActions.closeSoftKeyboard());

        //choose "Count Characters" in the spinner
        Espresso.onView(withId(R.id.chooseWhatToDo))
                .perform(click());

        Espresso.onData(allOf(is(instanceOf(String.class)), is("Count Characters"))).perform(click());

        //check whether correct option was chosen
        Espresso.onView(withId(R.id.chooseWhatToDo))
                .check(matches(withSpinnerText("Count Characters")));

        Espresso.onView(withId(R.id.countWordsButton))
                .perform(click());

        //check if the result is displayed with the correct count
        Espresso.onView(withId(R.id.result))
                .check(matches(isDisplayed()))
                .check(matches(withText("You have 17 characters")));
    }
}
