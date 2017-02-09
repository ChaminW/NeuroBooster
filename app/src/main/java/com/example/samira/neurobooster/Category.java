package com.example.samira.neurobooster;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {
    private static String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }



    public void btnLogicClick(View view) {
        category = "Logic";
        instructionActivityOpener(category);

    }

    public void btnScienceClick(View view) {
        category ="Science";
        instructionActivityOpener(category);
    }

    public void btnMathsClick(View view) {
        category ="Maths";
        instructionActivityOpener(category);
    }

    public void btnGeneralClick(View view) {
        category ="General";
        instructionActivityOpener(category);
    }

    public void btnComputerClick(View view) {
        category ="Computer";
        instructionActivityOpener(category);
    }

    private void instructionActivityOpener(String category){

        Intent intent = new Intent(this, Instruction.class);
        intent.putExtra("category",category);
        startActivity(intent);



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}
