package com.wearable.whatsfordinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NutritionGoalScreen extends AppCompatActivity {
    EditText caloriesID;
    EditText carbohydrateID;
    EditText mineralsID;
    EditText vitaminsID;
    EditText sugarID;

    Button calculationButton;
    EditText totalGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_goal_screen);

        caloriesID = (EditText) findViewById(R.id.calories);
        carbohydrateID = (EditText) findViewById(R.id.carbohydrates);
        mineralsID = (EditText) findViewById(R.id.minerals);
        vitaminsID = (EditText) findViewById(R.id.vitamins);
        sugarID = (EditText) findViewById(R.id.sugar);

        //****** Set Calculation Button listener *********
        totalGoal = (EditText) findViewById(R.id.totalGoalCal);
        calculationButton = (Button) findViewById(R.id.calculation);
        calculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int get_calo = Integer.parseInt(caloriesID.getText().toString());
                int get_carbon = Integer.parseInt(carbohydrateID.getText().toString());
                int get_mineral = Integer.parseInt(mineralsID.getText().toString());
                int get_vitamin = Integer.parseInt(vitaminsID.getText().toString());
                int get_sugar = Integer.parseInt(sugarID.getText().toString());

                int sum = get_calo + get_carbon + get_mineral + get_vitamin + get_sugar;
                totalGoal.setText(Integer.toString(sum));
            }
        });
    }
}
