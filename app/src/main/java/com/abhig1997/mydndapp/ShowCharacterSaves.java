package com.abhig1997.mydndapp;

import android.content.Context;
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

            // need to get all the values from the json file and put them in a bundle
            // then pass that bundle to the CharacterView page
            Bundle extras = new Bundle(); // the bundle to pass to the next activity



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
