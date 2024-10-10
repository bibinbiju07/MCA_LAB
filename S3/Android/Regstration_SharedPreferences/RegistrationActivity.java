package com.example.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword;
    private RadioGroup radioGroupGender;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButtonGender = findViewById(selectedGenderId);
        String gender = radioButtonGender != null ? radioButtonGender.getText().toString() : "";

        // Basic validation
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save user details in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("gender", gender);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

        // Optionally, navigate to another activity
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}

