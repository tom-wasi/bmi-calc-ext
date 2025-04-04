package tomwas.pjwstk.bmi_calc_extended;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class RecipeRecommendationFragment extends Fragment {

    private TextView recipeTextView;
    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_recommendation, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        recipeTextView = view.findViewById(R.id.recipeTextView);

        viewModel.getCalories().observe(getViewLifecycleOwner(), this::displayRecipes);


        return view;
    }

    private void displayRecipes(Double userCalories) {
        String recipes;

        if (userCalories == null || userCalories < 0) {
            recipes = "Najpierw oblicz swoje dzienne zapotrzebowanie kaloryczne.";
        } else if (userCalories < 1800) {
            recipes = "Rekomendowane przepisy dla diety lekkiej:\n\n" +
                    "1. Sałatka z tuńczykiem – 350 kcal\nSkładniki: sałata, tuńczyk, kukurydza, oliwa.\n\n" +
                    "2. Zupa krem z brokułów – 400 kcal\nSkładniki: brokuły, ziemniaki, bulion warzywny.";
        } else if (userCalories <= 2500) {
            recipes = "Rekomendowane przepisy dla diety zbilansowanej:\n\n" +
                    "1. Kurczak z ryżem i warzywami – 600 kcal\nSkładniki: pierś z kurczaka, ryż, brokuły.\n\n" +
                    "2. Omlet z warzywami – 500 kcal\nSkładniki: jajka, papryka, cebula, ser.";
        } else {
            recipes = "Rekomendowane przepisy dla diety wysokokalorycznej:\n\n" +
                    "1. Makaron z mięsem mielonym – 850 kcal\nSkładniki: makaron, mięso mielone, sos pomidorowy.\n\n" +
                    "2. Gulasz wołowy z kaszą – 900 kcal\nSkładniki: wołowina, kasza gryczana, cebula, papryka.";
        }

        recipeTextView.setText(recipes);
    }
}
