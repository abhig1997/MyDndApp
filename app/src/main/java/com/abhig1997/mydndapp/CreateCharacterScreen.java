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

        

    }

}
