package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateCharacterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_screen);
//        Spinner spinner = (Spinner) findViewById(R.id.class_spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.classes_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
        createClassesSpinner();
        createAlignmentSpinner();

    }

    /**
     * Create the entries for the alignment drop down menu
     */
    private void createAlignmentSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.alignment_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alignment_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * Create the entries for the classes spinner
     */
    public void createClassesSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.class_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classes_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    /**
     *
     * @param view
     */
    public void enterAbilityScores(View view) {
        // create the intent for the ability scores class
        Intent intent = new Intent(this, EnterAbilityScores.class);

        // add the extras to the intent
        Bundle extras = new Bundle();

        // add all the necessary key value pairs

        // add the character name
        EditText characterNameBox = (EditText) findViewById(R.id.char_name_input);
        String characterName = characterNameBox.getText().toString();
        extras.putString("CHARACTER_NAME", characterName);

        // get the class name that they selected
        Spinner classSpinner = (Spinner) findViewById(R.id.class_spinner);
        String className = classSpinner.getSelectedItem().toString();
        extras.putString("CLASS_NAME", className);

        // add the level number
        EditText levelNumberBox = (EditText) findViewById(R.id.level_input);
        int levelNum = Integer.parseInt(levelNumberBox.getText().toString());
        extras.putInt("LEVEL_NUM", levelNum);

        // add the background information string
        EditText backgroundBox = (EditText) findViewById(R.id.background_input);
        String background = backgroundBox.getText().toString();
        extras.putString("BACKGROUND", background);

        // add the race input
        EditText raceBox = (EditText) findViewById(R.id.race_input);
        String raceInput = raceBox.getText().toString();
        extras.putString("RACE", raceInput);

        // add hit points input
        EditText hpBox = (EditText) findViewById(R.id.hp_input);
        String hpInput = hpBox.getText().toString();
        extras.putInt("HIT_POINTS", Integer.parseInt(hpInput));

        // add the alignment
        Spinner alignmentSpinner = (Spinner) findViewById(R.id.alignment_spinner);
        String alignmentString = alignmentSpinner.getSelectedItem().toString();
        extras.putString("ALIGNMENT", alignmentString);

        // add the experience points
        EditText experienceBox = (EditText) findViewById(R.id.exp_input);
        int experienceAmt = Integer.parseInt(experienceBox.getText().toString());
        extras.putInt("EXPERIENCE_AMOUNT", experienceAmt);

        intent.putExtras(extras); // attach the extras to the ability scores screen

        startActivity(intent);
    }

}
