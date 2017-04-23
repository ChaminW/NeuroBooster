package com.example.samira.neurobooster.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.samira.neurobooster.model.Question;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samira on 5/28/16.
 */
public class questionDAO extends QuizHelper {
    //SQLiteDatabase db =this.getWritableDatabase();


    public questionDAO(Context context) {
        super(context);
    }

    private static final String TABLE_QUEST = "question";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_CATEGORY = "category"; // category
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_OPTD = "optd"; // option d

    //delete all
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_QUEST);

        db.close();
    }



    // Adding new question
    public void addQuestion(Question quest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(KEY_ID, quest.getId());
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_CATEGORY, quest.getCategory());
        values.put(KEY_OPTA, quest.getOpta());
        values.put(KEY_OPTB, quest.getOptb());
        values.put(KEY_OPTC, quest.getOptc());
        values.put(KEY_OPTD, quest.getOptd());
 //Inserting Row
        db.insert(TABLE_QUEST, null, values);

//        String query = "INSERT INTO " + TABLE_QUEST + " VALUES (?,?,?,?,?,?,?,?)";
//
//
//        db.execSQL(query, new String[]{
//                String.valueOf(quest.getId()),
//                quest.getQuestion(),
//        quest.getAnswer(),
//        quest.getCategory(),
//        quest.getOpta(),
//        quest.getOptb(),
//        quest.getOptc(),
//        quest.getOptd()
//        });


        db.close();
    }

    public List<Question> getQuestionsRelCat(String category) {
        SQLiteDatabase db ;
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " WHERE CATEGORY = '" + category + "'";
       // Log.d("query",selectQuery);///////log print

        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setCategory(cursor.getString(3));
                quest.setOpta(cursor.getString(4));
                quest.setOptb(cursor.getString(5));
                quest.setOptc(cursor.getString(6));
                quest.setOptd(cursor.getString(7));





                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }

}
