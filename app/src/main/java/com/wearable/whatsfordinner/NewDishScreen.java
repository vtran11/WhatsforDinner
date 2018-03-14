package com.wearable.whatsfordinner;

import android.content.Intent;
import android.media.JetPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.net.Uri;
import android.content.Context;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class NewDishScreen extends AppCompatActivity {


    Uri imgURI = Uri.parse("android.resource://com.wearable.whatsfordinner/drawable/burger");

    AutoCompleteTextView ingredient1;
    AutoCompleteTextView ingredient2;
    AutoCompleteTextView ingredient3;
    AutoCompleteTextView ingredient4;
    AutoCompleteTextView ingredient5;
    AutoCompleteTextView ingredient6;
    AutoCompleteTextView ingredient7;
    AutoCompleteTextView ingredient8;
    AutoCompleteTextView ingredient9;
    AutoCompleteTextView ingredient10;

    EditText recipename;
    ImageView defaultPic;
    ImageButton newpicButton;
    EditText recipe_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

        final ArrayList<String> ingredient_list = new ArrayList<>();

        //find the views that were identified by these IDs
        recipename = (EditText) findViewById(R.id.recipe_name);
        defaultPic = (ImageView) findViewById(R.id.burger);
        recipe_detail = (EditText) findViewById(R.id.recipe_detail);

        //checking all saving ingredients in recipes to add new ingredients without duplicated
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet())
        {
            for (String i : entry.getValue().ingeredients_list)
            {
                if (!ingredient_list.contains(i)) {
                    ingredient_list.add(i);}
            }
        }

        //set adapter for ingredients pull-down menu so users can choose easily
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ingredient_list);
        ingredient1 = (AutoCompleteTextView) findViewById(R.id.ingredient1);
        ingredient2 = (AutoCompleteTextView) findViewById(R.id.ingredient2);
        ingredient3 = (AutoCompleteTextView) findViewById(R.id.ingredient3);
        ingredient4 = (AutoCompleteTextView) findViewById(R.id.ingredient4);
        ingredient5 = (AutoCompleteTextView) findViewById(R.id.ingredient5);
        ingredient6 = (AutoCompleteTextView) findViewById(R.id.ingredient6);
        ingredient7 = (AutoCompleteTextView) findViewById(R.id.ingredient7);
        ingredient8 = (AutoCompleteTextView) findViewById(R.id.ingredient8);
        ingredient9 = (AutoCompleteTextView) findViewById(R.id.ingredient9);
        ingredient10 = (AutoCompleteTextView) findViewById(R.id.ingredient10);
        ingredient1.setAdapter(adapter);
        ingredient2.setAdapter(adapter);
        ingredient3.setAdapter(adapter);
        ingredient4.setAdapter(adapter);
        ingredient5.setAdapter(adapter);
        ingredient6.setAdapter(adapter);
        ingredient7.setAdapter(adapter);
        ingredient8.setAdapter(adapter);
        ingredient9.setAdapter(adapter);
        ingredient10.setAdapter(adapter);
        ingredient1.setThreshold(1);
        ingredient2.setThreshold(1);
        ingredient3.setThreshold(1);
        ingredient4.setThreshold(1);
        ingredient5.setThreshold(1);
        ingredient6.setThreshold(1);
        ingredient7.setThreshold(1);
        ingredient8.setThreshold(1);
        ingredient9.setThreshold(1);
        ingredient10.setThreshold(1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //set onclick listener for new dish pic button
        newpicButton = (ImageButton) findViewById(R.id.add_newdish_pic);

        //set click listener for save recipe button
        Button save_button = (Button) findViewById(R.id.save_dish_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String recipeUpperKey = recipename.getText().toString().toUpperCase();

                //Display Alert msg if Recipe name is not entered
                if (recipeUpperKey.isEmpty()) {
                    Toast.makeText(getBaseContext(), "You must add a Recipe Name!", Toast.LENGTH_LONG).show();
                }

                //Display Alert msg if Recipe name already exists
                else if (Recipes.allRecipes.containsKey(recipeUpperKey)) {
                    Toast.makeText(getBaseContext(), "Recipe exists already. Please enter another Recipe!", Toast.LENGTH_LONG).show();
                }

                else {
                    ingredient_list.add(ingredient1.getText().toString());
                    ingredient_list.add(ingredient2.getText().toString());
                    ingredient_list.add(ingredient3.getText().toString());
                    ingredient_list.add(ingredient4.getText().toString());
                    ingredient_list.add(ingredient5.getText().toString());
                    ingredient_list.add(ingredient6.getText().toString());
                    ingredient_list.add(ingredient7.getText().toString());
                    ingredient_list.add(ingredient8.getText().toString());
                    ingredient_list.add(ingredient9.getText().toString());
                    ingredient_list.add(ingredient10.getText().toString());

                    String recipeDirection = recipe_detail.getText().toString();

                    //Limit the length of cooking direction to 250 characters
                    if (recipeDirection.length() <= 250) {
                        //add recipe name, image, ingredients and direction to a completed recipe
                        CompletedRecipe recipe = new CompletedRecipe(recipeUpperKey, imgURI, ingredient_list, recipeDirection);
                        Recipes.allRecipes.put(recipeUpperKey, recipe);

                        Toast.makeText(getBaseContext(), "Recipe successfully saved!!!", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getBaseContext(), "You must limit cooking direction's length to 250 characters!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
