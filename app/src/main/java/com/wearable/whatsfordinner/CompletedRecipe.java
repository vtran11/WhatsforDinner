package com.wearable.whatsfordinner;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import android.net.Uri;

import android.content.Context;
/**
 * Created by ThaoVy on 3/9/18.
 */

public class CompletedRecipe implements Serializable {
    public String recipeName;
    public Uri image;
    public ArrayList<String> ingeredients_list;
    public String recipeDirection;

    public CompletedRecipe(String recipeName, Uri image, ArrayList<String> ingredients_list, String recipeDirection)
    {
        this.recipeName = recipeName;
        this.image = image;
        this.ingeredients_list = ingredients_list;
        this.recipeDirection = recipeDirection;
    }



}
