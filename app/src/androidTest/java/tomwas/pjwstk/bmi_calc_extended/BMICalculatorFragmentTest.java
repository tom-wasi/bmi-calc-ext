package tomwas.pjwstk.bmi_calc_extended;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BMICalculatorFragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBMICalculation() {
        onView(withId(R.id.weightInput)).perform(typeText("70"), closeSoftKeyboard());
        onView(withId(R.id.heightInput)).perform(typeText("175"), closeSoftKeyboard());
        onView(withId(R.id.calculateButton)).perform(click());
        onView(withId(R.id.resultTextView))
                .check(matches(withText(org.hamcrest.Matchers.containsString("BMI:"))));
    }
}