package com.wearable.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class MealsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_screen);

        // **********  Set spinner recipe names   ************
        Spinner spinner1 = (Spinner) findViewById(R.id.breakfast1Spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.lunch1Spinner);
        Spinner spinner3 = (Spinner) findViewById(R.id.dinner1Spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                Recipes.allSelectedRecipes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

    }
}
