package com.example.gustavogalarreta.cocheapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button btSignIn, btRegister;
    private EditText etEmail, etPassword;
    private FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setListeners();
    }

    void setViews(){
        btSignIn = findViewById(R.id.signIn);
        btRegister = findViewById(R.id.register);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        fbAuth = FirebaseAuth.getInstance();

    }

    void setListeners(){
        btRegister.setOnClickListener( (View v) -> {
            final String email = etEmail.getText().toString();
            final String password = etPassword.getText().toString();
            fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, task -> {
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                } else {
                    String user_id = fbAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("name");
                    current_user_db.setValue(email);
                }
            });
        });

        btSignIn.setOnClickListener( (View v) -> {
            final String email = etEmail.getText().toString();
            final String password = etPassword.getText().toString();
            fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, task -> {
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "sign in error", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, CarActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            });
        });
    }
}
