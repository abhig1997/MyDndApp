package com.abhig1997.mydndapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CharacterView extends AppCompatActivity {

    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);

        // store the bundle as a class var
        extras = getIntent().getExtras();

        // do some stuff here

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

    public void showClassName() {
        TextView classNameBox = (TextView) findViewById(R.id.className);

        // get the class name from the extras
        String class_name = extras.getString("CLASS_NAME");

        classNameBox.setText(class_name);
    }

    public void showRaceName() {
        TextView raceNameBox = (TextView) findViewById(R.id.raceName);
        String race_name = extras.getString("RACE");
        raceNameBox.setText(race_name);
    }

    public void showLevel() {
        TextView levelBox = (TextView) findViewById(R.id.levelDisplay);
        int level = extras.getInt("LEVEL_NUM");
        String levelstr = "LVL " + level;
        levelBox.setText(levelstr);
    }

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
}
