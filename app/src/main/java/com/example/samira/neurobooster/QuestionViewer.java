package com.example.samira.neurobooster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samira.neurobooster.controller.questionDAO;
import com.example.samira.neurobooster.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class QuestionViewer extends AppCompatActivity {

    private TextView textViewCategory;
    private TextView textViewCoutDown;
    private TextView textViewQues;
    private TextView textViewOpt1;
    private TextView textViewOpt2;
    private TextView textViewOpt3;
    private TextView textViewOpt4;

    private int marks = 0;
    int sec;
    int min;
    private RadioGroup radioGroup;


    private String answer ="1";
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String optD;


    List<Question> quesList = new ArrayList<Question>();
    Question tempQuestion;



    private int count=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_viewer);

        String category = getIntent().getExtras().getString("category");
        (this).getSupportActionBar().setTitle(
                category);


        questiondao =new questionDAO(this);
        quesList = questiondao.getQuestionsRelCat(category);
        Collections.shuffle(quesList);
        tempQuestion = quesList.get(count-1);





        textViewCategory = (TextView) findViewById(R.id.categoryText);
        textViewQues = (TextView) findViewById(R.id.TextViewQuestion);
        textViewOpt1 = (TextView) findViewById(R.id.TextViewOptionA);
        textViewOpt2 = (TextView) findViewById(R.id.TextViewOptionB);
        textViewOpt3 = (TextView) findViewById(R.id.TextViewOptionC);
        textViewOpt4 = (TextView) findViewById(R.id.TextViewOptionD);

        textViewCategory.setText(count+"/39");

        setQuestion(tempQuestion);



        coutDown();
    }

    private void setQuestion(Question tempQuestion) {



//*****************************************************************************************
//        answer = "1";
//        question="12+2?";
//        optA="12";
//        optB="14";
//        optC="13";
//        optD= "123";
        textViewCategory.setText(count+"/39");

        textViewQues.setText("Question ("+count+") \n"+tempQuestion.getQuestion());
        textViewOpt1.setText("(a) "+tempQuestion.getOpta());
        textViewOpt2.setText("(b) "+tempQuestion.getOptb());
        textViewOpt3.setText("(c) "+tempQuestion.getOptc());
        textViewOpt4.setText("(d) "+tempQuestion.getOptd());

        //Toast.makeText(this, tempQuestion.getAnswer(), Toast.LENGTH_SHORT).show();
        count++;
//*******************************************************************************************
    }


    private void coutDown() {

        textViewCoutDown = (TextView) findViewById(R.id.countDownText);
        new CountDownTimer(60000 * 40, 1000) {

            public void onTick(long millisUntilFinished) {
                long totSec = (millisUntilFinished / 1000 );
                sec = (int) (totSec%60);
                min = (int) (totSec/60);

                textViewCoutDown.setText("Remain- Min: "+min+" Sec: "+sec) ;
            }

            public void onFinish() {
                textViewCoutDown.setText("done!");

                goToEnd();

            }
        }.start();
    }


    public void btnNextClick(View view) {

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        if (radioGroup.getCheckedRadioButtonId() == -1) {

            //answer=tempQuestion.getAnswer();
            //Log.d("answer **********",answer+"      ************************");

            //do nothing.Nothing is checked
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.radio_a && (tempQuestion.getAnswer().equals("1"))) {
            //Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
            marks++;

        } else if (radioGroup.getCheckedRadioButtonId() == R.id.radio_b && (tempQuestion.getAnswer().equals("2"))) {
            //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
            marks++;

        } else if (radioGroup.getCheckedRadioButtonId() == R.id.radio_c && (tempQuestion.getAnswer().equals("2"))) {
            //Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
            marks++;

        } else if (radioGroup.getCheckedRadioButtonId() == R.id.radio_d && (tempQuestion.getAnswer().equals("2"))) {
            //Toast.makeText(this, "D", Toast.LENGTH_SHORT).show();
            marks++;

        } else {
            //do nothing
        }



        if(count>39){
            goToEnd();

        }else {
            tempQuestion = quesList.get(count-1);
            setQuestion(tempQuestion);

        }
        radioGroup.clearCheck();

    }




    public void btnExitClick(View view) {

        warning();


    }

    public void warning() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
// Add the buttons
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                goToEnd();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
// Set other dialog properties
        builder.setMessage("Do you want to exit?")
                .setTitle("Exit");


// Create the AlertDialog
        AlertDialog dialog = builder.create();

        dialog.show();

    }

    private void goToEnd(){


        int[] intArray= {marks,39-min,60-sec};
        Intent intent = new Intent(QuestionViewer.this, End.class);
        intent.putExtra("intArray", intArray);
        startActivity(intent);
        finish();

    }


    @Override
    public void onBackPressed() {
        warning();
    }




}
