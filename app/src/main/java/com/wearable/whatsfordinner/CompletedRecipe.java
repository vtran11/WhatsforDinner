package com.wearable.whatsfordinner;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.net.Uri;

import android.content.Context;
/**
 * Created by ThaoVy on 3/9/18.
 */

public class CompletedRecipe implements Serializable {
    public String recipeName;
    public Uri image;
    public Map<String, Integer> ingeredients_list;
    public String recipeDirection;

    public CompletedRecipe(String recipeName, Uri image, Map<String, Integer> ingredients, String recipeDirection)
    {
        this.recipeName = recipeName;
        this.image = image;
        this.ingeredients_list = ingredients;
        this.recipeDirection = recipeDirection;
    }

    Uri getImage() {
        return image;
    }

    Map<String, Integer> getIngredient() {return ingeredients_list;}

    String getDirection() {
        return recipeDirection;
    }

}
