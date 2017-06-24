package com.example.androiddevelopment.agencija_za_nekretnine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.androiddevelopment.agencija_za_nekretnine.model.Nekretnina;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by nikola on 23.6.17..
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "ormlite.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<Nekretnina, Integer> mNekretninaDao = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Nekretnina.class);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            TableUtils.dropTable(connectionSource, Nekretnina.class, true);
            onCreate(db, connectionSource);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Dao<Nekretnina, Integer> getNekretninaDao() throws SQLException {
        if(mNekretninaDao == null){
            mNekretninaDao = getDao(Nekretnina.class);
        }
        return mNekretninaDao;
    }

    @Override
    public  void close(){
        mNekretninaDao = null;
        super.close();
    }

}
