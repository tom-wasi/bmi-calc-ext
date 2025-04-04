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

public class WHRCalculatorFragment extends Fragment {

    private EditText waistInput, hipInput;
    private TextView resultTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whr_calculator, container, false);

        waistInput = view.findViewById(R.id.waistInput);
        hipInput = view.findViewById(R.id.hipInput);
        resultTextView = view.findViewById(R.id.resultTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculateWHR());

        return view;
    }

    private void calculateWHR() {
        try {
            double waist = Double.parseDouble(waistInput.getText().toString());
            double hip = Double.parseDouble(hipInput.getText().toString());
            double whr = waist / hip;

            String status;
            String riskDetails;

            if (whr < 0.9) {
                status = "Niskie ryzyko";
                riskDetails = "Niskie ryzyko chorób sercowo-naczyniowych i metabolicznych.";
            } else if (whr < 1.0) {
                status = "Średnie ryzyko";
                riskDetails = "Umiarkowane ryzyko chorób serca i cukrzycy typu 2.";
            } else {
                status = "Wysokie ryzyko";
                riskDetails = "Podwyższone ryzyko chorób sercowo-naczyniowych, cukrzycy i zespołu metabolicznego.";
            }

            resultTextView.setText(String.format("WHR: %.2f\nStatus: %s\n%s", whr, status, riskDetails));
        } catch (NumberFormatException e) {
            resultTextView.setText("Wprowadź poprawne dane.");
        }
    }
}