package uy.edu.ude

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculadoraRobolectricTest {

    @get:Rule
    val rule = ActivityTestRule(CalculadoraActivity::class.java)

    @Test
    fun givenTwoNumbers_whenSum_thenGetResult() {
        val n1 = "5"
        val n2 = "6"
        val resultadoExpected = "11"
        onView(withId(R.id.edNumero1)).perform(typeText(n1))
        onView(withId(R.id.edNumero2)).perform(typeText(n2))

        onView(withId(R.id.btnSuma)).perform(click())

        onView(withId(R.id.tvResultado)).check(matches(withText(resultadoExpected)))
    }
}