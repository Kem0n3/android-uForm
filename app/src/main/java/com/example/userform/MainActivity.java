package com.example.userform;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
//    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private CheckBox agreementCheckBox;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
//        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        agreementCheckBox = findViewById(R.id.agreementCheckBox);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    String name = nameEditText.getText().toString();
                    String email = emailEditText.getText().toString();
                    String gender = maleRadioButton.isChecked() ? "Male" : "Female";
                    boolean hasAgreed = agreementCheckBox.isChecked();

                    Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                    intent.putExtra("NAME", name);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("GENDER", gender);
                    intent.putExtra("AGREEMENT", String.valueOf(hasAgreed));
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateForm() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        boolean isGenderSelected = maleRadioButton.isChecked() || femaleRadioButton.isChecked();
        boolean isAgreementChecked = agreementCheckBox.isChecked();

        if (name.isEmpty()) {
            showToast("Name field cannot be empty");
            return false;
        }
        if (email.isEmpty()) {
            showToast("Email field cannot be empty");
            return false;
        }
        if (!isGenderSelected) {
            showToast("Please select a gender");
            return false;
        }
        if (!isAgreementChecked) {
            showToast("Please accept the agreement");
            return false;
        }
        return true;
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}