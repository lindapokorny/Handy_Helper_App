package com.pursuit.handy_helper_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class JobDataBase extends SQLiteOpenHelper {
    private static JobDataBase jobDataBaseInstance;
    private static final String TABLE_NAME = "Jobs";
    private static final String DATABASE_NAME = "Jobs.db";
    private static final int SCHEMA_VERSION = 1;
    private static Context context;
    private JobDataBase db;


    private JobDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    public static synchronized JobDataBase getInstance() {
        if (jobDataBaseInstance == null) {
            jobDataBaseInstance = new JobDataBase(context.getApplicationContext());
        }
        return jobDataBaseInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "address TEXT, date TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addJob(Job job) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE address =" +
                job.getAddress() + " AND message =" + job.getDate() + ";", null);
        if (cursor.getCount() == 0) {
        }

    }
}