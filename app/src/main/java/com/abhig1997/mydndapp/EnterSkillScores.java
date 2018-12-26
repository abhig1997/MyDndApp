package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class EnterSkillScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_skill_scores);
    }

    public void submitSkillScores(View view) {
        Intent intent = new Intent(this, EnterFinalStats.class); // create the intent
                                                                        // to go to the next screen
        Bundle updatedExtras = getIntent().getExtras(); // get the extras attached to this intent,
                                                    // should have all the other info

        // start adding the skill scores to the bundle


        // add acrobatics
        EditText acrobatics_box = (EditText) findViewById(R.id.acrobatics_box);
        int acrobatics_score = Integer.parseInt(acrobatics_box.getText().toString());
        updatedExtras.putInt("ACROBATICS_SCORE", acrobatics_score);

        // add animal handling score
        EditText animal_box = (EditText) findViewById(R.id.animal_box);
        int animal_score = Integer.parseInt(animal_box.getText().toString());
        updatedExtras.putInt("ANIMAL_SCORE", animal_score);

        // add arcana score
        EditText arcana_box = (EditText) findViewById(R.id.arcana_box);
        int arcana_score = Integer.parseInt(arcana_box.getText().toString());
        updatedExtras.putInt("ARCANA_SCORE", arcana_score);

        // add athletics score
        EditText athletics_box = (EditText) findViewById(R.id.athletics_box);
        int athletics_score = Integer.parseInt(athletics_box.getText().toString());
        updatedExtras.putInt("ATHLETICS_SCORE", athletics_score);

        // add deception score
        
    }
}
