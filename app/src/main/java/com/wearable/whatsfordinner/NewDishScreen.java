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

    EditText calo;
    EditText carbon;
    EditText mineral;
    EditText vitamin;
    EditText sugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

         ArrayList<String> ingredientsPullDown = new ArrayList<>();

        //find the views that were identified by these IDs
        recipename = (EditText) findViewById(R.id.recipe_name);
        defaultPic = (ImageView) findViewById(R.id.burger);
        recipe_detail = (EditText) findViewById(R.id.recipe_detail);

        //************************ This is for HINT PULL DOWN in ingredient *********************************
        for (String ingredient: Recipes.allRecipes.keySet())
        {
            for (String i : Recipes.allRecipes.get(ingredient).getIngredient().keySet())
            {
                if (i == null | i.length() ==0) {continue;}
                else if (!ingredientsPullDown.contains(i))
                ingredientsPullDown.add(i);
            }
        }

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

        //set adapter for ingredients pull-down menu so users can choose easily
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ingredientsPullDown);

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


        calo = (EditText) findViewById(R.id.nutrition1);
        carbon = (EditText) findViewById(R.id.nutrition2);
        mineral = (EditText) findViewById(R.id.nutrition3);
        vitamin = (EditText) findViewById(R.id.nutrition4);
        sugar = (EditText) findViewById(R.id.nutrition5);


        //Display Alert msg if Recipe name already exists
        recipename.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String recipe = recipename.getText().toString().toUpperCase();

                if (Recipes.allRecipes.containsKey(recipe)) {
                    Toast.makeText(getBaseContext(), "Recipe exists already. Please enter another Recipe!", Toast.LENGTH_LONG).show();
                }
            }
        });

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
                    final ArrayList<String> ingredient_list = new ArrayList<>();
                    if(ingredient1.length() != 0 | ingredient1 != null)
                        {ingredient_list.add(ingredient1.getText().toString().toLowerCase());}

                    if(ingredient2.length() != 0 |ingredient2 != null)
                        ingredient_list.add(ingredient2.getText().toString().toLowerCase());

                    if(ingredient3.length() != 0 |ingredient3 != null)
                        ingredient_list.add(ingredient3.getText().toString().toLowerCase());

                    if(ingredient4.length() != 0 |ingredient4 != null)
                        ingredient_list.add(ingredient4.getText().toString().toLowerCase());

                    if(ingredient5.length() != 0 |ingredient5 != null)
                        ingredient_list.add(ingredient5.getText().toString().toLowerCase());

                    if(ingredient6.length() != 0 |ingredient6 != null)
                        ingredient_list.add(ingredient6.getText().toString().toLowerCase());

                    if(ingredient7.length() != 0 |ingredient7 != null)
                        ingredient_list.add(ingredient7.getText().toString().toLowerCase());

                    if(ingredient8.length() != 0 |ingredient8 != null)
                        ingredient_list.add(ingredient8.getText().toString().toLowerCase());

                    if(ingredient9.length() != 0 |ingredient9 != null)
                        ingredient_list.add(ingredient9.getText().toString().toLowerCase());

                    if(ingredient10.length() != 0 |ingredient10 != null)
                        ingredient_list.add(ingredient10.getText().toString().toLowerCase());


                    Map<String, Integer> ingredientsCount = new HashMap<String, Integer>();
                    for (String ingres: ingredient_list)
                    {
                        Integer count = ingredientsCount.get(ingres);
                        //ingredientsCount.put(ingres, count == null ? 1 : count +1);

                        if(ingredientsCount.containsKey(ingres))
                            ingredientsCount.put(ingres, ingredientsCount.get(ingres)+1);

                        else
                            ingredientsCount.put(ingres, 1);
                    }


                    //Saving all ingredients from all recipes without duplicated into IngredientwithUnit
                    for (String ingres: ingredient_list)
                    {
                        //Integer count = ingredientsCount.get(ingres);
                        if(Recipes.IngredientwithUnit.containsKey(ingres))
                            Recipes.IngredientwithUnit.put(ingres, Recipes.IngredientwithUnit.get(ingres)+1);

                        else
                            Recipes.IngredientwithUnit.put(ingres, 1);
                    }

                    for (String ingres: ingredient_list)
                    {
                        if(Recipes.IngredientwithAmount.containsKey(ingres))
                            continue;

                        else if (ingres.equals("chicken")|ingres.equals("beef")|ingres.equals("fish")|ingres.equals("vegetable")|ingres.equals("onion")|ingres.equals("squid")|ingres.equals("shrimp"))
                            Recipes.IngredientwithAmount.put(ingres, "pound(s)");

                        else if (ingres.equals("sugar")|ingres.equals("salt")|ingres.equals("fish sauce")|ingres.equals("soy sauce")|ingres.equals("vinegar")|ingres.equals("honey") |ingres.equals("pepper")|ingres.equals("oil")|ingres.equals("garlic"))
                            Recipes.IngredientwithAmount.put(ingres, "teaspoon(s)");

                        else if (ingres.equals("tomato")|ingres.equals("yam")|ingres.equals("rice paper")|ingres.equals("potato")|ingres.equals("apple")|ingres.equals("carrot")|ingres.equals("burger"))
                            Recipes.IngredientwithAmount.put(ingres, "piece(s)");

                        else if (ingres.equals("water")|ingres.equals("milk")|ingres.equals("chicken broth")|ingres.equals("juice")|ingres.equals("soda"))
                            Recipes.IngredientwithAmount.put(ingres, "liter(s)");

                        else if (ingres.equals("flour")|ingres.equals("rice"))
                            Recipes.IngredientwithAmount.put(ingres, "cup(s)");

                        else
                            Recipes.IngredientwithAmount.put(ingres, "count(s)");
                    }


                    String recipeDirection = recipe_detail.getText().toString();


                    ArrayList<String> recipeNutrition = new ArrayList<>();
                    recipeNutrition.add(calo.getText().toString());
                    recipeNutrition.add(carbon.getText().toString());
                    recipeNutrition.add(mineral.getText().toString());
                    recipeNutrition.add(vitamin.getText().toString());
                    recipeNutrition.add(sugar.getText().toString());


                    //Limit the length of cooking direction to 250 characters
                    if (recipeDirection.length() <= 250) {
                        //add recipe name, image, ingredients and direction to a completed recipe
                        CompletedRecipe recipe = new CompletedRecipe(recipeUpperKey, imgURI, ingredientsCount, recipeDirection, recipeNutrition);
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
