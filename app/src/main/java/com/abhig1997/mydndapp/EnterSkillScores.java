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

    // Handles storing all the inputted information in a bundle and passes it to the next intent
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
        EditText deception_box = (EditText) findViewById(R.id.deception_box);
        int deception_score = Integer.parseInt(deception_box.getText().toString());
        updatedExtras.putInt("DECEPTION_SCORE", deception_score);

        // add history score
        EditText history_box = (EditText) findViewById(R.id.history_box);
        int history_score = Integer.parseInt(history_box.getText().toString());
        updatedExtras.putInt("HISTORY_SCORE", history_score);

        // add insight score
        EditText insight_box = (EditText) findViewById(R.id.insight_box);
        int insight_score = Integer.parseInt(insight_box.getText().toString());
        updatedExtras.putInt("INSIGHT_SCORE", insight_score);

        // add intimidation score
        EditText intim_box = (EditText) findViewById(R.id.intim_box);
        int intim_score = Integer.parseInt(intim_box.getText().toString());
        updatedExtras.putInt("INTIM_SCORE", intim_score);

        // add investigation score
        EditText invest_box = (EditText) findViewById(R.id.invest_box);
        int invest_score = Integer.parseInt(invest_box.getText().toString());
        updatedExtras.putInt("INVEST_SCORE", invest_score);

        // add med score
        EditText med_box = (EditText) findViewById(R.id.med_box);
        int med_score = Integer.parseInt(med_box.getText().toString());
        updatedExtras.putInt("MED_SCORE", med_score);

        // add nature score
        EditText nature_box = (EditText) findViewById(R.id.nature_box);
        int nature_score = Integer.parseInt(nature_box.getText().toString());
        updatedExtras.putInt("NATURE_SCORE", nature_score);

        // add perception score
        EditText perception_box = (EditText) findViewById(R.id.perception_box);
        int perception_score = Integer.parseInt(perception_box.getText().toString());
        updatedExtras.putInt("PERCEPTION_SCORE", perception_score);

        // add performance score
        EditText performance_box = (EditText) findViewById(R.id.perform_box);
        int performance_score = Integer.parseInt(performance_box.getText().toString());
        updatedExtras.putInt("PERFORM_SCORE", performance_score);

        // add persuasion score
        EditText persuasion_box = (EditText) findViewById(R.id.persuasion_box);
        int persuasion_score = Integer.parseInt(persuasion_box.getText().toString());
        updatedExtras.putInt("PERSUASION_SCORE", persuasion_score);

        // add religion score
        EditText religion_box = (EditText) findViewById(R.id.religion_box);
        int religion_score = Integer.parseInt(religion_box.getText().toString());
        updatedExtras.putInt("RELIGION_SCORE", religion_score);

        // add sleight score
        EditText sleight_box = (EditText) findViewById(R.id.sleight_box);
        int sleight_score = Integer.parseInt(sleight_box.getText().toString());
        updatedExtras.putInt("SLEIGHT_SCORE", sleight_score);

        // add stealth score
        EditText stealth_box = (EditText) findViewById(R.id.stealth_box);
        int stealth_score = Integer.parseInt(stealth_box.getText().toString());
        updatedExtras.putInt("STEALTH_SCORE", stealth_score);

        // add survival score
        EditText survival_box = (EditText) findViewById(R.id.survival_box);
        int survival_score = Integer.parseInt(survival_box.getText().toString());
        updatedExtras.putInt("SURVIVAL_SCORE", survival_score);

        intent.putExtras(updatedExtras);

        startActivity(intent);
    }
}
