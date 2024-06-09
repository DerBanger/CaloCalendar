package de.sep.calocalendar.calorieCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.sep.calocalendar.CalorieCalculator;
import org.junit.jupiter.api.Test;

public class CalorieCalculatorTest {

    @Test
    public void testCalculateCalorieNeeds_Male_HighActivity_GainWeight() {
        CalorieCalculator calculator = new CalorieCalculator();
        int gender = 0;
        double bodyweight = 80.0;
        double height = 192.0;
        double age = 23.0;
        int physicalActivity = 2; // High activity
        int selectedGoal = 2; // Gain weight

        int expectedCalories = 3430;
        int actualCalories = calculator.calculateCalorieNeeds(gender, bodyweight, height, age, physicalActivity, selectedGoal);

        assertEquals(expectedCalories, actualCalories, "Calories calculation for male, high activity, gain weight failed");
    }

    @Test
    public void testCalculateCalorieNeeds_Female_LowActivity_LoseWeight() {
        CalorieCalculator calculator = new CalorieCalculator();
        int gender = 1;
        double bodyweight = 60.0;
        double height = 165.0;
        double age = 30.0;
        int physicalActivity = 0; // Low activity
        int selectedGoal = 0; // Lose weight

        int expectedCalories = 1150;
        int actualCalories = calculator.calculateCalorieNeeds(gender, bodyweight, height, age, physicalActivity, selectedGoal);

        assertEquals(expectedCalories, actualCalories, "Calories calculation for female, low activity, lose weight failed");
    }

    @Test
    public void testCalculateCalorieNeeds_Male_MediumActivity_HoldWeight() {
        CalorieCalculator calculator = new CalorieCalculator();
        int gender = 0;
        double bodyweight = 75.0;
        double height = 180.0;
        double age = 40.0;
        int physicalActivity = 1; // Medium activity
        int selectedGoal = 1; // Hold weight

        int expectedCalories = 2352;
        int actualCalories = calculator.calculateCalorieNeeds(gender, bodyweight, height, age, physicalActivity, selectedGoal);

        assertEquals(expectedCalories, actualCalories, "Calories calculation for male, medium activity, hold weight failed");
    }

    @Test
    public void testCalculateCalorieNeeds_Female_HighActivity_LoseWeight() {
        CalorieCalculator calculator = new CalorieCalculator();
        int gender = 1;
        double bodyweight = 65.0;
        double height = 170.0;
        double age = 25.0;
        int physicalActivity = 2; // High activity
        int selectedGoal = 0; // Lose weight

        int expectedCalories = 1711;
        int actualCalories = calculator.calculateCalorieNeeds(gender, bodyweight, height, age, physicalActivity, selectedGoal);

        assertEquals(expectedCalories, actualCalories, "Calories calculation for female, high activity, lose weight failed");
    }
}