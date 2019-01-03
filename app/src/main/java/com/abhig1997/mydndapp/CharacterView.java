package com.abhig1997.mydndapp;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        // display the stats scores
        showStrengthScore();
        showDexScore();
        showConstScore();
        showIntScore();
        showWisScore();
        showCharismaScore();

        // display the armor class
        showAcScore();

        showInitiative();

        showSpeed();

        createAllChangeListeners();
    }

    // Sets the class variable to show any updated extras
    public void getExtras() {
        extras = getIntent().getExtras();
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
//        TextView levelBox = (TextView) findViewById(R.id.levelDisplay);
//        int level = extras.getInt("LEVEL_NUM");
//        String levelstr = "" + level;
//        levelBox.setText(levelstr);

        EditText levelBox = (EditText) findViewById(R.id.levelDisplay);
        int level = extras.getInt("LEVEL_NUM");
//        String levelstr = "" + level;
        levelBox.setText(Integer.toString(level));

    }

    /**
     * Displays the current exp amount for the character
     */
    public void showExp() {
//        TextView expBox = (TextView) findViewById(R.id.expPointsDisplay);
//        int exp = extras.getInt("EXPERIENCE_AMOUNT");
//        String expStr = "" + exp;
//        expBox.setText(expStr);

        EditText expBox = (EditText) findViewById(R.id.expPointsDisplay);
        int exp = extras.getInt("EXPERIENCE_AMOUNT");
//        String expStr = "" + exp;
        expBox.setText(Integer.toString(exp));
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
     * Shows the strength score of the current character
     */
    public void showStrengthScore() {
        EditText strengthBox = (EditText) findViewById(R.id.strengthScoreBox);
        int strengthScore = extras.getInt("STRENGTH_SCORE");
        strengthBox.setText(Integer.toString(strengthScore));
    }

    // Display the dexterity score
    public void showDexScore() {
        EditText dexBox = (EditText) findViewById(R.id.dexScoreBox);
        int dexScore = extras.getInt("DEX_SCORE");
        dexBox.setText(Integer.toString(dexScore));
    }

    // Display the constitution score
    public void showConstScore() {
        EditText constBox = (EditText) findViewById(R.id.constScoreBox);
        int constScore = extras.getInt("CONST_SCORE");
        constBox.setText(Integer.toString(constScore));
    }

    // Display the intelligence score
    public void showIntScore() {
        EditText intBox = (EditText) findViewById(R.id.intelligenceScoreBox);
        int intScore = extras.getInt("INTELLIGENCE_SCORE");
        intBox.setText(Integer.toString(intScore));
    }

    // Display the wisdom score
    public void showWisScore() {
        EditText wisBox = (EditText) findViewById(R.id.wisdomScoreBox);
        int wisScore = extras.getInt("WISDOM_SCORE");
        wisBox.setText(Integer.toString(wisScore));
    }

    // Display the charisma score
    public void showCharismaScore() {
        EditText chaBox = (EditText) findViewById(R.id.charismaScoreBox);
        int chaScore = extras.getInt("CHARISMA_SCORE");
        chaBox.setText(Integer.toString(chaScore));
    }

    // Display the armor class
    public void showAcScore() {
        EditText acBox = (EditText) findViewById(R.id.armorClassBox);
        int ac = extras.getInt("ARMOR_CLASS");
        acBox.setText(Integer.toString(ac));
    }

    // Display the initiative bonus
    public void showInitiative() {
        EditText initiativeDisplay = (EditText) findViewById(R.id.initiativeDisplay);
        int init = extras.getInt("INITIATIVE");
        initiativeDisplay.setText(Integer.toString(init));
    }

    // Display the speed of the character
    public void showSpeed() {
        EditText speedDisplay = (EditText) findViewById(R.id.speedDisplay);
        int speed = extras.getInt("SPEED");
        speedDisplay.setText(Integer.toString(speed));
    }

    // Helper method to call all the text change listeners that save changed stats
    public void createAllChangeListeners() {
        saveHpAfterChange();
        saveLevel();
        saveExp();
        saveInitiative();
        saveArmorClass();
        saveSpeed();
    }

    public void saveSpeed() {
        final EditText speedDisplay = (EditText) findViewById(R.id.speedDisplay);
        speedDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newSpeed = Integer.parseInt(speedDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();
                    // add the newHP to the bundle
                    currExtras.putInt("INITIATIVE", newSpeed);

                    extras = currExtras; // update the extras bundle

                    // now save the bundle to the file
                    saveAllExtras();
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

            }
        });
    }

    public void saveArmorClass() {
        final EditText acDisplay = (EditText) findViewById(R.id.armorClassBox);
        acDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newArmorClass = Integer.parseInt(acDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();
                    // add the newHP to the bundle
                    currExtras.putInt("ARMOR_CLASS", newArmorClass);

                    extras = currExtras; // update the extras bundle

                    // now save the bundle to the file
                    saveAllExtras();
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

            }
        });
    }

    public void saveInitiative() {
        final EditText initiativeDisplay = (EditText) findViewById(R.id.initiativeDisplay);
        initiativeDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newInit = Integer.parseInt(initiativeDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();
                    // add the newHP to the bundle
                    currExtras.putInt("INITIATIVE", newInit);

                    extras = currExtras; // update the extras bundle

                    // now save the bundle to the file
                    saveAllExtras();
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

            }
        });
    }

    // the next methods are the methods that add text changed listeners
    public void saveExp() {
        final EditText expDisplay = (EditText) findViewById(R.id.expPointsDisplay);
        expDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int newExp = Integer.parseInt(expDisplay.getText().toString()); // the new hp
                // of the char

                // need to save that new HP into the file

                Bundle currExtras = getIntent().getExtras();
                // add the newHP to the bundle
                currExtras.putInt("EXPERIENCE_AMOUNT", newExp);

                extras = currExtras; // update the extras bundle

                // now save the bundle to the file
                saveAllExtras();
            }
        });
    }

    public void saveLevel() {
        final EditText levelDisplay = (EditText) findViewById(R.id.levelDisplay);
        levelDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newLevel = Integer.parseInt(levelDisplay.getText().toString()); // the new hp
                    // of the char
//                    System.out.println("newHp is " + newHp);

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // update the extras
//                    getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("LEVEL_NUM", newLevel);

//                    System.out.println("The hp stored is " + currExtras.getInt("HIT_POINTS"));

                    extras = currExtras; // update the extras bundle

                    // now save the bundle to the file
                    saveAllExtras();
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }
        });
    }

    // Saves the HP to the JSON file if the EditText is changed
    public void saveHpAfterChange() {
        final EditText hpDisplay = (EditText) findViewById(R.id.hpDisplay);
        hpDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // this should be what i need
//                System.out.println("finna try to save");
                try {
                    System.out.println("in here");
                    int newHp = Integer.parseInt(hpDisplay.getText().toString()); // the new hp
                    // of the char
                    System.out.println("newHp is " + newHp);

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // update the extras
//                    getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("HIT_POINTS", newHp);

                    System.out.println("The hp stored is " + currExtras.getInt("HIT_POINTS"));

                    extras = currExtras; // update the extras bundle

                    // now save the bundle to the file
                    saveAllExtras();

                    return;
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

            }
        });
    }

    /**
     * Saves all the character stats into a JSONObject and stores the file in internal storage
     * @return false if the saving is unsuccessful
     *         true  if the saving is successful
     */
    public boolean saveAllExtras() {
//        Bundle extras = getIntent().getExtras();
//        getExtras();

//        System.out.println("hit points is " + extras.getInt("HIT_POINTS"));

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
            obj.put("hit_points", extras.getInt("HIT_POINTS"));
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
            obj.put("initiative", extras.getInt("INITIATIVE"));
            obj.put("speed", extras.getInt("SPEED"));


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
