package com.shashankssp.quizprakriti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;


public class QuestionsActivity extends AppCompatActivity {
    private Button restart_btn;
    private RelativeLayout main_rl;
    private LinearLayout finished_ll;
    TextView questions_num_tv,questions_tv,username_tv,result_tv;
    RadioGroup answers_radiogrp;
    RadioButton choice1,choice2,choice3;
    int index = 0;
    Boolean isCompleted = false;
    ArrayList<ArrayList<String>> opt = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questions.add("Which method can be defined only once in a program?");
        questions.add("Which of these is not a bitwise operator?");
        questions.add("Which keyword is used by method to refer to the object that invoked it?");
        questions.add("Which of these keywords is used to define interfaces in Java?");
        questions.add("Which of these access specifiers can be used for an interface?");
        questions.add("Which of the following is correct way of importing an entire package ‘pkg’?");
        questions.add("What is the return type of Constructors?");
        questions.add("Which of the following package stores all the standard java classes?");
        questions.add("Which of these method of class String is used to compare two String objects for their equality?");
        questions.add("An expression involving byte, int, & literal numbers is promoted to which of these?");

        String[][] options = {
                {"finalize method", "main method", "static method", "private method"},
                {"&", "&=", "|=", "<="},
                {"import", "this", "catch", "abstract"},
                {"Interface", "interface", "intf", "Intf"},
                {"public", "protected", "private", "All of the mentioned"},
                {"Import pkg.", "import pkg.*", "Import pkg.*", "import pkg."},
                {"int", "float", "void", "None of the mentioned"},
                {"lang", "java", "util", "java.packages"},
                {"equals()", "Equals()", "isequal()", "Isequal()"},
                {"int", "long", "byte", "float"}
        };
        for (String[] row : options) {
            opt.add(new ArrayList<>(Arrays.asList(row)));
        }

        Button next_btn = findViewById(R.id.next_btn);
        Button quit_btn = findViewById(R.id.quit_btn);
        restart_btn = findViewById(R.id.restart_btn);
        main_rl = findViewById(R.id.main_rl);
        finished_ll = findViewById(R.id.finished_ll);
        questions_tv = findViewById(R.id.questions_tv);
        questions_num_tv = findViewById(R.id.question_num_tv);
        username_tv = findViewById(R.id.username_tv);
        result_tv = findViewById(R.id.result_tv);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        answers_radiogrp = findViewById(R.id.answers_radiogrp);
        answers = new ArrayList<>();
        //init
        questions_num_tv.setText(index+1+".");
        questions_tv.setText(questions.get(index));
        choice1.setText(opt.get(index).get(0));
        choice2.setText(opt.get(index).get(1));
        choice3.setText(opt.get(index).get(2));

        String name = getIntent().getStringExtra("name");
       // String age = getIntent().getStringExtra("age");
        username_tv.setText("Hello! "+name);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answers_radiogrp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                }else{
                    RadioButton selectedAns = (RadioButton) answers_radiogrp.findViewById(answers_radiogrp.getCheckedRadioButtonId());
                    String ansText = selectedAns.getText().toString();
                    Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                    answers.add(ansText);
                    index++;
                    if(index==questions.size()) {
                        isCompleted = true;
                        setContentsVisible(true);
                    }else{
                        getNextQuestion(index);
                        isCompleted = false;
                    }
                }
            }
        });
        quit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentsVisible(false);
                onBackPressed();
                finish();
            }
        });
    }

    private void getNextQuestion(int index){
        questions_num_tv.setText(index+1+".");
        questions_tv.setText(questions.get(index));
        choice1.setText(opt.get(index).get(0));
        choice2.setText(opt.get(index).get(1));
        choice3.setText(opt.get(index).get(2));
    }
    private void setContentsVisible(Boolean isCompleted){
        if(isCompleted){
            main_rl.setVisibility(View.GONE);
            finished_ll.setVisibility(View.VISIBLE);
            for(int i=0;i<answers.size();i++){
                Log.d("thisme",answers.get(i));
            }
            restart_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i  = new Intent(QuestionsActivity.this, QuestionsActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }else{
            main_rl.setVisibility(View.VISIBLE);
            finished_ll.setVisibility(View.GONE);
        }

    }
}