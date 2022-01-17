package vanrrtech.app.kompasgithubapp

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import vanrrtech.app.kompasgithubapp.app.SearchFunction.View.MainActivity
import java.util.regex.Matcher


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityEspressoTest {
    val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        .putExtra("title", "Testing rules!")

    @Rule @JvmField
    val activityRule = ActivityScenarioRule<MainActivity>(intent)

    fun clickOnViewChild(viewId: Int) = object : ViewAction {
        override fun getConstraints() = null

        override fun getDescription() = "Click on a child view with specified id."

        override fun perform(uiController: UiController, view: View) = click().perform(uiController, view.findViewById<View>(viewId))
    }

    @Test
    fun activityStart_MainActivity_checkIfNeededDisplayShown() {
        onView(withId(R.id.search_field))
            .check(matches(isDisplayed()))

        onView(withId(R.id.user_rv))
            .check(matches(isDisplayed()))

        // Check that the text was changed.
    }

    @Test
    fun typeInEditText_MainActivity_checkIfNeededDisplayShownLand() {

        onView(withId(R.id.search_field))
            .check(matches(isDisplayed()))

        onView(withId(R.id.user_rv))
            .check(matches(isDisplayed()))

        // Check that the text was changed.
        onView(withId(R.id.search_field))
            .perform(typeText("wing"), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.search_field)).check(matches(withText("wing")));
    }

    @Test
    fun clickFirstItemonRV_MainActivity_checkIfNeededDisplayShownLand() {

        onView(withId(R.id.search_field))
            .check(matches(isDisplayed()))

        onView(withId(R.id.user_rv))
            .check(matches(isDisplayed()))

        Thread.sleep(2000)
        // click RV
        onView(withId(R.id.user_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, clickOnViewChild(R.id.root)))

        onView(withId(R.id.user_repo_rv)).check(matches(isDisplayed()));
        onView(withId(R.id.user_image)).check(matches(isDisplayed()));
        onView(withId(R.id.user_name)).check(matches(isDisplayed()));
    }

//    @Before
//    fun setUp() {
//    }
//
//    @Test
//    fun changeTest_newAct(){
//        onView(withId(R.id.inputField)).perform(typeText("NewText"),
//            closeSoftKeyboard());
//        onView(withId(R.id.switchActivity)).perform(click());
//
//        // This view is in a different Activity, no need to tell Espresso.
//        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
//    }
}