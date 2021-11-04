package com.example.security_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Sign_Up extends AppCompatActivity {

    EditText edtnm;
    EditText edtpass;
    EditText confpass;
    EditText edtemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        edtnm =(EditText) findViewById(R.id.UserName);
        edtpass = (EditText) findViewById(R.id.UserPassword);
        confpass = (EditText) findViewById(R.id.ConfirmUserPassword);
        edtemail = (EditText) findViewById(R.id.UserEmail);
    }


    public static Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

    public void Sign_In(View view){
        String name ="";
        String pass ="";
        String confirm = "";
        String email = "";
        name = edtnm.getText().toString();
        pass = edtpass.getText().toString();
        confirm = confpass.getText().toString();
        email = edtemail.getText().toString();
        if(!name.isEmpty() && !pass.isEmpty() && !confirm.isEmpty() && !email.isEmpty()){
            if(pass.equals(confirm)){

                if(!EMAIL_ADDRESS_PATTERN.matcher(email).matches()){

                    startActivity(new Intent(this,MainActivity.class));
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }
                else{
                    edtemail.setError("Enter valid email!");
                }
            }
            else{
                confpass.setError("Password dose not matched!");
            }
        }
        else{
            if(name.isEmpty()){
                edtnm.setError("Please enter name");
            }
            else if(email.isEmpty()){
                edtemail.setError("Please enter a valid email");
            }
            else if(pass.isEmpty()){
                edtpass.setError("Please enter a password");
            }
        }
    }

}