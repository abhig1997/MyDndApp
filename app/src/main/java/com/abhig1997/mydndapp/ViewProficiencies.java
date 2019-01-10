package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ViewProficiencies extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_proficiencies);

        // toolbar stuff
        Toolbar myToolbar = (Toolbar) findViewById(R.id.view_proficiencies_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        this.getExtras();

    }

    /**
     * Creates the options for the menu
     * @param menu
     * @return true if the menu is made successfully
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_proficiencies_menu, menu);
        return true;
    }

    /**
     * Handles the navigation of the menu in the toolbar
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.characterView:
                goToCharacterView();
                return true;
            case R.id.inventory:

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Navigates to the Character View page
     */
    public void goToCharacterView() {
        Intent intent = new Intent(this, CharacterView.class);
        this.getExtras();
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    // Sets the class variable to show any updated extras
    public void getExtras() {
        extras = getIntent().getExtras();
    }


}
