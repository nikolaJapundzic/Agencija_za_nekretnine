package com.example.androiddevelopment.agencija_za_nekretnine;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            case R.id.action_add:
                Toast.makeText(this, "Product inserted", Toast.LENGTH_SHORT).show();
                alert();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
//-------------------- Klikabilnost itema novo ubacenih u toolbar--------------------

//---------------------------------------Tooblbar---------------------------------------------

    public void alert(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_unos_nove, null);
        final EditText et_naziv = (EditText) mView.findViewById(R.id.et_naziv);
        final EditText et_kvadratura = (EditText) mView.findViewById(R.id.et_kvadratura);
        final EditText et_broj_soba = (EditText) mView.findViewById(R.id.et_broj_soba);
        final EditText et_broj_telefona = (EditText) mView.findViewById(R.id.et_broj_telefona);
        final EditText et_adresa = (EditText) mView.findViewById(R.id.et_adresa);
        final EditText et_cena = (EditText) mView.findViewById(R.id.et_cena);
        Button btn_save = (Button) mView.findViewById(R.id.btn_save);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
