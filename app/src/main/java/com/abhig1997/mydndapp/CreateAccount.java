package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar ab = getSupportActionBar();
        ab.hide();

        setContentView(R.layout.activity_create_account);
    }

    /**
     * Called when the user taps the submit button
     * Should store the created user and go back to the main screen
     * @param view
     */
    public void submit(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        EditText usernameField = (EditText) findViewById(R.id.createAccountEnterUsername);
        String username = usernameField.getText().toString();

        // extract the password that was entered
        EditText passwordField = (EditText) findViewById(R.id.createAccountEnterPassword);
        String password = passwordField.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // check to make sure the user entered a value for the username
        if (username.length() == 0) {
            builder.setMessage("Please enter a value for the username");
            builder.setTitle("Invalid username");
            builder.setPositiveButton("OK", null);
            builder.setCancelable(true);
            builder.create().show();
        }
        else if (password.length() == 0) {
            builder.setMessage("Please enter a value for the password");
            builder.setTitle("Invalid password");
            builder.setPositiveButton("OK", null);
            builder.setCancelable(true);
            builder.create().show();
        }
        else {
            startActivity(intent);
        }
    }


}
