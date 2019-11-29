package uy.edu.ude

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java)

    @Ignore("Espresso no encuentra campos de tipo password")
    @Test
    fun givenValidUser_whenDoLogin_thenGetOk() {
        onView(withId(R.id.edUsuario)).perform(typeText("user")).perform(closeSoftKeyboard())
        onView(withId(R.id.edPassword)).perform(typeText("secret")).perform(closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.tvResultado)).check(matches(withText("OK")))
    }
}