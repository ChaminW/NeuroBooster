package com.example.samira.neurobooster.controller;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samira on 5/25/16.
 */
public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "iq";
    // tasks table name
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

    private static final String TABLE_STAT = "stat";
    // tasks Table Columns names
    private static final String STAT_ID = "id";
    private static final String STAT_NAME = "name"; // name
    private static final String STAT_SCORE= "score"; // score
    private static final String STAT_TIME = "time"; // time

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
//IF NOT EXISTS
        String question_query = "CREATE TABLE  " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_CATEGORY + " TEXT, "+ KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, "+ KEY_OPTD + " TEXT)";
        db.execSQL(question_query);

        dbase = db;

        String stat_query  = "CREATE TABLE " + TABLE_STAT + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STAT_NAME
                + " TEXT, " + STAT_SCORE + " INTEGER, " + STAT_TIME + " TEXT)";
        db.execSQL(stat_query);






        //addQuestion();
//db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAT);
// Create tables again
        onCreate(db);
    }
//    // Adding new question
//    public void addQuestion(Question quest) {
//// SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();

//        values.put(KEY_QUES, quest.getQUESTION());
//        values.put(KEY_ANSWER, quest.getANSWER());
//        values.put(KEY_OPTA, quest.getOPTA());
//        values.put(KEY_OPTB, quest.getOPTB());
//        values.put(KEY_OPTC, quest.getOPTC());
//// Inserting Row
//        dbase.insert(TABLE_QUEST, null, values);
//    }
//    public List<Question> getAllQuestions() {
//        List<Question> quesList = new ArrayList<Question>();
//// Select All Query
//        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
//        dbase = this.getReadableDatabase();
//        Cursor cursor = dbase.rawQuery(selectQuery, null);
//// looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Question quest = new Question();
//                quest.setID(cursor.getInt(0));
//                quest.setQUESTION(cursor.getString(1));
//                quest.setANSWER(cursor.getString(2));
//                quest.setOPTA(cursor.getString(3));
//                quest.setOPTB(cursor.getString(4));
//                quest.setOPTC(cursor.getString(5));
//                quesList.add(quest);
//            } while (cursor.moveToNext());
//        }
//// return quest list
//        return quesList;
//    }
}
