package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button share;
    Button cont;
    EditText editable;
    String information;
    String response;
    TextView reply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        share = findViewById(R.id.button_share);
        cont = findViewById(R.id.button_continue);
        editable = findViewById(R.id.edittext);
        reply=findViewById(R.id.text_response);

        share.setOnClickListener(v -> {
            information = editable.getText().toString();// get the entered text
            if(information.matches(""))
            {
                Toast toast = Toast.makeText(this, "Please type something", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
            Intent intent_share= new Intent(Intent.ACTION_SEND);
            intent_share.setType("text/plain");
            intent_share.putExtra(Intent.EXTRA_TEXT,information);
            startActivity(intent_share.createChooser(intent_share,"Share using"));
            }
        });


        cont.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            information = editable.getText().toString();// get the entered text
            if(information.matches(""))
            {
                Toast toast = Toast.makeText(this, "Please type something", Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                intent.putExtra("Inf", information); // send the text
                startActivityForResult(intent, 1); // wait for response
                //finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                response = data.getExtras().getString("Btn");
                reply.setText(response);
            }
        }
    }

}