package com.abhig1997.mydndapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ViewProficiencies extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_proficiencies);

        // toolbar stuff
        Toolbar myToolbar = (Toolbar) findViewById(R.id.view_proficiencies_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        this.getExtras();

        this.displayAllSkillScores();


        this.saveAllChanges();

    }

    /**
     * Creates the options for the menu
     * @param menu
     * @return true if the menu is made successfully
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_proficiencies_menu, menu);
        return true;
    }

    /**
     * Handles the navigation of the menu in the toolbar
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.characterView:
                goToCharacterView();
                return true;
            case R.id.inventory:
                goToInventoryView();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Navigates to the Character View page
     */
    public void goToCharacterView() {
        Intent intent = new Intent(this, CharacterView.class);
//        this.getExtras();
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    /**
     * Navigates to the Character View page
     */
    public void goToInventoryView() {
        Intent intent = new Intent(this, ViewInventory.class);
//        this.getExtras();
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    // Sets the class variable to show any updated extras
    public void getExtras() {
        extras = getIntent().getExtras();
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

    // Gets information from this bundles extras and displays the skill scores of the current
    // character
    public void displayAllSkillScores() {
        EditText acrobaticsDisplay = (EditText) findViewById(R.id.acrobaticsDisplay);
        int acrobatics_score = extras.getInt("ACROBATICS_SCORE");
        acrobaticsDisplay.setText(Integer.toString(acrobatics_score));

        EditText animalDisplay = (EditText) findViewById(R.id.animalDisplay);
        int animalScore = extras.getInt("ANIMAL_SCORE");
        animalDisplay.setText(Integer.toString(animalScore));

        EditText arcanaDisplay = (EditText) findViewById(R.id.arcanaDisplay);
        int arcanaScore = extras.getInt("ARCANA_SCORE");
        arcanaDisplay.setText(Integer.toString(arcanaScore));

        EditText athleticsDisplay = (EditText) findViewById(R.id.athleticsDisplay);
        int athleticsScore = extras.getInt("ATHLETICS_SCORE");
        athleticsDisplay.setText(Integer.toString(athleticsScore));

        EditText deceptionDisplay = (EditText) findViewById(R.id.deceptionDisplay);
        int deceptionScore = extras.getInt("DECEPTION_SCORE");
        deceptionDisplay.setText(Integer.toString(deceptionScore));

        EditText historyDisplay = (EditText) findViewById(R.id.historyDisplay);
        int historyScore = extras.getInt("HISTORY_SCORE");
        historyDisplay.setText(Integer.toString(historyScore));

        EditText insightDisplay = (EditText) findViewById(R.id.insightDisplay);
        int insightScore = extras.getInt("INSIGHT_SCORE");
        insightDisplay.setText(Integer.toString(insightScore));

        EditText intimidationDisplay = (EditText) findViewById(R.id.intimidationDisplay);
        int intimidationScore = extras.getInt("INTIM_SCORE");
        intimidationDisplay.setText(Integer.toString(intimidationScore));

        EditText investigationDisplay = (EditText) findViewById(R.id.investigationDisplay);
        int investigationScore = extras.getInt("INVEST_SCORE");
        investigationDisplay.setText(Integer.toString(investigationScore));

        EditText medicineDisplay = (EditText) findViewById(R.id.medicineDisplay);
        int medicineScore = extras.getInt("MEDICINE_SCORE");
        medicineDisplay.setText(Integer.toString(medicineScore));

        EditText natureDisplay = (EditText) findViewById(R.id.natureDisplay);
        int natureScore = extras.getInt("NATURE_SCORE");
        natureDisplay.setText(Integer.toString(natureScore));

        EditText perceptionDisplay = (EditText) findViewById(R.id.perceptionDisplay);
        int perceptionScore = extras.getInt("PERCEPTION_SCORE");
        perceptionDisplay.setText(Integer.toString(perceptionScore));

        EditText performanceDisplay = (EditText) findViewById(R.id.performanceDisplay);
        int performanceScore = extras.getInt("PERFORMANCE_SCORE");
        performanceDisplay.setText(Integer.toString(performanceScore));

        EditText persuasionDisplay = (EditText) findViewById(R.id.persuasionDisplay);
        int persuasionScore = extras.getInt("PERSUASION_SCORE");
        persuasionDisplay.setText(Integer.toString(persuasionScore));

        EditText religionDisplay = (EditText) findViewById(R.id.religionDisplay);
        int religion_score = extras.getInt("RELIGION_SCORE");
        religionDisplay.setText(Integer.toString(religion_score));

        EditText sleightOfHandDisplay = (EditText) findViewById(R.id.sleightOfHandDisplay);
        int sleightOfHandScore = extras.getInt("SLEIGHT_SCORE");
        sleightOfHandDisplay.setText(Integer.toString(sleightOfHandScore));

        EditText stealthDisplay = (EditText) findViewById(R.id.stealthDisplay);
        int stealthScore = extras.getInt("STEALTH_SCORE");
        stealthDisplay.setText(Integer.toString(stealthScore));

        EditText survivalDisplay = (EditText) findViewById(R.id.survivalDisplay);
        int survivalScore = extras.getInt("SURVIVAL_SCORE");
        survivalDisplay.setText(Integer.toString(survivalScore));
    }

    // METHODS FOR SAVING CHANGES

    // Helper method that the onCreate method calls to create TextWatchers for every EditText
    public void saveAllChanges() {
        saveAcrobatics();
        saveAnimal();
        saveArcana();
        saveAthletics();
        saveDeception();
        saveHistory();
        saveInsight();
        saveIntimidation();
        saveInvestigation();
        saveMed();
        saveNature();
        savePerception();
        savePerformance();
        savePersuasion();
        saveReligion();
        saveSleight();
        saveStealth();
        saveSurvival();
    }

    public void saveAcrobatics() {
        final EditText acrobaticsDisplay = (EditText) findViewById(R.id.acrobaticsDisplay);
        acrobaticsDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newAcro = Integer.parseInt(acrobaticsDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("ACROBATICS_SCORE", newAcro);

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

    public void saveAnimal() {
        final EditText animalDisplay = (EditText) findViewById(R.id.animalDisplay);
        animalDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newAnimal = Integer.parseInt(animalDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("ANIMAL_SCORE", newAnimal);

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

    public void saveArcana() {
        final EditText arcanaDisplay = (EditText) findViewById(R.id.arcanaDisplay);
        arcanaDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newArcana = Integer.parseInt(arcanaDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("ARCANA_SCORE", newArcana);

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

    public void saveAthletics() {
        final EditText athleticsDisplay = (EditText) findViewById(R.id.athleticsDisplay);
        athleticsDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newAthletics = Integer.parseInt(athleticsDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("ATHLETICS_SCORE", newAthletics);

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


    public void saveDeception() {
        final EditText deceptionDisp = (EditText) findViewById(R.id.deceptionDisplay);
        deceptionDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newDecep = Integer.parseInt(deceptionDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("DECEPTION_SCORE", newDecep);

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

    public void saveHistory() {
        final EditText historyDisplay = (EditText) findViewById(R.id.historyDisplay);
        historyDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newAcro = Integer.parseInt(historyDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("HISTORY_SCORE", newAcro);

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

    public void saveInsight() {
        final EditText insightDisp = (EditText) findViewById(R.id.insightDisplay);
        insightDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(insightDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("INSIGHT_SCORE", newVal);

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

    public void saveIntimidation() {
        final EditText intimDisplay = (EditText) findViewById(R.id.intimidationDisplay);
        intimDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(intimDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("INTIM_SCORE", newVal);

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

    public void saveInvestigation() {
        final EditText investDisp = (EditText) findViewById(R.id.investigationDisplay);
        investDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(investDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("INVEST_SCORE", newVal);

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

    public void saveMed() {
        final EditText medDisp = (EditText) findViewById(R.id.medicineDisplay);
        medDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(medDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("MED_SCORE", newVal);

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

    public void saveNature( ) {
        final EditText natureDisp = (EditText) findViewById(R.id.natureDisplay);
        natureDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(natureDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("NATURE_SCORE", newVal);

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

    public void savePerception() {
        final EditText percepDisp = (EditText) findViewById(R.id.perceptionDisplay);
        percepDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(percepDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("PERCEPTION_SCORE", newVal);

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

    public void savePerformance() {
        final EditText performDisp = (EditText) findViewById(R.id.performanceDisplay);
        performDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(performDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("PERFORM_SCORE", newVal);

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

    public void savePersuasion() {
        final EditText persuasionDisp = (EditText) findViewById(R.id.persuasionDisplay);
        persuasionDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(persuasionDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("PERSUASION_SCORE", newVal);

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

    public void saveReligion() {
        final EditText religionDisp = (EditText) findViewById(R.id.religionDisplay);
        religionDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(religionDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("RELIGION_SCORE", newVal);

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

    public void saveSleight() {
        final EditText sleightDisp = (EditText) findViewById(R.id.sleightOfHandDisplay);
        sleightDisp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(sleightDisp.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("SLEIGHT_SCORE", newVal);

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

    public void saveStealth() {
        final EditText stealthDisplay = (EditText) findViewById(R.id.stealthDisplay);
        stealthDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(stealthDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("STEALTH_SCORE", newVal);

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

    public void saveSurvival() {
        final EditText survivalDisplay = (EditText) findViewById(R.id.survivalDisplay);
        survivalDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int newVal = Integer.parseInt(survivalDisplay.getText().toString()); // the new hp
                    // of the char

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putInt("SURVIVAL_SCORE", newVal);

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
