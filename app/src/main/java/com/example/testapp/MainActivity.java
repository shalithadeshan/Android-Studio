package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Shali";
    Button button,button2,sendmail;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        button = findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = findViewById(R.id.txt_hello);
                text.setText("Welcome Shalitha");
            }
        });


        final Intent intent = new Intent(this,Activity2.class);

        String name = "Shalitha Deshan Jayasekara";
        int age = 22;

    /*    intent.putExtra("USER_NAME",name);
        intent.putExtra("USER_AGE",age);*/

        Bundle extras = new Bundle();
        extras.putString("USER_NAME",name);
        extras.putInt("USER_AGE",age);

        intent.putExtras(extras);

        button2 = findViewById(R.id.btnNext);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getApplicationContext(),Activity2.class);
                startActivity(intent);
            }
        });


        //implicit intent

        Intent ii = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        ii.setData(Uri.parse("mailto"));
        ii.putExtra(Intent.EXTRA_EMAIL, new String[]{"shalithad8520jayasekara@gmail.com"});
        ii.putExtra(Intent.EXTRA_SUBJECT, "This is our test subject");
        ii.putExtra(Intent.EXTRA_TEXT,"This is out test email body");
        ii.setType("message/rfc822");
        chooser = Intent.createChooser(ii,"Send email test app");

        sendmail = findViewById(R.id.btnEmail);

        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(chooser);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
    }

    @Override
   protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
       super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }
}