package com.raywenderlich.markme.main.view.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.raywenderlich.markme.R
import com.raywenderlich.markme.di.applicationModule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest : KoinTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        StandAloneContext.loadKoinModules(listOf(applicationModule))
    }

    @After
    fun tearDown() {
    }

    @Test
    fun whenActivityStartsLoginIsDisplayed() {
        onView(withId(R.id.activity_main__cardview__attendance))
                .check(matches(isDisplayed()))
    }

}