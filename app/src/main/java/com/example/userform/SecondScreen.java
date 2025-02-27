package com.example.userform;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity {
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView genderTextView;
    private TextView agreementTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        genderTextView = findViewById(R.id.genderTextView);
        agreementTextView = findViewById(R.id.agreementTextView);

        String name = getIntent().getStringExtra("NAME");
        String email = getIntent().getStringExtra("EMAIL");
        String gender = getIntent().getStringExtra("GENDER");
        String agreement = getIntent().getStringExtra("AGREEMENT");


        nameTextView.setText("My name is : " + name);
        emailTextView.setText("My email is : " + email);
        genderTextView.setText("Gender: " + gender);
        agreementTextView.setText("Has checked agreement?: " + agreement);
    }
}