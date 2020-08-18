package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView txtUser_name,txtUser_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtUser_name = findViewById(R.id.txtUserName);
        txtUser_age = findViewById(R.id.txtUserAge);

        Intent intent = getIntent();
     /*   String name = intent.getStringExtra("USER_NAME");
        int age = intent.getIntExtra("USER_AGE", 0);*/

        Bundle extras = intent.getExtras();

        String name = extras.getString("USER_NAME");
        int age = extras.getInt("USER_AGE");

        txtUser_name.setText(name);
        txtUser_age.setText(String.valueOf(age));

    }

    public void ActivityTwo(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}