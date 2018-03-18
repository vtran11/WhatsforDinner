package com.wearable.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;


public class PortraitFragment extends Fragment {
    ListView recipesListView;
    ArrayList<String> recipes_list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View portraitView = inflater.inflate(R.layout.fragment_portrait, container, false);

        //get recipes name from saved Recipes List and put into a list
        for (Map.Entry<String, CompletedRecipe> entry: Recipes.allRecipes.entrySet()) {
            recipes_list.add(entry.getKey());
        }

        //display the recipes name List on screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, recipes_list);
        recipesListView = (ListView) portraitView.findViewById(R.id.recipesList);
        recipesListView.setAdapter(adapter);

        //******  Save Recipe Name to allSelectedRecipes when user clicks on any Name  *********
        recipesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Save current selected Recipe Name
                String selectedRecipe = (String) adapterView.getItemAtPosition(position);
                Recipes.allSelectedRecipes.add(selectedRecipe);
            }
        });

        //******* Long Presses recipe Item for editing *******
        recipesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedRecipe = (String) adapterView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), EditedDishScreen.class);
                intent.putExtra("editedRecipe", selectedRecipe);
                intent.putExtra("editedDirection", Recipes.allRecipes.get(selectedRecipe).getDirection());

               /* ArrayList<String> ing = new ArrayList<>();
                for(String ingredient: Recipes.allRecipes.get(selectedRecipe).getIngredient().keySet()) {
                    ing.add(ingredient);
                }

                intent.putExtra("editedIng1", ing.get(0));
                //intent.putExtra("editedIng2", ing.get(1));
                //intent.putExtra("editedIng3", ing.get(2));
                //intent.putExtra("editedIng4", ing.get(3));
                //intent.putExtra("editedIng5", ing.get(4));
                //intent.putExtra("editedIng6", ing.get(5));
                //intent.putExtra("editedIng7", ing.get(6));
                //intent.putExtra("editedIng8", ing.get(7));
                //intent.putExtra("editedIng9", ing.get(8));
                intent.putExtra("editedIng10", ing.get(9));*/


                startActivity(intent);

                return true;
            }
        });

        return portraitView;
    }
}

