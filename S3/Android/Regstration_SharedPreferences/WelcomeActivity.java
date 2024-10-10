package com.example.registration;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textViewWelcome, textViewEmail, textViewPhone, textViewGender;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewGender = findViewById(R.id.textViewGender);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Retrieve user details from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "User");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");
        String gender = sharedPreferences.getString("gender", "");

        textViewWelcome.setText("Welcome, " + name + "!");
        textViewEmail.setText("Email: " + email);
        textViewPhone.setText("Phone: " + phone);
        textViewGender.setText("Gender: " + gender);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action (e.g., clear shared preferences and navigate to registration)
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                // Optionally, navigate back to RegistrationActivity
                finish(); // Close this activity
            }
        });
    }
}

