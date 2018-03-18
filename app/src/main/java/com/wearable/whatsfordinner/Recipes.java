package com.wearable.whatsfordinner;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by ThaoVy on 3/10/18.
 */

public class Recipes {
    public static Map<String, CompletedRecipe> allRecipes = new HashMap<>();

    //Use to save selected recipes for meal planning
    public static ArrayList<String> allSelectedRecipes = new ArrayList<>();

    public static Map<String, Integer> IngredientwithUnit = new HashMap<>();
    public static Map<String, String> IngredientwithAmount = new HashMap<>();

}

