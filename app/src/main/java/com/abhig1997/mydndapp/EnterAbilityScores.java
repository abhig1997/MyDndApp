package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterAbilityScores extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_ability_scores);
    }

    public Bundle getExtras() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            this.extras = extras;
            return extras;
        }
        return null;
    }

    public void enterSkillScores(View view) {
        Intent intent = new Intent(this, EnterSkillScores.class);
//        Bundle extras = new Bundle();


//        getExtras();
        Bundle updatedExtras = getExtras();

        // add the strength score to the bundle that was passed in from the class before
        EditText strength_box = (EditText) findViewById(R.id.strength_score_box);
        int strength_score = Integer.parseInt(strength_box.getText().toString());
        updatedExtras.putInt("STRENGTH_SCORE", strength_score);

        // add the dex score
        EditText dex_box = (EditText) findViewById(R.id.dex_score_box);
        int dex_score = Integer.parseInt(dex_box.getText().toString());
        updatedExtras.putInt("DEX_SCORE", dex_score);

        // add the constitution score
        EditText const_box = (EditText) findViewById(R.id.const_box);
        int const_score = Integer.parseInt(const_box.getText().toString());
        updatedExtras.putInt("CONST_SCORE", const_score);


        // add the intelligence score
        EditText int_score_box = (EditText) findViewById(R.id.int_box);
        int int_score = Integer.parseInt(int_score_box.getText().toString());
        updatedExtras.putInt("INTELLIGENCE_SCORE", int_score);

        // add the wisdom score
        EditText wisdom_box = (EditText) findViewById(R.id.wisdom_box);
        int wis_score = Integer.parseInt(wisdom_box.getText().toString());
        updatedExtras.putInt("WISDOM_SCORE", wis_score);

        // add the charisma score
        EditText charisma_box = (EditText) findViewById(R.id.charisma_box);
        int cha_score = Integer.parseInt(charisma_box.getText().toString());
        updatedExtras.putInt("CHARISMA_SCORE", cha_score);

        intent.putExtras(updatedExtras);

        startActivity(intent);
    }
}
