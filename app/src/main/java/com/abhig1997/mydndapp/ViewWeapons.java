package com.abhig1997.mydndapp;

import android.content.Context;
import android.content.Intent;
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

public class ViewWeapons extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weapons);

        // toolbar stuff
        Toolbar myToolbar = (Toolbar) findViewById(R.id.view_weapons_toolbar);
        setSupportActionBar(myToolbar);


        // set extras
        this.extras = getIntent().getExtras();

        // display current weapons
        displayWeapons();

        // add TextWatcher to weapons list
        saveWeaponsChanges();
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

            case R.id.proficiencies:
                goToProficienciesView();
                return true;

            case R.id.spells:
                goToSpellsView();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToSpellsView() {
        Intent intent = new Intent(this, ViewSpells.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    private void goToProficienciesView() {
        Intent intent = new Intent(this, ViewProficiencies.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    private void goToInventoryView() {
        Intent intent = new Intent(this, ViewInventory.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    private void goToCharacterView() {
        Intent intent = new Intent(this, CharacterView.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    public void displayWeapons() {
        EditText weaponsDisplay = (EditText) findViewById(R.id.weaponsDisplay);
        String weaponsContent = extras.getString("WEAPONS");
        if (weaponsContent == null || weaponsContent.length() == 0) {
            weaponsDisplay.setText("No weapons!");
        }
        else {
            weaponsDisplay.setText(weaponsContent);
        }
    }

    public void saveWeaponsChanges() {
        final EditText weaponsDisplay = (EditText) findViewById(R.id.weaponsDisplay);
        weaponsDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
//                    int newVal = Integer.parseInt(weaponsDisplay.getText().toString()); // the new hp
                    // of the char
                    String newVal = weaponsDisplay.getText().toString();

                    // need to save that new HP into the file

                    Bundle currExtras = getIntent().getExtras();

                    // add the newHP to the bundle
                    currExtras.putString("WEAPONS", newVal);

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
            if (extras.getString("INVENTORY").length() == 0) {
                obj.put("inventory", "No items!!");
            }
            else {
                obj.put("inventory", extras.getString("INVENTORY"));
            }

            if (extras.getString("WEAPONS") == null || extras.getString("WEAPONS").length() == 0) {
                obj.put("weapons", "No weapons");
                extras.putString("WEAPONS", "No weapons");
            }
            else {
                obj.put("weapons", extras.getString("WEAPONS"));
            }

            if (extras.getString("SPELLS") == null || extras.getString("SPELLS").length() == 0) {
                obj.put("spells", "No spells");
                extras.putString("SPELLS", "No spells");
            }
            else {
                obj.put("spells", extras.getString("SPELLS"));
            }


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
        catch (NullPointerException npe) {
            npe.printStackTrace();
            return false;
        }

    }
}
