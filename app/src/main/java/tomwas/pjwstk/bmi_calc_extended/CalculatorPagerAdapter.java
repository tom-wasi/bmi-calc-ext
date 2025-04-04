package tomwas.pjwstk.bmi_calc_extended;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CalculatorPagerAdapter extends FragmentStateAdapter {
    public CalculatorPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new WHRCalculatorFragment();
            case 2:
                return new CalorieCalculatorFragment();
            case 3:
                return new RecipeRecommendationFragment();
            default:
                return new BMICalculatorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}