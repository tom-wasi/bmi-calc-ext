package tomwas.pjwstk.bmi_calc_extended;

import static java.lang.String.format;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CalorieCalculatorFragment extends Fragment {
    private EditText weightInput, heightInput, ageInput;
    private Spinner activitySpinner;
    private TextView resultTextView;
    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calorie_calculator, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        weightInput = view.findViewById(R.id.weightInput);
        heightInput = view.findViewById(R.id.heightInput);
        ageInput = view.findViewById(R.id.ageInput);
        activitySpinner = view.findViewById(R.id.activitySpinner);
        resultTextView = view.findViewById(R.id.resultTextView);

        Button calculateButton = view.findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculateCalories());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);

        return view;
    }

    private void calculateCalories() {
        try {
            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString());
            int age = Integer.parseInt(ageInput.getText().toString());
            String activityLevel = activitySpinner.getSelectedItem().toString();

            double bmr = 10 * weight + 6.25 * height - 5 * age + 5;
            double multiplier = getActivityMultiplier(activityLevel);
            double calories = bmr * multiplier;

            resultTextView.setText(format("Zapotrzebowanie: %.0f kcal", calories));
            viewModel.setCalories(calories);
        } catch (Exception e) {
            resultTextView.setText("Błąd danych.");
        }
    }

    private double getActivityMultiplier(String level) {
        switch (level) {
            case "Brak aktywności": return 1.2;
            case "Lekka aktywność": return 1.375;
            case "Średnia aktywność": return 1.55;
            case "Duża aktywność": return 1.725;
            case "Bardzo duża aktywność": return 1.9;
            default: return 1.2;
        }
    }
}
