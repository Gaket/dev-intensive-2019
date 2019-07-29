package ru.skillbranch.devintensive;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Artur (gaket) on 2019-07-25.
 */
@RunWith(AndroidJUnit4.class)
public class MainFlowTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onAppStart_nameQuestionIsDisplayed() {

        // Find view                Arrange
        // Perform an action        Act
        // Assert correctness       Assert

        Espresso.onView(ViewMatchers.withText("Как меня зовут?"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void onAppStart_benderIsDisplayed() {

        // Find view                Arrange
        // Perform an action        Act
        // Assert correctness       Assert

        Espresso.onView(ViewMatchers.withId(R.id.iv_bender))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void afterCorrectAnswer_professionQuestionIsAsked() {

        Espresso.onView(ViewMatchers.withId(R.id.et_message))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.et_message))
                .perform(ViewActions.typeText("Bender"));

        Espresso.onView(ViewMatchers.withId(R.id.iv_send))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.iv_send))
                .perform(ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.tv_text))
                .check(ViewAssertions.matches(ViewMatchers.withText("Отлично - ты справился\nНазови мою профессию?")));
    }
}
