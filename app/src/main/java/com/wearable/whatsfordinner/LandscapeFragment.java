package com.wearable.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LandscapeFragment extends Fragment {
    ListView recipesListView;
    TextView recipe_name;
    TextView ingredients_list;
    TextView direction_list;
    ArrayList<String> recipesNameList = new ArrayList<>();


    ArrayList<String> ingredients = new ArrayList<>();
    Uri image;
    String directions;
    String name;
    CompletedRecipe recipe = new CompletedRecipe(name,image,ingredients,directions);
    ArrayList<String> ing = ingredients;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View landscapeView = inflater.inflate(R.layout.fragment_landscape, container, false);

        //get recipes name from saved Recipes List and put them into a list
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            recipesNameList.add(entry.getKey());
        }

        //display the recipes name List on screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, recipesNameList);
        recipesListView = (ListView) landscapeView.findViewById(R.id.recipesList);
        recipesListView.setAdapter(adapter);

        recipesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Set Recipe Name for current Recipe Selected
                String selectedRecipe = (String) adapterView.getItemAtPosition(position);
                recipe_name = (TextView) landscapeView.findViewById(R.id.recipeName);
                recipe_name.setText(selectedRecipe);


                //*******************************************************************************
                //******Set Image, Ingredients and Direction for current Recipe Selected*********
                ingredients_list = (TextView) landscapeView.findViewById(R.id.ingredient_list);
                direction_list = (TextView) landscapeView.findViewById(R.id.recipe_direction);

                for(Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet())
                {
                    if(entry.getKey() == selectedRecipe) {
                    }
                }
            }
        });


        return landscapeView;
    }

}
