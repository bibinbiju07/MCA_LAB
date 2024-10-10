package com.example.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword, editTextConfirmPassword;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCountry;
    private CheckBox checkBoxTerms;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Proceed with sign-up logic (e.g., store user data or send it to a server)
                    Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInputs() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Validate Name
        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Name is required");
            return false;
        }

        // Validate Email
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Valid email is required");
            return false;
        }

        // Validate Phone
        if (TextUtils.isEmpty(phone) || phone.length() < 10) {
            editTextPhone.setError("Valid phone number is required");
            return false;
        }

        // Validate Password
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            editTextPassword.setError("Password must be at least 6 characters");
            return false;
        }

        // Validate Confirm Password
        if (TextUtils.isEmpty(confirmPassword)) {
            editTextConfirmPassword.setError("Confirming your password is required");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            editTextConfirmPassword.setError("Passwords do not match");
            return false;
        }

        // Validate Gender
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Gender selection is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate Country
        if (spinnerCountry.getSelectedItemPosition() == 0) { // Assuming the first item is "Select Country" or similar
            Toast.makeText(this, "Country selection is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate Terms and Conditions
        if (!checkBoxTerms.isChecked()) {
            Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}