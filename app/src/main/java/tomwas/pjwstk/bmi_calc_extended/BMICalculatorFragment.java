package tomwas.pjwstk.bmi_calc_extended;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BMICalculatorFragment extends Fragment {

    private EditText weightInput, heightInput;
    private TextView resultTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        weightInput = view.findViewById(R.id.weightInput);
        heightInput = view.findViewById(R.id.heightInput);
        resultTextView = view.findViewById(R.id.resultTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateBMI());

        return view;
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString()) / 100; // Convert cm to meters
            double bmi = weight / (height * height);

            String status;
            String riskDetails;

            if (bmi < 18.5) {
                status = "Niedowaga";
                riskDetails = "Ryzyko niedożywienia, osłabienia odporności i osteoporozy.";
            } else if (bmi < 24.9) {
                status = "Optimum";
                riskDetails = "Prawidłowa masa ciała – niskie ryzyko problemów zdrowotnych.";
            } else if (bmi < 29.9) {
                status = "Nadwaga";
                riskDetails = "Zwiększone ryzyko chorób serca, cukrzycy typu 2 i nadciśnienia.";
            } else {
                status = "Otyłość";
                riskDetails = "Wysokie ryzyko chorób sercowo-naczyniowych, cukrzycy, problemów ze stawami.";
            }

            resultTextView.setText(String.format("BMI: %.2f\nStatus: %s\n%s", bmi, status, riskDetails));
        } catch (NumberFormatException e) {
            resultTextView.setText("Wprowadź poprawne dane.");
        }
    }
}