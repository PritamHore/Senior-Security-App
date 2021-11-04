package com.example.security_app;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtnm;
    EditText edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void LogIn(View view){
        Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show();
    }

    public void Sign_Up(View v){
        Intent intent = new Intent(this, Sign_Up.class);
        startActivity(intent);
        finish();
    }
}