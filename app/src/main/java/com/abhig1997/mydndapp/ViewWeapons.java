package com.abhig1997.mydndapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ViewWeapons extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weapons);

        // toolbar stuff
        Toolbar myToolbar = (Toolbar) findViewById(R.id.view_weapons_toolbar);
        setSupportActionBar(myToolbar);


        // set extras
        this.extras = getIntent().getExtras();
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
                goToInventoryView();
                return true;

            case R.id.proficiencies:
                goToProficienciesView();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToProficienciesView() {
        Intent intent = new Intent(this, ViewProficiencies.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    private void goToInventoryView() {
        Intent intent = new Intent(this, ViewInventory.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }

    private void goToCharacterView() {
        Intent intent = new Intent(this, CharacterView.class);
        intent.putExtras(this.extras);
        startActivity(intent);
    }
}
