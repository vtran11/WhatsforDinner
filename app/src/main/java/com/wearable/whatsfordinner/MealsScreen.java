package com.wearable.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MealsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_screen);

        // **********  Set spinner for recipe names   ************
        final Spinner spinnerB1 = (Spinner) findViewById(R.id.breakfast1Spinner);
        final Spinner spinnerL1 = (Spinner) findViewById(R.id.lunch1Spinner);
        final Spinner spinnerD1 = (Spinner) findViewById(R.id.dinner1Spinner);

        final Spinner spinnerB2 = (Spinner) findViewById(R.id.breakfast2Spinner);
        final Spinner spinnerL2 = (Spinner) findViewById(R.id.lunch2Spinner);
        final Spinner spinnerD2 = (Spinner) findViewById(R.id.dinner2Spinner);

        final Spinner spinnerB3 = (Spinner) findViewById(R.id.breakfast3Spinner);
        final Spinner spinnerL3 = (Spinner) findViewById(R.id.lunch3Spinner);
        final Spinner spinnerD3 = (Spinner) findViewById(R.id.dinner3Spinner);

        final Spinner spinnerB4 = (Spinner) findViewById(R.id.breakfast4Spinner);
        final Spinner spinnerL4 = (Spinner) findViewById(R.id.lunch4Spinner);
        final Spinner spinnerD4 = (Spinner) findViewById(R.id.dinner4Spinner);

        final Spinner spinnerB5 = (Spinner) findViewById(R.id.breakfast5Spinner);
        final Spinner spinnerL5 = (Spinner) findViewById(R.id.lunch5Spinner);
        final Spinner spinnerD5 = (Spinner) findViewById(R.id.dinner5Spinner);

        final Spinner spinnerB6 = (Spinner) findViewById(R.id.breakfast6Spinner);
        final Spinner spinnerL6 = (Spinner) findViewById(R.id.lunch6Spinner);
        final Spinner spinnerD6 = (Spinner) findViewById(R.id.dinner6Spinner);

        final Spinner spinnerB7 = (Spinner) findViewById(R.id.breakfast7Spinner);
        final Spinner spinnerL7 = (Spinner) findViewById(R.id.lunch7Spinner);
        final Spinner spinnerD7 = (Spinner) findViewById(R.id.dinner7Spinner);


        //**********************  Set Spinners for Monday  **************************
        final ArrayList<String> recipes1 = new ArrayList<>();
        recipes1.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes1.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterMonday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes1);
        adapterMonday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB1.setAdapter(adapterMonday);
        spinnerB1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String monB = spinnerB1.getSelectedItem().toString();
                if(monB != "Eating Out") {
                    recipes1.remove((String) spinnerB1.getSelectedItem());
                    Recipes.allPlanMeals.add(monB);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterMonday.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL1.setAdapter(adapterMonday);
        spinnerL1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String monL = spinnerL1.getSelectedItem().toString();
                if(monL != "Eating Out") {
                    recipes1.remove((String) spinnerL1.getSelectedItem());
                    Recipes.allPlanMeals.add(monL);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterMonday.notifyDataSetChanged();


        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD1.setAdapter(adapterMonday);
        spinnerD1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String monD = spinnerD1.getSelectedItem().toString();
                if(monD != "Eating Out") {
                    recipes1.remove((String) spinnerD1.getSelectedItem());
                    Recipes.allPlanMeals.add(monD);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterMonday.notifyDataSetChanged();



        //**********************  Set Spinners for Tuesday  **************************
        final ArrayList<String> recipes2 = new ArrayList<>();
        recipes2.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes2.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterTuesday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes2);
        adapterTuesday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB2.setAdapter(adapterTuesday);
        spinnerB2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tuesB = spinnerB2.getSelectedItem().toString();
                if(tuesB != "Eating Out") {
                    recipes2.remove((String) spinnerB2.getSelectedItem());
                    Recipes.allPlanMeals.add(tuesB);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterTuesday.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL2.setAdapter(adapterTuesday);
        spinnerL2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tuesL = spinnerL2.getSelectedItem().toString();
                if(tuesL != "Eating Out") {
                    recipes2.remove((String) spinnerL2.getSelectedItem());
                    Recipes.allPlanMeals.add(tuesL);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterTuesday.notifyDataSetChanged();



        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD2.setAdapter(adapterTuesday);
        spinnerD2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tuesD = spinnerD2.getSelectedItem().toString();
                if(tuesD != "Eating Out") {
                    recipes2.remove((String) spinnerD2.getSelectedItem());
                    Recipes.allPlanMeals.add(tuesD);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterTuesday.notifyDataSetChanged();




        //**********************  Set Spinners for Wednesday  **************************
        final ArrayList<String> recipes3 = new ArrayList<>();
        recipes3.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes3.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterWed = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes3);
        adapterWed.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB3.setAdapter(adapterWed);
        spinnerB3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String wedB = spinnerB3.getSelectedItem().toString();
                if(wedB != "Eating Out") {
                    recipes3.remove((String) spinnerB3.getSelectedItem());
                    Recipes.allPlanMeals.add(wedB);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterWed.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL3.setAdapter(adapterWed);
        spinnerL3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String wedL = spinnerL3.getSelectedItem().toString();
                if(wedL != "Eating Out") {
                    recipes3.remove((String) spinnerL3.getSelectedItem());
                    Recipes.allPlanMeals.add(wedL);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterWed.notifyDataSetChanged();



        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD3.setAdapter(adapterWed);
        spinnerD3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String wedD = spinnerD3.getSelectedItem().toString();
                if(wedD != "Eating Out") {
                    recipes3.remove((String) spinnerD3.getSelectedItem());
                    Recipes.allPlanMeals.add(wedD);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterWed.notifyDataSetChanged();



        //**********************  Set Spinners for Thursday  **************************
        final ArrayList<String> recipes4 = new ArrayList<>();
        recipes4.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes4.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterThurs = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes4);
        adapterThurs.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB4.setAdapter(adapterThurs);
        spinnerB4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String thursB = spinnerB4.getSelectedItem().toString();
                if(thursB != "Eating Out") {
                    recipes4.remove((String) spinnerB4.getSelectedItem());
                    Recipes.allPlanMeals.add(thursB);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterThurs.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL4.setAdapter(adapterThurs);
        spinnerL4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String thursL = spinnerL4.getSelectedItem().toString();
                if(thursL != "Eating Out") {
                    recipes4.remove((String) spinnerL4.getSelectedItem());
                    Recipes.allPlanMeals.add(thursL);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterThurs.notifyDataSetChanged();


        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD4.setAdapter(adapterThurs);
        spinnerD4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String thursD = spinnerD4.getSelectedItem().toString();
                if(thursD != "Eating Out") {
                    recipes4.remove((String) spinnerD4.getSelectedItem());
                    Recipes.allPlanMeals.add(thursD);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterThurs.notifyDataSetChanged();




        //**********************  Set Spinners for Friday  **************************
        final ArrayList<String> recipes5 = new ArrayList<>();
        recipes5.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes5.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterFriday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes5);
        adapterFriday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB5.setAdapter(adapterFriday);
        spinnerB5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String fridayB = spinnerB5.getSelectedItem().toString();
                if(fridayB != "Eating Out") {
                    recipes5.remove((String) spinnerB5.getSelectedItem());
                    Recipes.allPlanMeals.add(fridayB);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterFriday.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL5.setAdapter(adapterFriday);
        spinnerL5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String fridayL = spinnerL5.getSelectedItem().toString();
                if(fridayL != "Eating Out") {
                    recipes5.remove((String) spinnerL5.getSelectedItem());
                    Recipes.allPlanMeals.add(fridayL);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterFriday.notifyDataSetChanged();



        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD5.setAdapter(adapterFriday);
        spinnerD5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String fridayD = spinnerD5.getSelectedItem().toString();
                if(fridayD != "Eating Out") {
                    recipes5.remove((String) spinnerD5.getSelectedItem());
                    Recipes.allPlanMeals.add(fridayD);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterFriday.notifyDataSetChanged();




        //**********************  Set Spinners for Saturday  **************************
        final ArrayList<String> recipes6 = new ArrayList<>();
        recipes6.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes6.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterSaturday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes6);
        adapterSaturday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB6.setAdapter(adapterSaturday);
        spinnerB6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String saturB = spinnerB6.getSelectedItem().toString();
                if(saturB != "Eating Out") {
                    recipes6.remove((String) spinnerB6.getSelectedItem());
                    Recipes.allPlanMeals.add(saturB);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSaturday.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL6.setAdapter(adapterSaturday);
        spinnerL6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String saturL = spinnerL6.getSelectedItem().toString();
                if(saturL != "Eating Out") {
                    recipes6.remove((String) spinnerL6.getSelectedItem());
                    Recipes.allPlanMeals.add(saturL);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSaturday.notifyDataSetChanged();



        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD6.setAdapter(adapterSaturday);
        spinnerD6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String saturD = spinnerD6.getSelectedItem().toString();
                if(saturD != "Eating Out") {
                    recipes6.remove((String) spinnerD6.getSelectedItem());
                    Recipes.allPlanMeals.add(saturD);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSaturday.notifyDataSetChanged();




        //**********************  Set Spinners for Sunday  **************************
        final ArrayList<String> recipes7 = new ArrayList<>();
        recipes7.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes7.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterSunday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes7);
        adapterSunday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Check Breaskfast Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerB7.setAdapter(adapterSunday);
        spinnerB7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sunB = spinnerB7.getSelectedItem().toString();
                if(sunB != "Eating Out") {
                    recipes7.remove((String) spinnerB7.getSelectedItem());
                    Recipes.allPlanMeals.add(sunB);

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSunday.notifyDataSetChanged();


        //Check Lunch Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerL7.setAdapter(adapterSunday);
        spinnerL7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sunL = spinnerL7.getSelectedItem().toString();
                if(sunL != "Eating Out") {
                    recipes7.remove((String) spinnerL7.getSelectedItem());
                    Recipes.allPlanMeals.add(sunL);

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSunday.notifyDataSetChanged();



        //Check Dinner Spinner and remove selected recipe from spinner (except "Eating out")
        spinnerD7.setAdapter(adapterSunday);
        spinnerD7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sunD = spinnerD7.getSelectedItem().toString();
                if(sunD != "Eating Out") {
                    recipes7.remove((String) spinnerD7.getSelectedItem());
                    Recipes.allPlanMeals.add(sunD);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        adapterSunday.notifyDataSetChanged();



        //************************ Planned nutrition Calculation ****************************
        //****** Set Calculation Button listener *********
        Button caloButton = (Button) findViewById(R.id.caloCal);
        Button carbonButton = (Button) findViewById(R.id.carbonCal);
        Button mineralButton = (Button) findViewById(R.id.mineralCal);
        Button vitaminButton = (Button) findViewById(R.id.vitaminCal);
        Button sugarButton = (Button) findViewById(R.id.sugarCal);

        final EditText caloPlan = (EditText) findViewById(R.id.caloplan);
        final EditText carbonPlan = (EditText) findViewById(R.id.carbonplan);
        final EditText mineralPlan = (EditText) findViewById(R.id.mineralplan);
        final EditText vitaminPlan = (EditText) findViewById(R.id.vitaminplan);
        final EditText sugarPlan = (EditText) findViewById(R.id.sugarplan);

        //Planned Weekly Calories - Calculation
        caloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for(String recipe: Recipes.allPlanMeals) {
                    sum += Integer.parseInt(Recipes.allRecipes.get(recipe).getNutrition().get(0));
                }

                caloPlan.setText(Integer.toString(sum));
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
             }
        });


        //****************** Nutrition Goal Activity *************************
        //Set up click listener for new dish button
        Button nutritionGoal = (Button) findViewById(R.id.nutritionGoalButton);
        nutritionGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MealsScreen.this, NutritionGoalScreen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

}
