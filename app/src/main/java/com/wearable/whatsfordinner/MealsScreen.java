package com.wearable.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class MealsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_screen);

        // **********  Set spinner for recipe names   ************
        Spinner spinnerB1 = (Spinner) findViewById(R.id.breakfast1Spinner);
        Spinner spinnerL1 = (Spinner) findViewById(R.id.lunch1Spinner);
        Spinner spinnerD1 = (Spinner) findViewById(R.id.dinner1Spinner);

        Spinner spinnerB2 = (Spinner) findViewById(R.id.breakfast2Spinner);
        Spinner spinnerL2 = (Spinner) findViewById(R.id.lunch2Spinner);
        Spinner spinnerD2 = (Spinner) findViewById(R.id.dinner2Spinner);

        Spinner spinnerB3 = (Spinner) findViewById(R.id.breakfast3Spinner);
        Spinner spinnerL3 = (Spinner) findViewById(R.id.lunch3Spinner);
        Spinner spinnerD3 = (Spinner) findViewById(R.id.dinner3Spinner);

        Spinner spinnerB4 = (Spinner) findViewById(R.id.breakfast4Spinner);
        Spinner spinnerL4 = (Spinner) findViewById(R.id.lunch4Spinner);
        Spinner spinnerD4 = (Spinner) findViewById(R.id.dinner4Spinner);

        Spinner spinnerB5 = (Spinner) findViewById(R.id.breakfast5Spinner);
        Spinner spinnerL5 = (Spinner) findViewById(R.id.lunch5Spinner);
        Spinner spinnerD5 = (Spinner) findViewById(R.id.dinner5Spinner);

        Spinner spinnerB6 = (Spinner) findViewById(R.id.breakfast6Spinner);
        Spinner spinnerL6 = (Spinner) findViewById(R.id.lunch6Spinner);
        Spinner spinnerD6 = (Spinner) findViewById(R.id.dinner6Spinner);

        Spinner spinnerB7 = (Spinner) findViewById(R.id.breakfast7Spinner);
        Spinner spinnerL7 = (Spinner) findViewById(R.id.lunch7Spinner);
        Spinner spinnerD7 = (Spinner) findViewById(R.id.dinner7Spinner);


        //**********************  Set Spinners for Monday  **************************
        final ArrayList<String> recipes1 = new ArrayList<>();
        recipes1.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes1.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterMonday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes1);
        adapterMonday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB1.setAdapter(adapterMonday);
        String monB = spinnerB1.getSelectedItem().toString();
        if(monB != "Eating Out")
        {
            adapterMonday.remove((String) spinnerB1.getSelectedItem());
            adapterMonday.notifyDataSetChanged();
        }

        spinnerL1.setAdapter(adapterMonday);
        String monL = spinnerL1.getSelectedItem().toString();
        if(monL != "Eating Out")
        {
            adapterMonday.remove((String) spinnerL1.getSelectedItem());
            adapterMonday.notifyDataSetChanged();
        }

        spinnerD1.setAdapter(adapterMonday);
        String monD = spinnerD1.getSelectedItem().toString();
        if(monD != "Eating Out")
        {
            adapterMonday.remove((String) spinnerD1.getSelectedItem());
            adapterMonday.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Tuesday  **************************
        final ArrayList<String> recipes2 = new ArrayList<>();
        recipes2.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes2.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterTuesday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes2);
        adapterTuesday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB2.setAdapter(adapterTuesday);
        String tuesB = spinnerB2.getSelectedItem().toString();
        if(tuesB != "Eating Out")
        {
            adapterTuesday.remove((String) spinnerB2.getSelectedItem());
            adapterTuesday.notifyDataSetChanged();
        }

        spinnerL2.setAdapter(adapterTuesday);
        String tuesL = spinnerL2.getSelectedItem().toString();
        if(tuesL != "Eating Out")
        {
            adapterTuesday.remove((String) spinnerL2.getSelectedItem());
            adapterTuesday.notifyDataSetChanged();
        }

        spinnerD2.setAdapter(adapterTuesday);
        String tuesD = spinnerD2.getSelectedItem().toString();
        if(tuesD != "Eating Out")
        {
            adapterTuesday.remove((String) spinnerD2.getSelectedItem());
            adapterTuesday.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Wednesday  **************************
        final ArrayList<String> recipes3 = new ArrayList<>();
        recipes3.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes3.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterWed = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes3);
        adapterWed.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB3.setAdapter(adapterWed);
        String wedB = spinnerB3.getSelectedItem().toString();
        if(wedB != "Eating Out")
        {
            adapterWed.remove((String) spinnerB3.getSelectedItem());
            adapterWed.notifyDataSetChanged();
        }

        spinnerL3.setAdapter(adapterWed);
        String wedL = spinnerL3.getSelectedItem().toString();
        if(wedL != "Eating Out")
        {
            adapterWed.remove((String) spinnerL3.getSelectedItem());
            adapterWed.notifyDataSetChanged();
        }

        spinnerD3.setAdapter(adapterWed);
        String wedD = spinnerD3.getSelectedItem().toString();
        if(wedD != "Eating Out")
        {
            adapterWed.remove((String) spinnerD3.getSelectedItem());
            adapterWed.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Thursday  **************************
        final ArrayList<String> recipes4 = new ArrayList<>();
        recipes4.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes4.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterThurs = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes4);
        adapterThurs.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB4.setAdapter(adapterThurs);
        String thursB = spinnerB4.getSelectedItem().toString();
        if(thursB != "Eating Out")
        {
            adapterThurs.remove((String) spinnerB4.getSelectedItem());
            adapterThurs.notifyDataSetChanged();
        }

        spinnerL4.setAdapter(adapterThurs);
        String thursL = spinnerL4.getSelectedItem().toString();
        if(thursL != "Eating Out")
        {
            adapterThurs.remove((String) spinnerL4.getSelectedItem());
            adapterThurs.notifyDataSetChanged();
        }

        spinnerD4.setAdapter(adapterThurs);
        String thursD = spinnerD4.getSelectedItem().toString();
        if(thursD != "Eating Out")
        {
            adapterThurs.remove((String) spinnerD4.getSelectedItem());
            adapterThurs.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Friday  **************************
        final ArrayList<String> recipes5 = new ArrayList<>();
        recipes5.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes5.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterFriday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes5);
        adapterFriday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB5.setAdapter(adapterFriday);
        String fridayB = spinnerB5.getSelectedItem().toString();
        if(fridayB != "Eating Out")
        {
            adapterFriday.remove((String) spinnerB5.getSelectedItem());
            adapterFriday.notifyDataSetChanged();
        }

        spinnerL5.setAdapter(adapterFriday);
        String fridayL = spinnerL5.getSelectedItem().toString();
        if(fridayL != "Eating Out")
        {
            adapterFriday.remove((String) spinnerL5.getSelectedItem());
            adapterFriday.notifyDataSetChanged();
        }

        spinnerD5.setAdapter(adapterFriday);
        String fridayD = spinnerD5.getSelectedItem().toString();
        if(fridayD != "Eating Out")
        {
            adapterFriday.remove((String) spinnerD5.getSelectedItem());
            adapterFriday.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Saturday  **************************
        final ArrayList<String> recipes6 = new ArrayList<>();
        recipes6.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes6.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterSaturday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes6);
        adapterSaturday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB6.setAdapter(adapterSaturday);
        String saturB = spinnerB6.getSelectedItem().toString();
        if(saturB != "Eating Out")
        {
            adapterSaturday.remove((String) spinnerB6.getSelectedItem());
            adapterSaturday.notifyDataSetChanged();
        }

        spinnerL6.setAdapter(adapterSaturday);
        String saturL = spinnerL6.getSelectedItem().toString();
        if(saturL != "Eating Out")
        {
            adapterSaturday.remove((String) spinnerL6.getSelectedItem());
            adapterSaturday.notifyDataSetChanged();
        }

        spinnerD6.setAdapter(adapterSaturday);
        String saturD = spinnerD6.getSelectedItem().toString();
        if(saturD != "Eating Out")
        {
            adapterSaturday.remove((String) spinnerD6.getSelectedItem());
            adapterSaturday.notifyDataSetChanged();
        }



        //**********************  Set Spinners for Sunday  **************************
        final ArrayList<String> recipes7 = new ArrayList<>();
        recipes7.add("Eating Out");
        for(int i =0; i <Recipes.allSelectedRecipes.size(); i++) {
            recipes7.add(Recipes.allSelectedRecipes.get(i));
        }

        final ArrayAdapter<String> adapterSunday = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                recipes7);
        adapterSunday.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerB7.setAdapter(adapterSunday);
        String sunB = spinnerB7.getSelectedItem().toString();
        if(sunB != "Eating Out")
        {
            adapterSunday.remove((String) spinnerB7.getSelectedItem());
            adapterSunday.notifyDataSetChanged();
        }

        spinnerL7.setAdapter(adapterSunday);
        String sunL = spinnerL7.getSelectedItem().toString();
        if(sunL != "Eating Out")
        {
            adapterSunday.remove((String) spinnerL7.getSelectedItem());
            adapterSunday.notifyDataSetChanged();
        }

        spinnerD7.setAdapter(adapterSunday);
        String sunD = spinnerD7.getSelectedItem().toString();
        if(sunD != "Eating Out")
        {
            adapterSunday.remove((String) spinnerD7.getSelectedItem());
            adapterSunday.notifyDataSetChanged();
        }




/*
        ArrayList<Spinner> mealsOption = new ArrayList<Spinner>();
        mealsOption.add(spinnerB1);
        mealsOption.add(spinnerL1);
        mealsOption.add(spinnerD1);*/




/*
        spinnerL1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String choose = spinnerB1.getSelectedItem().toString();
                if(choose != "Eating Out")
                {
                    recipes.remove(choose);
                }
            }
        });


        spinnerD1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String choose = spinnerB1.getSelectedItem().toString();
                if(choose != "Eating Out")
                {
                    recipes.remove(choose);
                }
            }
        });

*/
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

}
