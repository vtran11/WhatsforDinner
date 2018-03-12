package com.wearable.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class GroceriesScreen extends AppCompatActivity {
    ListView ingredients_listView;
    ArrayList<String> ingredients_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_screen);


        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            ingredients_list.add(entry.getKey());
        }

        //display the ingredient list on screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_listView = (ListView) findViewById(R.id.IngredientListView);
        ingredients_listView.setAdapter(adapter);
    }
}
