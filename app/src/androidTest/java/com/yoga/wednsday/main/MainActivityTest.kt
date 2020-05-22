package com.yoga.wednsday.main

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoga.wednsday.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.logging.Handler
import java.util.regex.Matcher

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)
    lateinit var viewModel: MainViewModel
    @Before
    fun setUp() {
        viewModel = MainViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun `no_data_view_is_hidden_when_there_is_data_exists`() {
        val textToType = "Latest"
        onView(withId(R.id.editText_search)).perform(typeText(textToType))
        onView(withId(R.id.editText_search)).perform(pressImeActionButton())
        Thread.sleep(3000)
        if (viewModel.getSongsListLiveData().value == null) {
            onView(withId(R.id.linearLayout_no_data_found)).check(
                matches(
                    withEffectiveVisibility(
                        Visibility.GONE
                    )
                )
            )
        }
    }

    @Test
    fun `no_data_view_is_visible_when_there_is_no_data_exists`() {
        val textToType = "Searching for no data"
        onView(withId(R.id.editText_search)).perform(typeText(textToType))
        onView(withId(R.id.editText_search)).perform(pressImeActionButton())
        Thread.sleep(3000)
        if (viewModel.getSongsListLiveData().value == null) {
            onView(withId(R.id.linearLayout_no_data_found)).check(
                matches(
                    withEffectiveVisibility(
                        Visibility.VISIBLE
                    )
                )
            )
        }
    }

}