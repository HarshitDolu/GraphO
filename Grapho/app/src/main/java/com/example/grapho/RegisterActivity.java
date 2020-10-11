package com.example.grapho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText mname;
    private EditText mEmail;
    private EditText mPass;
    private Button rbtn;
    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);
        registration();

    }

    private void registration() {
        mname=findViewById(R.id.name);
        mEmail=findViewById(R.id.email);
        mPass=findViewById(R.id.pass);
        rbtn=findViewById(R.id.rrbtn);
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mname.getText().toString().trim();
                String email=mEmail.getText().toString().trim();
                String pass=mPass.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    mname.setError("user name required");
                    return;
                }

                if(TextUtils.isEmpty(email)) {
                    mEmail.setError("Email Required..");
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    mPass.setError("password required..");

                }
                mDialog.setMessage("Processing..");
                mDialog.show();
                auth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    mDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    finish();

                                }
                                else{
                                    mDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });



            }
        });








    }
}