package de.sep.calocalendar;

import javax.swing.*;

public class CalorieCalculator {

    private static final int MALE = 0;
    private static final int FEMALE = 1;

    private static final int LOW_ACTIVITY = 0;
    private static final int MEDIUM_ACTIVITY = 1;
    private static final int HIGH_ACTIVITY = 2;

    private static final int LOSE_WEIGHT = 0;
    private static final int HOLD_WEIGHT = 1;
    private static final int GAIN_WEIGHT = 2;

    /**
     * Calculate the daily calorie needs based on various factors.
     *
     * @param gender            Gender of the individual (0 = male, 1 = female).
     * @param bodyweight        Body weight in kilograms.
     * @param height            Height in centimeters.
     * @param age               Age in years.
     * @param physicalActivity  Level of physical activity (0 = low, 1 = medium, 2 = high).
     * @param selectedGoal      Goal (0 = lose weight, 1 = hold weight, 2 = gain weight).
     * @return                  The calculated daily calorie needs.
     */
    public int calculateCalorieNeeds(int gender, double bodyweight, double height, double age, int physicalActivity, int selectedGoal) {

        double neededCalories = calculateBasalMetabolicRate(gender, bodyweight, height, age);
        neededCalories = adjustForPhysicalActivity(neededCalories, physicalActivity);
        neededCalories = adjustForGoal(neededCalories, selectedGoal);

        return (int) Math.round(neededCalories);
    }

    private double calculateBasalMetabolicRate(int gender, double bodyweight, double height, double age) {
        switch (gender) {
            case MALE:
                return (10 * bodyweight) + (6.25 * height) - (5 * age) + 5;
            case FEMALE:
                return (10 * bodyweight) + (6.25 * height) - (5 * age) - 161;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    private double adjustForPhysicalActivity(double calories, int physicalActivity) {
        switch (physicalActivity) {
            case LOW_ACTIVITY:
                return calories * 1.25;
            case MEDIUM_ACTIVITY:
                return calories * 1.4;
            case HIGH_ACTIVITY:
                return calories * 1.55;
            default:
                throw new IllegalArgumentException("Invalid level of physical activity: " + physicalActivity);
        }
    }

    private double adjustForGoal(double calories, int selectedGoal) {
        switch (selectedGoal) {
            case LOSE_WEIGHT:
                return calories - 500;
            case HOLD_WEIGHT:
                return calories; // No change
            case GAIN_WEIGHT:
                return calories + 500;
            default:
                throw new IllegalArgumentException("Invalid goal: " + selectedGoal);
        }
    }
}
