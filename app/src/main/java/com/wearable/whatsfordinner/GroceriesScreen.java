package com.wearable.whatsfordinner;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.SwipeRefreshLayout;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


//Credit: baozy library for swipe left and right
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

public class GroceriesScreen extends AppCompatActivity {
    SwipeMenuListView ingredients_listView;

    String recipesname;
    ArrayList<String> ingredientsWithUnit = new ArrayList<>();
    ArrayList<String> recipes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_screen);

        ingredients_listView = (SwipeMenuListView) findViewById(R.id.IngredientListView);

        //get recipes name from saved Recipes List and put into a list
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            recipes.add(entry.getKey());
        }

        //Put all ingredients with unit into the list
       /* for (String recipe: Recipes.allRecipes.keySet()) {
            for (String ing: Recipes.allRecipes.get(recipe).getIngredient().keySet())
            {
                if (ing == null | ing.length() ==0) {continue;}

                //Eliminate repeated ingredients
                if(ingredientsWithUnit.contains(ing))
                {
                    Recipes.allRecipes.get(recipe).getIngredient().get(ing) ;
                }

                else
                    ingredientsWithUnit.add(ing + " ( " + Recipes.allRecipes.get(recipe).getIngredient().get(ing) + " )");
            }
        }*/


            for (String ing: Recipes.IngredientwithUnit.keySet())
            {
                if (ing == null | ing.length() ==0) {continue;}
                ingredientsWithUnit.add(ing + " ( " + Recipes.IngredientwithUnit.get(ing) + " "+ Recipes.IngredientwithAmount.get(ing) +" )");
            }



        //display the ingredient list on screen
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientsWithUnit);
        ingredients_listView.setAdapter(adapter);


        //Swipe left and right for each ingredient (Credit: baoyongzhang/SwipeMenuListView
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem increase = new SwipeMenuItem(getApplicationContext());
                increase.setWidth(200);
                increase.setTitle("+");
                increase.setTitleSize(40);
                increase.setTitleColor(Color.BLACK);
                menu.addMenuItem(increase);

                SwipeMenuItem decrease = new SwipeMenuItem(getApplicationContext());
                decrease.setWidth(200);
                decrease.setTitle("-");
                decrease.setTitleSize(40);
                decrease.setTitleColor(Color.BLACK);
                menu.addMenuItem(decrease);
            }
        };

        //set creator
        ingredients_listView.setMenuCreator(creator);

        ingredients_listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String selectedIngredientwithUnit = (String) adapter.getItem(position);
                String selectedIngredient = selectedIngredientwithUnit.substring(0, selectedIngredientwithUnit.indexOf("(") - 1);
                int newUnit;
                switch (index){
                    case 0:
                        //newUnit = Recipes.IngredientwithUnit.get(selectedIngredient) +1;
                        //Recipes.IngredientwithUnit.put(selectedIngredient, newUnit);
                        //ingredientsWithUnit.add(selectedIngredient + " ( " + (Recipes.IngredientwithUnit.get(selectedIngredient) +1) + " )");
                        break;
                    case 1:
                        //Recipes.IngredientwithUnit.put(selectedIngredient, Recipes.IngredientwithUnit.get(selectedIngredient)-1);
                        //ingredientsWithUnit.add(selectedIngredient + " ( " + (Recipes.IngredientwithUnit.get(selectedIngredient) -1) + " )");
                        break;
                }

                //adapter.clear();
                //adapter.addAll(ingredientsWithUnit);
                //adapter.notifyDataSetChanged();

                return false;
            }
        });

    }

}
