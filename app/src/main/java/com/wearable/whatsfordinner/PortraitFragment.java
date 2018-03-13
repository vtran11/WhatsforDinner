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
import android.widget.Toast;

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

        return portraitView;
    }
}