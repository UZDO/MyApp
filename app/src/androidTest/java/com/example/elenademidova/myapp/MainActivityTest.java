package com.example.elenademidova.myapp;

import android.app.LauncherActivity;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.WindowManager;


public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    public ActivityTestRule<ListActivity> mListActivityRule = new ActivityTestRule<>(
            ListActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test

    public void myappTest() {
        onView(withId(R.id.buttonOK)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonOK)).check(matches(withText("ОК")));
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Введите текст в поле:")));

        onView(withId(R.id.editText)).perform(click());
        onView(withId(R.id.textView)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));

        onView(withId(R.id.editText)).perform(typeText("NotKey"));
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.buttonOK)).perform(click());
        onView(withText("Введён неверный ключ")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
        onView(withId(R.id.editText)).perform(clearText());

        onView(withId(R.id.editText)).perform(typeText("key"));
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.buttonOK)).perform(click());

        onView(withId(R.id.listview)).check(matches(isDisplayed()));
        onData(instanceOf(Person.class))
                .inAdapterView(allOf(withId(R.id.listview), isDisplayed()))
                .atPosition(2)
                .check(matches(hasDescendant(allOf(withId(R.id.textviewName), withText("Мария")))))
                .check(matches(hasDescendant(allOf(withId(R.id.textviewOld), withText("30 лет")))));
    }
}