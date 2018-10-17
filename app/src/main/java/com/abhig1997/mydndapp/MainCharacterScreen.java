package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainCharacterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_character_screen);

        // hide the action bar
//        ActionBar ab = getSupportActionBar();
//        ab.hide();
    }

    /**
     * Called when the user taps the Create Character button
     * @param view
     */
    public void createCharacter(View view) {
        Intent intent = new Intent(this, CreateCharacterScreen.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the View Characters button
     * @param view
     */
    public void viewCharacters(View view) {

    }
}
