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

public class EditedDishScreen extends AppCompatActivity {


    Uri imgURI = Uri.parse("android.resource://com.wearable.whatsfordinner/drawable/burger");

    EditText recipename;
    ImageView defaultPic;
    ImageButton newpicButton;
    EditText recipe_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

        Bundle extras = getIntent().getExtras();


        //find the views that were identified by these IDs
        recipename = (EditText) findViewById(R.id.recipe_name);
        String recipe = (String) extras.getString("editedRecipe");
        recipename.setText(recipe);

        defaultPic = (ImageView) findViewById(R.id.burger);

        recipe_detail = (EditText) findViewById(R.id.recipe_detail);
        String direction = (String) extras.getString("editedDirection");
        recipe_detail.setText(direction);

        ArrayList<String> ingre = getIntent().getStringArrayListExtra("editedIngedients");;

        final EditText ingredient1 = (EditText) findViewById(R.id.ingredient1);
        if(ingre.get(0) != null)
            ingredient1.setText(ingre.get(0));

        final EditText ingredient2 = (EditText) findViewById(R.id.ingredient2);
        if(ingre.get(1) != null)
            ingredient2.setText(ingre.get(1));

        final EditText ingredient3 = (EditText) findViewById(R.id.ingredient3);
        if(ingre.get(2) != null)
            ingredient3.setText(ingre.get(2));

        final EditText ingredient4 = (EditText) findViewById(R.id.ingredient4);
        if(ingre.get(3) != null)
            ingredient4.setText(ingre.get(3));

        final EditText ingredient5 = (EditText) findViewById(R.id.ingredient5);
        if(ingre.get(4) != null)
            ingredient5.setText(ingre.get(4));
        final EditText ingredient6 = (EditText) findViewById(R.id.ingredient6);
        if(ingre.get(5) != null)
            ingredient6.setText(ingre.get(5));
        final EditText ingredient7 = (EditText) findViewById(R.id.ingredient7);
        if(ingre.get(6) != null)
            ingredient7.setText(ingre.get(6));
        final EditText ingredient8 = (EditText) findViewById(R.id.ingredient8);
        if(ingre.get(7) != null)
            ingredient8.setText(ingre.get(7));
        final EditText ingredient9 = (EditText) findViewById(R.id.ingredient9);
        if(ingre.get(8) != null)
            ingredient9.setText(ingre.get(8));
        final EditText ingredient10 = (EditText) findViewById(R.id.ingredient10);
        if(ingre.get(9) != null)
            ingredient10.setText(ingre.get(9));



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
                    final ArrayList<String> ingredient_list = new ArrayList<>();
                    if( ingredient1 != null)
                    {ingredient_list.add(ingredient1.getText().toString().toLowerCase());}

                    if(ingredient2 != null)
                        ingredient_list.add(ingredient2.getText().toString().toLowerCase());

                    if(ingredient3 != null)
                        ingredient_list.add(ingredient3.getText().toString().toLowerCase());

                    if(ingredient4 != null)
                        ingredient_list.add(ingredient4.getText().toString().toLowerCase());

                    if(ingredient5 != null)
                        ingredient_list.add(ingredient5.getText().toString().toLowerCase());

                    if(ingredient6 != null)
                        ingredient_list.add(ingredient6.getText().toString().toLowerCase());

                    if(ingredient7 != null)
                        ingredient_list.add(ingredient7.getText().toString().toLowerCase());

                    if(ingredient8 != null)
                        ingredient_list.add(ingredient8.getText().toString().toLowerCase());

                    if(ingredient9 != null)
                        ingredient_list.add(ingredient9.getText().toString().toLowerCase());

                    if(ingredient10 != null)
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

                    //Limit the length of cooking direction to 250 characters
                    if (recipeDirection.length() <= 250) {
                        //add recipe name, image, ingredients and direction to a completed recipe
                        CompletedRecipe recipe = new CompletedRecipe(recipeUpperKey, imgURI, ingredientsCount, recipeDirection);
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
