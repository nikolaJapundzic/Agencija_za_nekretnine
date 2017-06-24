package com.example.androiddevelopment.agencija_za_nekretnine;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androiddevelopment.agencija_za_nekretnine.model.Nekretnina;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper;
    Nekretnina nekretnina;

    EditText et_naziv;
    EditText et_kvadratura;
    EditText et_broj_soba;
    EditText et_broj_telefona;
    EditText et_adresa;
    EditText et_cena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DatabaseHelper(this);



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
        Button btn_save = (Button) mView.findViewById(R.id.btn_save);

        et_naziv = (EditText) findViewById(R.id.et_naziv);
        et_kvadratura = (EditText) findViewById(R.id.et_kvadratura);
        et_broj_soba = (EditText) findViewById(R.id.et_broj_soba);
        et_broj_telefona = (EditText) findViewById(R.id.et_broj_telefona);
        et_adresa = (EditText) findViewById(R.id.et_adresa);
        et_cena = (EditText) findViewById(R.id.et_cena);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //upis();
                //celaLista();
                nekretnina = new Nekretnina();

                nekretnina.setmNaziv("");
                nekretnina.setmKvadratura("");
                nekretnina.setmBrojsoba("");
                nekretnina.setmBrojtelefona("");
                nekretnina.setmAdresa("");
                nekretnina.setmCena("");

                try {
                    getDatabaseHelper().getNekretninaDao().create(nekretnina);
                    celaLista();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void upis(){

        nekretnina = new Nekretnina();

        nekretnina.setmNaziv(et_naziv.getText().toString());
        nekretnina.setmKvadratura(et_kvadratura.getText().toString());
        nekretnina.setmBrojsoba(et_broj_soba.getText().toString());
        nekretnina.setmBrojtelefona(et_broj_telefona.getText().toString());
        nekretnina.setmAdresa(et_adresa.getText().toString());
        nekretnina.setmCena(et_cena.getText().toString());

        try {
            getDatabaseHelper().getNekretninaDao().create(nekretnina);
            celaLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void celaLista(){
        List<Nekretnina> list;
        try {

            list = getDatabaseHelper().getNekretninaDao().queryForAll();
            ListAdapter adapter = new ArrayAdapter<Nekretnina>(getApplicationContext(), R.layout.list_item, list);
            final ListView listView = (ListView) findViewById(R.id.lv_lista);
            listView.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public DatabaseHelper getDatabaseHelper() {
        if (helper == null) {
            helper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return helper;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            OpenHelperManager.releaseHelper();
            helper = null;
        }
    }






}
