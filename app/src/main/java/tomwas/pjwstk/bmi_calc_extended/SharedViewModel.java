package tomwas.pjwstk.bmi_calc_extended;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Double> calories = new MutableLiveData<>();

    public void setCalories(double value) {
        calories.setValue(value);
    }
    public LiveData<Double> getCalories() {
        return calories;
    }
}