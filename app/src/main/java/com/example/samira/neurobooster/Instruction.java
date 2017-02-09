package com.example.samira.neurobooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
    }


    public void btnInsPlayClick(View view) {
        String category=getIntent().getExtras().getString("category");



        Intent intent = new Intent(this, QuestionViewer.class);
        intent.putExtra("category",category);
        startActivity(intent);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);

    }
}
