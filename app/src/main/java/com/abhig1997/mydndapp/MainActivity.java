package com.abhig1997.mydndapp;

//import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // try to hide the status bar on the login screen
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        // hide the action bar on the login screen
        ActionBar ab = getSupportActionBar();
        ab.hide();

        setContentView(R.layout.activity_main);

    }

    /**
     * Called when the user taps the Create Account button
     */
    public void createAccount(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the Submit button
     */
    public void submit(View view) {

    }
}
