package com.example.samira.neurobooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.samira.neurobooster.controller.questionDAO;
import com.example.samira.neurobooster.controller.questioninput;
import com.example.samira.neurobooster.controller.userDAO;
import com.example.samira.neurobooster.model.Question;
import com.example.samira.neurobooster.model.user;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    questioninput TempQuestioninput =new questioninput(this);
    //userDAO userdao =new userDAO(this);
    questionDAO questiondao =new questionDAO(this);
    //List<Question> quesList = new ArrayList<Question>();
    //List<user> userList = new ArrayList<user>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questiondao.deleteAll();
        //userdao.deleteAll();
        TempQuestioninput.addAllQuestion2();
//        quesList=questiondao.getQuestionsRelCat("Maths");
//        quesList.size();
//        Log.d("q size  ",quesList.size()+"");


//        userdao.addUser(new user(1,"chamin",35,"12:23"));
//        userList= userdao.getAllusers();
//        Log.d("u size  ",userList.size()+"");
    }




    public void btnPlayClick(View view) {

        //Toast.makeText(this, "Enter a Fill up details", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);



    }

    public void onExit(View view) {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onStat(View view) {

        Intent intent = new Intent(this, Stat.class);
        startActivity(intent);

    }
}
