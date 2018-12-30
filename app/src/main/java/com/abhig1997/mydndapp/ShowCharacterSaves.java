package com.abhig1997.mydndapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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


}
