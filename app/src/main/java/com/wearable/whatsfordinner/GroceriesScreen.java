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
    //Uri image;
    //String directions;
    //CompletedRecipe recipe = new CompletedRecipe(recipesname, image, ingredients_list, directions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_screen);

        //Try to get all ingredients from Recipe Screen
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            ingredients_list.add(entry.getKey()); //this is recipe name not ingeredients
            //ingredients_list.add(Recipes.allRecipes.entrySet().toString()); //TEST
        }

        //display the ingredient list on screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_listView = (ListView) findViewById(R.id.IngredientListView);
        ingredients_listView.setAdapter(adapter);


    }
}
