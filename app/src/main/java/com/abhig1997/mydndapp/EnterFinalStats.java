package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterFinalStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_final_stats);
    }

    public void submitFinalStats(View view) {
        Intent intent = new Intent(this, CharacterView.class); // create the intent
                                                                        // for the next screen

        Bundle updatedExtras = getIntent().getExtras(); // need the bundle to update it with
                                                        // new info

        // add the final stats
        EditText hp_box = (EditText) findViewById(R.id.hp_box);
        int hp_score = Integer.parseInt(hp_box.getText().toString());
        updatedExtras.putInt("HIT_POINTS", hp_score);


        intent.putExtras(updatedExtras);

        startActivity(intent);
    }
}
