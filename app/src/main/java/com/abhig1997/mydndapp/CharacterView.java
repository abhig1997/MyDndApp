package com.abhig1997.mydndapp;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.TextView;
import org.json.*;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CharacterView extends AppCompatActivity {

    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);

        // store the bundle as a class var
        extras = getIntent().getExtras();

        // do some stuff here

        // save the extras associated with this character
        boolean saveWasSuccess = saveAllExtras();

        // call method to display the character's name
        showCharacterName();

        // call method to display class name
        showClassName();

        // call method to display race name
        showRaceName();

        // display the level
        showLevel();

        // display the exp points
        showExp();

        // display the hit points
        showHP();
    }

    /**
     * Sets the TextView to contain the character name contained in the bundle
     */
    public void showCharacterName() {
        TextView characterName = (TextView) findViewById(R.id.characterName); // the textView box

        // get the character name from the bundle
        String char_name = extras.getString("CHARACTER_NAME");

        characterName.setText(char_name);
    }

    /**
     * Show the class of the char
     */
    public void showClassName() {
        TextView classNameBox = (TextView) findViewById(R.id.className);

        // get the class name from the extras
        String class_name = extras.getString("CLASS_NAME");

        classNameBox.setText(class_name);
    }

    /**
     * Display the race of the character
     */
    public void showRaceName() {
        TextView raceNameBox = (TextView) findViewById(R.id.raceName);
        String race_name = extras.getString("RACE");
        raceNameBox.setText(race_name);
    }

    /**
     * Display the level of the character
     */
    public void showLevel() {
        TextView levelBox = (TextView) findViewById(R.id.levelDisplay);
        int level = extras.getInt("LEVEL_NUM");
        String levelstr = "LVL " + level;
        levelBox.setText(levelstr);
    }

    /**
     * Displays the current exp amount for the character
     */
    public void showExp() {
        TextView expBox = (TextView) findViewById(R.id.expPointsDisplay);
        int exp = extras.getInt("EXPERIENCE_AMOUNT");
        String expStr = "EXP: " + exp;
        expBox.setText(expStr);
    }

    /**
     * Displays the current hit points of the character
     */
    public void showHP() {
        EditText hpBox = (EditText) findViewById(R.id.hpDisplay);
        int currentHp = extras.getInt("HIT_POINTS");
        hpBox.setText(Integer.toString(currentHp));
    }

    /**
     * Saves all the extras associated with the current character
     * @return false if the saving is unsuccessful
     *         true  if the saving is successful
     */
    public boolean saveAllExtras() {
        Bundle extras = getIntent().getExtras();

        String character_name = extras.getString("CHARACTER_NAME");

        String filename = character_name + ".json"; // this is the filename that we'll be writing

        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            // format the json string here
            String toWrite = "";

            JSONObject obj = new JSONObject();
            // add all the stats to this JSONobject
            obj.put("name", character_name);
            obj.put("class", extras.getString("CLASS_NAME"));
            obj.put("level", extras.getInt("LEVEL_NUM"));
            obj.put("background", extras.getString("BACKGROUND"));
            obj.put("race", extras.getString("RACE"));
            obj.put("hit_points", extras.getString("HIT_POINTS"));
            obj.put("alignment", extras.getString("ALIGNMENT"));
            obj.put("exp", extras.getInt("EXPERIENCE_AMOUNT"));
            obj.put("strength", extras.getInt("STRENGTH_SCORE"));
            obj.put("dex", extras.getInt("DEX_SCORE"));
            obj.put("const", extras.getInt("CONST_SCORE"));
            obj.put("intelligence", extras.getInt("INTELLIGENCE_SCORE"));
            obj.put("wisdom", extras.getInt("WISDOM_SCORE"));
            obj.put("charisma", extras.getInt("CHARISMA_SCORE"));
            obj.put("acrobatics", extras.getInt("ACROBATICS_SCORE"));
            obj.put("animal", extras.getInt("ANIMAL_SCORE"));
            obj.put("arcana", extras.getInt("ARCANA_SCORE"));
            obj.put("athletics", extras.getInt("ATHLETICS_SCORE"));
            obj.put("deception", extras.getInt("DECEPTION_SCORE"));
            obj.put("history", extras.getInt("HISTORY_SCORE"));
            obj.put("insight", extras.getInt("INSIGHT_SCORE"));
            obj.put("intimidation", extras.getInt("INTIM_SCORE"));
            obj.put("investigation", extras.getInt("INVEST_SCORE"));
            obj.put("medicine", extras.getInt("MED_SCORE"));
            obj.put("nature", extras.getInt("NATURE_SCORE"));
            obj.put("perception", extras.getInt("PERCEPTION_SCORE"));
            obj.put("performance", extras.getInt("PERFORM_SCORE"));
            obj.put("persuasion", extras.getInt("PERSUASION_SCORE"));
            obj.put("religion", extras.getInt("RELIGION_SCORE"));
            obj.put("sleight_of_hand", extras.getInt("SLEIGHT_SCORE"));
            obj.put("stealth", extras.getInt("STEALTH_SCORE"));
            obj.put("survival", extras.getInt("SURVIVAL_SCORE"));
            obj.put("armor", extras.getInt("ARMOR_CLASS"));
            obj.put("gold", extras.getInt("GOLD"));
            obj.put("silver", extras.getInt("SILVER"));
            obj.put("copper", extras.getInt("COPPER"));


            toWrite = obj.toString(4);
            System.out.println(toWrite);



            // write the json file
            if (toWrite.length() > 0) {
                fos.write(toWrite.getBytes());
            }
            fos.close();
            return true;
        }
        catch (FileNotFoundException fnfe) {
            return false;
        }
        catch (IOException ioe) {
            return false;
        }
        catch (org.json.JSONException jse) {
            return false;
        }

    }

    /**
     * Check whether we can write to external storage
     *
     * @return
     */
    public boolean isExternalWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
