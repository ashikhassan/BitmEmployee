package com.emythmakers.ashik.bitmemployee.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BITM Trainer 401 on 18/8/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static  final String DATABASE_NAME="bitm_employee_login.db";
    static  final int DATABASE_VERSSION=1;

    static  final String TABLE_CONTACT="employee_list";

    static  final String COL_ID="id";
    static  final String COL_NAME="name";
    static  final String COL_PHONENO="phoneno";
    static  final String COL_DESIGNATION="designation";

    static  final String CREATE_TABLE_CONTACT=" create table "+ TABLE_CONTACT +
            "( "+ COL_ID + " integer primary key, "+
            " "+ COL_NAME + " text, " +
            " "+ COL_PHONENO + " text, " +
            COL_DESIGNATION + " text );";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST"+ TABLE_CONTACT);
        onCreate(db);
    }
}
