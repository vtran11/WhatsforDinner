package com.wearable.whatsfordinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompatSideChannelService;
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

    EditText caloPlan;
    EditText carbonPlan;
    EditText mineralPlan;
    EditText vitaminPlan;
    EditText sugarPlan;

    Button caloButton;
    Button carbonButton;
    Button mineralButton;
    Button vitaminButton;
    Button sugarButton;


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
        caloButton = (Button) findViewById(R.id.caloCal);
        carbonButton = (Button) findViewById(R.id.carbonCal);
        mineralButton = (Button) findViewById(R.id.mineralCal);
        vitaminButton = (Button) findViewById(R.id.vitaminCal);
        sugarButton = (Button) findViewById(R.id.sugarCal);

        caloPlan = (EditText) findViewById(R.id.caloplan);
        carbonPlan = (EditText) findViewById(R.id.carbonplan);
        mineralPlan = (EditText) findViewById(R.id.mineralplan);
        vitaminPlan = (EditText) findViewById(R.id.vitaminplan);
        sugarPlan = (EditText) findViewById(R.id.sugarplan);


        //Planned Weekly Calories - Calculation
        caloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(0));
                }

                caloPlan.setText(Integer.toString(sum));

                int get_calo = Integer.parseInt(caloriesID.getText().toString());
                if (get_calo <= sum)
                    Toast.makeText(getBaseContext(), "YOUR NUTRITION GOAL FOR CALORIES IS REACHED!!!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "YOUR CALORIES GOAL IS NOT REACHED!!!", Toast.LENGTH_LONG).show();
            }
        });


        //Planned Weekly Carbons - Calculation
        carbonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(1));
                }

                carbonPlan.setText(Integer.toString(sum));

                int get_carbon = Integer.parseInt(carbohydrateID.getText().toString());
                if (get_carbon <= sum)
                    Toast.makeText(getBaseContext(), "YOUR NUTRITION GOAL FOR CARBOHYDRATED IS REACHED!!!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "YOUR CARBOHYDRATED GOAL IS NOT REACHED!!!", Toast.LENGTH_LONG).show();
            }
        });


        //Planned Weekly Minerals - Calculation
        mineralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(2));
                }

                mineralPlan.setText(Integer.toString(sum));

                int get_mineral = Integer.parseInt(mineralsID.getText().toString());
                if (get_mineral <= sum)
                    Toast.makeText(getBaseContext(), "YOUR NUTRITION GOAL FOR MINERALS IS REACHED!!!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "YOUR MINERALS GOAL IS NOT REACHED!!!", Toast.LENGTH_LONG).show();
            }
        });


        //Planned Weekly Vitamins - Calculation
        vitaminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(3));
                }

                vitaminPlan.setText(Integer.toString(sum));

                int get_vitamin = Integer.parseInt(vitaminsID.getText().toString());
                if (get_vitamin <= sum)
                    Toast.makeText(getBaseContext(), "YOUR NUTRITION GOAL FOR VITAMINS IS REACHED!!!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "YOUR VITAMINS GOAL IS NOT REACHED!!!", Toast.LENGTH_LONG).show();
            }
        });


        //Planned Weekly Sugar - Calculation
        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(4));
                }

                sugarPlan.setText(Integer.toString(sum));

                int get_sugar = Integer.parseInt(sugarID.getText().toString());
                if (get_sugar <= sum)
                    Toast.makeText(getBaseContext(), "YOUR NUTRITION GOAL FOR SUGAR IS REACHED!!!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "YOUR SUGAR GOAL IS NOT REACHED!!!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
