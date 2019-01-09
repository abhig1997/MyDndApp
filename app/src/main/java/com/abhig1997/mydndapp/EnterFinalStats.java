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
        EditText ac_box = (EditText) findViewById(R.id.ac_box);
        int ac_score = Integer.parseInt(ac_box.getText().toString());
        updatedExtras.putInt("ARMOR_CLASS", ac_score);

        // add gold amount
        EditText gold_box = (EditText) findViewById(R.id.goldInput);
        int gold_amount = Integer.parseInt(gold_box.getText().toString());
        updatedExtras.putInt("GOLD", gold_amount);

        // add silver amount
        EditText silver_box = (EditText) findViewById(R.id.silverInput);
        int silver_amount = Integer.parseInt(silver_box.getText().toString());
        updatedExtras.putInt("SILVER", silver_amount);

        // add copper amount
        EditText copper_box = (EditText) findViewById(R.id.copperInput);
        int copper_amount = Integer.parseInt(copper_box.getText().toString());
        updatedExtras.putInt("COPPER", copper_amount);

        // add initiative
        EditText initBox = (EditText) findViewById(R.id.initiativeDisplay);
        int initiative = Integer.parseInt(initBox.getText().toString());
        updatedExtras.putInt("INITIATIVE", initiative);

        // add speed
        EditText speedBox = (EditText) findViewById(R.id.speedDisplay);
        int speed = Integer.parseInt(speedBox.getText().toString());
        updatedExtras.putInt("SPEED", speed);

        intent.putExtras(updatedExtras);

        startActivity(intent);
    }
}
