package com.wearable.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
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
    ImageView image;

    ArrayList<String> recipesNameList = new ArrayList<>();

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

                //*****  Set Recipe Name for current Selected Recipe  ****** DONE
                String selectedRecipe = (String) adapterView.getItemAtPosition(position);
                recipe_name = (TextView) landscapeView.findViewById(R.id.recipeName);
                recipe_name.setText(selectedRecipe);

                //Selected recipe with details
                CompletedRecipe recipe = Recipes.allRecipes.get(selectedRecipe);


                //******  Set Image for current Selected Recipe  ********* DONE with default imagdd
                image = (ImageView) landscapeView.findViewById(R.id.recipe_pic) ;
                image.setImageURI(recipe.getImage());



                //******  Set Ingredients for current Selected Recipe  *********
                ingredients_list = (TextView) landscapeView.findViewById(R.id.ingredient_list);
                 /*   for (String ing: Recipes.allRecipes.get(selectedRecipe).getIngredient().keySet())
                    {
                        if (ing == null | ing.length() ==0) {continue;}

                        ingredients_list.add(ing + " ( " + Recipes.allRecipes.get(selectedRecipe).getIngredient().get(ing) + " )");
                        ingredients_list.append("\n");
                    }*/
                ArrayList<String> ingredients = new ArrayList<>();
                for (String ing: Recipes.allRecipes.get(selectedRecipe).getIngredient().keySet())
                {
                    if (ing == null | ing.length() ==0) {continue;}

                    ingredients.add(ing + " ( " + Recipes.allRecipes.get(selectedRecipe).getIngredient().get(ing) + " )");

                }

                for (int i =0; i< ingredients.size(); i++)
                {
                    ingredients_list.setText(ingredients.get(i) + "\n");

                }


                //******  Set Direction for current Selected Recipe  ********* DONE
                direction_list = (TextView) landscapeView.findViewById(R.id.recipe_direction);
                direction_list.setText(recipe.recipeDirection);

            }
        });


        return landscapeView;
    }

}
