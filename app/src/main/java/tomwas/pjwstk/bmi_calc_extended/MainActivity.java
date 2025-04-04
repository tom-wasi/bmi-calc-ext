package tomwas.pjwstk.bmi_calc_extended;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        CalculatorPagerAdapter adapter = new CalculatorPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("BMI");
                    tab.setIcon(R.drawable.ic_bmi);
                    break;
                case 1:
                    tab.setText("WHR");
                    tab.setIcon(R.drawable.ic_whr);
                    break;
                case 2:
                    tab.setText("Kalorie");
                    tab.setIcon(R.drawable.ic_calorie);
                    break;
                case 3:
                    tab.setText("Przepisy");
                    tab.setIcon(R.drawable.ic_recipe);
                    break;
            }
        }).attach();
    }
}