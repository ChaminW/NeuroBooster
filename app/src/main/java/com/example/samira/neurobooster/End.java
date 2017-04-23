package com.example.samira.neurobooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samira.neurobooster.controller.userDAO;
import com.example.samira.neurobooster.model.user;

public class End extends AppCompatActivity {
    int[] intArray;
    Button button;
    TextView textView;
    EditText editText;
    String name;
    user tempUser;
    userDAO userdao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        intArray=this.getIntent().getExtras().getIntArray("intArray");


        textView =(TextView)findViewById(R.id.result);
        textView.setText(String.valueOf(Math.round(intArray[0]/39.00*100*100)/100)+" %");

        textView =(TextView)findViewById(R.id.time);
        textView.setText(String.valueOf(intArray[1]+":"+intArray[2]));

        userdao =new userDAO(this);


    }

    public void OnSave(View view) {
        button=(Button) findViewById(R.id.saveBtn);


        editText =(EditText) findViewById(R.id.nameEdit);
        name=editText.getText().toString();

        if(!(name==null || name=="")) {
            button.setClickable(false);
            button.setVisibility(View.INVISIBLE);
            tempUser = new user(1, name, intArray[0], intArray[1] + ":" + intArray[2]);
            userdao.addUser(tempUser);

            Toast.makeText(this, "Your marks are saved successfully", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnHomeClick(View view) {

        Intent intent = new Intent(this, Category.class);
        startActivity(intent);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }

    public void btnStatClick(View view) {

        Intent intent = new Intent(this, Stat.class);
        startActivity(intent);

    }
}
