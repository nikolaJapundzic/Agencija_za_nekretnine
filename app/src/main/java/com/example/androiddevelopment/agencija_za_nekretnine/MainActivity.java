package com.example.androiddevelopment.agencija_za_nekretnine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---------------------------------------Tooblbar---------------------------------------------

//-------------------- kreiranje linije--------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Nekretnine");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
    }
//-------------------- kreiranje linije--------------------

    //-------------------- pozivanje novog .xml itema iz meni foldera konkretno, preuzimanje i nalepljivanje digmica u toolbar--------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_item_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }
//-------------------- pozivanje novog .xml itema iz meni foldera konkretno, preuzimanje i nalepljivanje digmica u toolbar--------------------

    //-------------------- Klikabilnost itema novo ubacenih u toolbar--------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                //refresh();
                break;
            case R.id.action_add:
                //addItem();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
//-------------------- Klikabilnost itema novo ubacenih u toolbar--------------------

//---------------------------------------Tooblbar---------------------------------------------
}
