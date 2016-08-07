package com.example.mikieandnicky.reciperealizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mikie and Nicky on 8/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "recipes.db";
    public static final String TABLE_NAME = "recipes_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Ingredient1";
    public static final String COL_4 = "Ingredient2";
    public static final String COL_5 = "Ingredient3";
    public static final String COL_6 = "Ingredient4";
    public static final String COL_7 = "Ingredient5";
    public static final String COL_8 = "Ingredient6";
    public static final String COL_9 = "Ingredient7";
    public static final String COL_10 = "Ingredient8";
    public static final String COL_11 = "Ingredient9";
    public static final String COL_12 = "Ingredient10";
    public static final String COL_13 = "Ingredient11";
    public static final String COL_14 = "Ingredient12";
    public static final String COL_15 = "Ingredient13";
    public static final String COL_16 = "Ingredient14";
    public static final String COL_17 = "Ingredient15";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "Ingredient1 TEXT," +
                "Ingredient2 TEXT," +
                "Ingredient3 TEXT," +
                "Ingredient4 TEXT," +
                "Ingredient5 TEXT," +
                "Ingredient6 TEXT," +
                "Ingredient7 TEXT," +
                "Ingredient8 TEXT," +
                "Ingredient9 TEXT," +
                "Ingredient10 TEXT," +
                "Ingredient11 TEXT," +
                "Ingredient12 TEXT," +
                "Ingredient13 TEXT," +
                "Ingredient14 TEXT," +
                "Ingredient15 TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);

    }

    public boolean insert_recipe(String name, String in1, String in2, String in3, String in4,
                                 String in5, String in6, String in7, String in8, String in9,
                                 String in10, String in11, String in12, String in13, String in14,
                                 String in15) {
        SQLiteDatabase db = this.getWritableDatabase(); // Open our database in a writable mode
        ContentValues contentValues = new ContentValues(); // Make a container to hold our values
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, in1);
        contentValues.put(COL_4, in2);
        contentValues.put(COL_5, in3);
        contentValues.put(COL_6, in4);
        contentValues.put(COL_7, in5);
        contentValues.put(COL_8, in6);
        contentValues.put(COL_9, in7);
        contentValues.put(COL_10, in8);
        contentValues.put(COL_11, in9);
        contentValues.put(COL_12, in10);
        contentValues.put(COL_13, in11);
        contentValues.put(COL_14, in12);
        contentValues.put(COL_15, in13);
        contentValues.put(COL_16, in14);
        contentValues.put(COL_17, in15);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return (result != -1); // the result is not equal to -1, return true
    }
}
