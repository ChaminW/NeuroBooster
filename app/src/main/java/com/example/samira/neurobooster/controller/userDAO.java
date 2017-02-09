package com.example.samira.neurobooster.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.samira.neurobooster.model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samira on 5/28/16.
 */
public class userDAO extends QuizHelper {

    public userDAO(Context context) {
        super(context);
    }

    private static final String TABLE_STAT = "stat";
    // tasks Table Columns names
    private static final String STAT_ID = "id";
    private static final String STAT_NAME = "name"; // name
    private static final String STAT_SCORE = "score"; // score
    private static final String STAT_TIME = "time"; // time

    // Adding new user
    public void addUser(user tempuser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(STAT_ID, tempuser.getId());
        values.put(STAT_NAME, tempuser.getName());
        values.put(STAT_SCORE, tempuser.getScore());
        values.put(STAT_TIME, tempuser.getTime());

// Inserting Row
        db.insert(TABLE_STAT, null, values);
        db.close();
    }

    public List<user> getAllusers() {
        SQLiteDatabase db;
        List<user> quesList = new ArrayList<user>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_STAT;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                user tempuser = new user();
                tempuser.setId(cursor.getInt(0));
                tempuser.setName(cursor.getString(1));
                tempuser.setScore(cursor.getInt(2));
                tempuser.setTime(cursor.getString(3));
                quesList.add(tempuser);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;

    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_STAT);

        db.close();


    }
}