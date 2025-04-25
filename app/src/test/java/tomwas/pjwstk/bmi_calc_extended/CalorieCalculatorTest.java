package tomwas.pjwstk.bmi_calc_extended;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalorieCalculatorTest {

    @Test
    public void testCalculateCalories_AverageActivity() {
        double weight = 70;
        double height = 175;
        int age = 25;
        String activityLevel = "Średnia aktywność";

        double result = CalorieCalculator.calculateCalories(weight, height, age, activityLevel);

        double expectedBMR = 10 * 70 + 6.25 * 175 - 5 * 25 + 5;
        double expected = expectedBMR * 1.55;

        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testActivityMultiplier_DefaultCase() {
        double multiplier = CalorieCalculator.getActivityMultiplier("Default");
        assertEquals(1.2, multiplier, 0.0);
    }
}