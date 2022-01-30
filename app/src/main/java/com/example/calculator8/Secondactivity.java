
package com.example.calculator8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Secondactivity extends AppCompatActivity {

    private TextView resultText;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        resultText = findViewById(R.id.textView);
        button = findViewById(R.id.btnCrash);

        resultText.setText(getIntent().getStringExtra("key"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}