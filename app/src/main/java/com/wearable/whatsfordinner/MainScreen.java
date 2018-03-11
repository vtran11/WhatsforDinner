package com.wearable.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.view.View;
import android.widget.PopupWindow;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.Gravity;
import android.view.MotionEvent;


public class MainScreen extends AppCompatActivity {
    private PopupWindow myPopupWindow;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        //Set up click listener for Banner Image
        final ImageButton banner_button = (ImageButton) findViewById(R.id.banner_image);
        banner_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // inflate the layout
                inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupShown = inflater.inflate(R.layout.popup_window, null);

                //Create and show popup window
                final PopupWindow popup= new PopupWindow(popupShown,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popup.showAtLocation(banner_button, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupShown.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent event) {
                        popup.dismiss();
                        return true;
                    }
                });
            }
        });



        //Set up click listener for meals button
        ImageButton meals_button = (ImageButton) findViewById(R.id.meals_icon);
        meals_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainScreen.this, MealsScreen.class);
                startActivity(intent);
            }
        });

                //Set up click listener for recipes button
                ImageButton recipes_button = (ImageButton) findViewById(R.id.recipes_icon);
        recipes_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainScreen.this, RecipesScreen.class);
                startActivity(intent);
            }
        });

        //Set up click listener for groceries button
        ImageButton groceries_button = (ImageButton) findViewById(R.id.groceries_icon);
        groceries_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainScreen.this, GroceriesScreen.class);
                startActivity(intent);
            }
        });


        //Set up click listener for new dish button
        ImageButton newdish_button = (ImageButton) findViewById(R.id.newdish_icon);
        newdish_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainScreen.this, NewDishScreen.class);
                startActivity(intent);
            }
        });

    }


}

