package com.abhig1997.mydndapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ViewInventory extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inventory);

        // do toolbar stuff
        Toolbar myToolbar = (Toolbar) findViewById(R.id.view_inventory_toolbar);
        setSupportActionBar(myToolbar);

        // get extras
        this.extras = getIntent().getExtras();

        // display money
        displayMoney();

        // create TextWatchers
        saveAllChanges();

    }

    public void getExtras() {this.extras = getIntent().getExtras();}

    /**
     * Displays the amount of gold, silver, and bronze belonging to the character
     */
    public void displayMoney() {
        EditText goldDisplay = (EditText) findViewById(R.id.goldDisplay);
        int gold_amount = extras.getInt("GOLD");
        goldDisplay.setText(Integer.toString(gold_amount));

        EditText silverDisplay = (EditText) findViewById(R.id.silverDisplay);
        int silver = extras.getInt("SILVER");
        silverDisplay.setText(Integer.toString(silver));

        EditText bronzeDisplay = (EditText) findViewById(R.id.bronzeDisplay);
        int bronze = extras.getInt("BRONZE");
        bronzeDisplay.setText(Integer.toString(bronze));
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

    // SAVING METHODS ////////////////////////////////////

    public void saveAllChanges() {
        saveGold();
        saveSilver();
        saveBronze();
    }

    public void saveGold() {
        final EditText goldDisplay = (EditText) findViewById(R.id.goldDisplay);
        goldDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(goldDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("GOLD", newVal);

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

    public void saveSilver() {
        final EditText silverDisplay = (EditText) findViewById(R.id.silverDisplay);
        silverDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(silverDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("SILVER", newVal);

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

    public void saveBronze() {
        final EditText bronzeDisplay = (EditText) findViewById(R.id.bronzeDisplay);
        bronzeDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(bronzeDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("BRONZE", newVal);

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


}
