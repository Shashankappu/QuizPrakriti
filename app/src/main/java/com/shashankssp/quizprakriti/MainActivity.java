package com.shashankssp.quizprakriti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editName,editAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_btn = findViewById(R.id.start_btn);
        EditText editName = findViewById(R.id.editName);
        EditText editAge = findViewById(R.id.editAge);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,QuestionsActivity.class);
                i.putExtra("name",editName.getText().toString());
                i.putExtra("age",editAge.getText().toString());
                startActivity(i);
            }
        });
    }
}