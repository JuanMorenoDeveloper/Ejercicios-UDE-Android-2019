package uy.edu.ude

import android.os.Build
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class LoginRobolectricTest {

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun givenValidUser_whenDoLogin_thenGetOk() {
        onView(withId(R.id.edUsuario)).perform(typeText("user"))
        onView(withId(R.id.edPassword)).perform(typeText("secret"))

        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.tvResultado)).check(matches(withText("OK")))
    }
}