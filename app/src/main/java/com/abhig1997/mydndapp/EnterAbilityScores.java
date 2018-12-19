package com.abhig1997.mydndapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EnterAbilityScores extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_ability_scores);
    }

    public void getExtras() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            this.extras = extras;
        }
    }
}
