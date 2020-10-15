package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t_info; // here will be displayed the string with text
    String information; // here will be stored the text
    Button one, two, three; // the three buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //...
        t_info = findViewById(R.id.text_info);
        information = getIntent().getExtras().getString("Inf");
        t_info.setText(information);
        //... getting data from previous activity and displaying in the textview
        one = findViewById(R.id.button_one);
        two = findViewById(R.id.button_two);
        three = findViewById(R.id.button_three);

        one.setOnClickListener(v -> {
            Intent intent = new Intent(); // new intent to send back data to previrous activity
            intent.putExtra("Btn", one.getText()); // btn is the key and the data is the text from the button
            setResult(RESULT_OK, intent); // send the data
            finish();
        });
        two.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("Btn", two.getText());
            setResult(RESULT_OK, intent);
            finish();
        });
        three.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("Btn", three.getText());
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}