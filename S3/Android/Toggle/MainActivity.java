package com.example.toggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private Button buttonToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        buttonToggle = findViewById(R.id.buttonToggle);

        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImages();
            }
        });
    }

    private void toggleImages() {
        if (imageView1.getVisibility() == View.VISIBLE) {
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
        } else {
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
        }
    }
}
