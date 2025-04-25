package tomwas.pjwstk.bmi_calc_extended;

public class CalorieCalculator {

    public static double calculateBMR(double weight, double height, int age) {
        return 10 * weight + 6.25 * height - 5 * age + 5;
    }

    public static double getActivityMultiplier(String level) {
        switch (level) {
            case "Lekka aktywność": return 1.375;
            case "Średnia aktywność": return 1.55;
            case "Duża aktywność": return 1.725;
            case "Bardzo duża aktywność": return 1.9;
            default: return 1.2;
        }
    }

    public static double calculateCalories(double weight, double height, int age, String activityLevel) {
        double bmr = calculateBMR(weight, height, age);
        double multiplier = getActivityMultiplier(activityLevel);
        return bmr * multiplier;
    }
}
