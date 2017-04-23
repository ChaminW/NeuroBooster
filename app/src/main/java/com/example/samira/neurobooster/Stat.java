package com.example.samira.neurobooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samira.neurobooster.controller.userDAO;
import com.example.samira.neurobooster.model.user;

import java.util.ArrayList;
import java.util.List;

public class Stat extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listView;
    userDAO userdao;
    List<user> UserList;

    String[] NameArray ;

    String[] ScoreArray ;

    String[] TimeArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        userdao =new userDAO(this);

        UserList = userdao.getAllusers();

        NameArray =new String[UserList.size()];
        ScoreArray =new String[UserList.size()];
        TimeArray =new String[UserList.size()];

        fillArrays();

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, NameArray);
        listView = (ListView) findViewById(R.id.listViewName);
        listView.setAdapter(adapter);
        listView.setScrollContainer(false);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, ScoreArray );
        listView = (ListView) findViewById(R.id.listViewScore);
        listView.setAdapter(adapter);
        listView.setScrollContainer(false);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, TimeArray );
        listView = (ListView) findViewById(R.id.listViewTime);
        listView.setAdapter(adapter);
        listView.setScrollContainer(false);


    }

    private void fillArrays() {

        for (int i=0;i<UserList.size();i++){
            NameArray[i]=UserList.get(i).getName();
            ScoreArray[i]=String.valueOf(UserList.get(i).getScore());
            TimeArray[i]=UserList.get(i).getTime();

        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}
