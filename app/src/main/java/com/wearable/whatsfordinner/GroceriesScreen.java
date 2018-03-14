package com.wearable.whatsfordinner;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class GroceriesScreen extends AppCompatActivity {
    ListView ingredients_listView;

    String recipesname;
    ArrayList<String> ingredients_list = new ArrayList<>();
    ArrayList<String> recipes = new ArrayList<>();

    //Uri image;
    //String directions;
    //CompletedRecipe recipe = new CompletedRecipe(recipesname, image, ingredients_list, directions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_screen);

        //get recipes name from saved Recipes List and put into a list
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            recipes.add(entry.getKey());
        }

        //Try to get all ingredients from Recipe Screen
       /* for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            for (String i : entry.getValue().getIngredient())
            {
                    ingredients_list.add(i); //work for 1 first ingredient
            }
        }*/

       for(String text: recipes) {
           for (int i = 0; i < Recipes.allRecipes.get(text).getIngredient().size(); i++) {
               ingredients_list.add(Recipes.allRecipes.get(text).getIngredient().get(i));
           }
       }


        //display the ingredient list on screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_listView = (ListView) findViewById(R.id.IngredientListView);
        ingredients_listView.setAdapter(adapter);


    }
}
