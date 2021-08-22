package com.example.socsho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import Model.Users;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private Button signup_button;
    private EditText Username_signup;
    private EditText Email_signup;
    private EditText Password_signup;
    private TextView already_account;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        auth= FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        signup_button=findViewById(R.id.signup_button);
        Username_signup=findViewById(R.id.Username);
        Email_signup=findViewById(R.id.email);
        Password_signup=findViewById(R.id.password);
        progressDialog=new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your Account");

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                auth.createUserWithEmailAndPassword(Email_signup.getText().toString(),
                        Password_signup.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                      if(task.isSuccessful())
                      {
                          Users user=new Users(Username_signup.getText().toString(),
                                  Email_signup.getText().toString(),Password_signup.getText().toString());

                          //id of current user
                          String id=task.getResult().getUser().getUid();
                          database.getReference().child("Users").child(id).setValue(user);


                          Toast.makeText(SignUpActivity.this,"User created successfully!",Toast.LENGTH_SHORT).show();
                      }

                      else
                      {
                          Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      }

                    }
                });

            }
        });

        already_account=findViewById(R.id.already_account);
        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}