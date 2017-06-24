package com.example.androiddevelopment.agencija_za_nekretnine.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static com.example.androiddevelopment.agencija_za_nekretnine.model.Nekretnina.POLJE_KVADRATURA;

/**
 * Created by androiddevelopment on 24.6.17..
 */

@DatabaseTable(tableName = "nekretnina")
public class Nekretnina {
    public static final String POLJE_ID = "id";
    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_KVADRATURA = "kvadratura";
    public static final String POLJE_BROJSOBA = "broj soba";
    public static final String POLJE_BROJTELEFONA = "broj telefona";
    public static final String POLJE_ADRESA = "adresa";
    public static final String POLJE_CENA = "cena";

    @DatabaseField(columnName = POLJE_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = POLJE_NAZIV)
    private String mNaziv;

    @DatabaseField(columnName = POLJE_KVADRATURA)
    private String mKvadratura;

    @DatabaseField(columnName = POLJE_BROJSOBA)
    private String mBrojsoba;

    @DatabaseField(columnName = POLJE_BROJTELEFONA)
    private String mBrojtelefona;

    @DatabaseField(columnName = POLJE_ADRESA)
    private String mAdresa;

    @DatabaseField(columnName = POLJE_CENA)
    private String mCena;


    public Nekretnina(){

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNaziv() {
        return mNaziv;
    }

    public void setmNaziv(String mNaziv) {
        this.mNaziv = mNaziv;
    }

    public String getmKvadratura() {
        return mKvadratura;
    }

    public void setmKvadratura(String mKvadratura) {
        this.mKvadratura = mKvadratura;
    }

    public String getmBrojsoba() {
        return mBrojsoba;
    }

    public void setmBrojsoba(String mBrojsoba) {
        this.mBrojsoba = mBrojsoba;
    }

    public String getmBrojtelefona() {
        return mBrojtelefona;
    }

    public void setmBrojtelefona(String mBrojtelefona) {
        this.mBrojtelefona = mBrojtelefona;
    }

    public String getmAdresa() {
        return mAdresa;
    }

    public void setmAdresa(String mAdresa) {
        this.mAdresa = mAdresa;
    }

    public String getmCena() {
        return mCena;
    }

    public void setmCena(String mCena) {
        this.mCena = mCena;
    }

    @Override
    public String toString() {
        return mNaziv;
    }
}
