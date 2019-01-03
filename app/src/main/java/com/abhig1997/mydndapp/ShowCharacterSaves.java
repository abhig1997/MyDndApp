package com.abhig1997.mydndapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ShowCharacterSaves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_character_saves);

        String[] files = getFiles(); // get the files created by the app

        // set the options for the spinner
        Spinner savespinner = (Spinner) findViewById(R.id.saveSpinner);
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                files);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        savespinner.setAdapter(adapter);
    }

    /**
     * Returns a string array for the files created by the DnD app
     * @return
     */
    public String[] getFiles() {
        System.out.println(fileList());
        return fileList();
    }

    /**
     * Called when the submit button is clicked
     * @param view
     */
    public void goToCharacterScreen(View view) {
        // get the file they selected
        Spinner saveSpinner = (Spinner) findViewById(R.id.saveSpinner); // the spinner in the view
        String filename = saveSpinner.getSelectedItem().toString();

        if (filename == null || filename.length() == 0) {
            // bad filename or no saves exist
            return;
        }

        // load the data from the file
        String json = null;
        try {
            InputStream is = openFileInput(filename);
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (json == null) {
            // couldn't load a string for some reason
            System.out.println("bad filename, could not load json object");
            return;
        }



        try {
            JSONObject obj = new JSONObject(json);

            System.out.println(obj.toString(4));

            // need to get all the values from the json file and put them in a bundle
            // then pass that bundle to the CharacterView page
            Bundle extras = new Bundle(); // the bundle to pass to the next activity

            String name = obj.getString("name");
            extras.putString("CHARACTER_NAME", name);

            String class_name = obj.getString("class");
            extras.putString("CLASS_NAME", class_name);

            int level_num = obj.getInt("level");
            extras.putInt("LEVEL_NUM" ,level_num);

            String background = obj.getString("background");
            extras.putString("BACKGROUND", background);

            String race = obj.getString("race");
            extras.putString("RACE", race);

            int hp = obj.getInt("hit_points");
            extras.putInt("HIT_POINTS", hp);


            String alignment = obj.getString("alignment");
            extras.putString("ALIGNMENT", alignment);

            int exp = obj.getInt("exp");
            extras.putInt("EXPERIENCE_AMOUNT", exp);

            int strength_score = obj.getInt("strength");
            extras.putInt("STRENGTH_SCORE", strength_score);

            int dex = obj.getInt("dex");
            extras.putInt("DEX_SCORE", dex);

            int const_score = obj.getInt("const");
            extras.putInt("CONST_SCORE", const_score);

            int intelligence = obj.getInt("intelligence");
            extras.putInt("INTELLIGENCE_SCORE", intelligence);

            int wis = obj.getInt("wisdom");
            extras.putInt("WISDOM_SCORE", wis);

            int cha = obj.getInt("charisma");
            extras.putInt("CHARISMA_SCORE", cha);

            // now for the skill scores
            int acrobatics = obj.getInt("acrobatics");
            extras.putInt("ACROBATICS_SCORE", acrobatics);

            int animal = obj.getInt("animal");
            extras.putInt("ANIMAL_SCORE", animal);

            int athletics = obj.getInt("athletics");
            extras.putInt("ATHLETICS_SCORE", athletics);

            int deception = obj.getInt("deception");
            extras.putInt("DECEPTION_SCORE", deception);

            int history = obj.getInt("history");
            extras.putInt("HISTORY_SCORE", history);


            int insight = obj.getInt("insight");
            extras.putInt("INSIGHT_SCORE", insight);


            int intim = obj.getInt("intimidation");
            extras.putInt("INTIM_SCORE", intim);


            int investigation = obj.getInt("investigation");
            extras.putInt("INVEST_SCORE", investigation);


            int med = obj.getInt("medicine");
            extras.putInt("MED_SCORE", med);


            int nature = obj.getInt("nature");
            extras.putInt("NATURE_SCORE", nature);


            int perception = obj.getInt("perception");
            extras.putInt("PERCEPTION_SCORE", perception);


            int performance = obj.getInt("performance");
            extras.putInt("PERFORM_SCORE", performance);


            int persuasion = obj.getInt("persuasion");
            extras.putInt("PERSUASION_SCORE", persuasion);


            int religion = obj.getInt("religion");
            extras.putInt("RELIGION_SCORE", religion);


            int sleight = obj.getInt("sleight_of_hand");
            extras.putInt("SLEIGHT_SCORE", sleight);


            int stealth = obj.getInt("stealth");
            extras.putInt("STEALTH_SCORE", stealth);


            int survival = obj.getInt("survival");
            extras.putInt("SURVIVAL_SCORE", survival);


            int armor = obj.getInt("armor");
            extras.putInt("ARMOR_CLASS", armor);


            int gold = obj.getInt("gold");
            extras.putInt("GOLD", gold);


            int silver = obj.getInt("silver");
            extras.putInt("SILVER", silver);

            int copper = obj.getInt("copper");
            extras.putInt("COPPER", copper);



            // at this point the bundle is finished, can pass it to the CharacterView screen
            Intent intent = new Intent(this, CharacterView.class);
            intent.putExtras(extras);
            startActivity(intent);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
