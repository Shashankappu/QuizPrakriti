package com.shashankssp.quizprakriti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
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
import java.util.Collections;


public class QuestionsActivity extends AppCompatActivity {
    private Button restart_btn;
    private RelativeLayout main_rl;
    private LinearLayout finished_ll;
    TextView questions_num_tv,questions_tv,username_tv,result_tv,vata_value,pitta_value,kapha_value;
    RadioGroup answers_radiogrp;
    RadioButton choice1,choice2,choice3;
    int index = 0;
    Boolean isCompleted = false;
    ArrayList<ArrayList<String>> opt = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers;
    ArrayList<Integer> userchoices;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questions.add("What is your Body frame?");
        questions.add("What is your Type of hair?");
        questions.add("What is the Color of your hair?");
        questions.add("What is your Skin type?");
        questions.add("What is your Color complexion?");
        questions.add("What is your Body weight?");
        questions.add("What is your Nails type?");
        questions.add("What is the Size and color of your teeth?");
        questions.add("What is your pace of performing work?");
        questions.add("How is your Mental Activity?");
        questions.add("How is your Memory?");
        questions.add("How is your Sleep pattern?");
        questions.add("What Weather do you dislike the most?");
        questions.add("How would be your reactions under adverse situations?");
        questions.add("How is your Mood Swings");
        questions.add("How is your Eating habits?");
        questions.add("How is your Hunger?");
        questions.add("What is your Body Temperature?");
        questions.add("How healthy is your Joints?");
        questions.add("How is your Nature?");
        questions.add("What is your Body energy level?");
        questions.add("What is your Voice Quality?");
        questions.add("What type of Dreams do you get often?");
        questions.add("How is your Social relationships?");
        questions.add("How do you manage your Wealth?");
        questions.add("How is your Bowel movement?");
        questions.add("How is your Communication skills?");

        String[][] options = {
                {"Thin and Lean","Medium","Well built"},
                {"Dry and with split ends","Normal,Thin,More Hair fall","Greasy,Heavy"},
                {"Pale Brown","Grey","Black"},
                {"Dry,Rough","Soft,More Sweating,Acne","Moist,Greasy"},
                {"Dark,Blackish","Pinkish,Shiny","Glowing,White"},
                {"Low,Difficult to put on Weight", "Medium,Can Easily Lose or Gain weight", "OverWeight,Difficult to Lose Weight"},
                {"Blackish,small,brittle", "Redish,small", "Pinkish,Big,Smooth"},
                {"Very Big or Very Small,Irregular,Blackish", "Medium Sized,Yellowish", "Large Shining White"},
                {"Fast,Always in Hurry", "Medium,Energetic", "Slow,Steady"},
                {"Quick,Restless", "Smart Intellect,Aggressive", "Calm,Stable"},
                {"Short term Bad", "Good memory", "Long term,best"},
                {"Interrupted,Less","Moderate", "Sleepy,Lazy"},
                {"Dislike Cold", "Dislike Heat","Dislike Moist,Rainy and Cool Weather"},
                {"Anxiety,Worry,Irritabilty", "Anger,Aggression", "Calm,Reculsive,Sometimes Depressive"},
                {"Changes Quickly have frequent Mood swings", "Changes Slowly", "Stable Constant"},
                {"Eats Quickly without chewing properly", "Eats at a moderate Speed", "Chews Food Properly"},
                {"Irregular,Anytime", "Sudden Hunger Pangs,Sharp hunger", "Can Skip any Meal easily"},
                {"Less than Normal,hands and Feet are cold", "More than Normal,face and forehead are Hot", "Normal,hands and feet are slightly cold"},
                {"Weak,noise on Movement", "Healthy with Optimal Strength", "Heavy weight Bearing"},
                {"Fearful,Jealous", "Egoistic,Fearless", "Forgiving,Grateful,Not Greedy"},
                {"Becomes Low in Evening,Fatigues after less work", "Moderate,Gets tired after Medium work", "Excellent energy throughout day not easily fatigued"},
                {"Rough with Broken words", "Fast and commanding", "Soft and deep"},
                {"Sky,wind,flying objects and confusion", "Fire,Light,bright colors,violence", "Water pools,Gardens and good relationships"},
                {"Makes less friends prefers solitude", "Good No.of friends", "Loves to socialize relationships are long lasting"},
                {"Spends without thinking much", "Saves but spends on valuable things","prefers more savings"},
                {"Dry,hard,blackish,scanty,stools", "Soft,yellowish,loose stools", "Heavy,Thick,Sticky stools"},
                {"Fast,Irrelevant Talk,Speech not clear", "Good Speaker with genuine argumentative skills", "Authoritative,Firm and little speech"},
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
        vata_value = findViewById(R.id.vata_value);
        pitta_value = findViewById(R.id.pitta_value);
        kapha_value = findViewById(R.id.kapha_value);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        answers_radiogrp = findViewById(R.id.answers_radiogrp);
        answers = new ArrayList<>();
        userchoices = new ArrayList<>(Collections.nCopies(3, 0));

        //init
        questions_num_tv.setText(index+1+".");
        questions_tv.setText(questions.get(index));
        choice1.setText(opt.get(index).get(0));
        choice2.setText(opt.get(index).get(1));
        choice3.setText(opt.get(index).get(2));

        name = getIntent().getStringExtra("name");
       // String age = getIntent().getStringExtra("age");
        username_tv.setText("Hello! "+name);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answers_radiogrp.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                } else {
                    int selected_choice_id = answers_radiogrp.getCheckedRadioButtonId();
                    RadioButton selectedAns = findViewById(selected_choice_id);
                    String ansText = selectedAns.getText().toString();

                    // Find the index of the selected answer in the options array
                    int selected_index = opt.get(index).indexOf(ansText);

                    // Increment the count of the selected choice in userchoices ArrayList
                    userchoices.set(selected_index, userchoices.get(selected_index) + 1);

                    answers.add(ansText);
                    index++;
                    if (index == questions.size()) {
                        isCompleted = true;
                        setContentsVisible(true);
                    } else {
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
                Intent i  = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(i);
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
            for(int i=0;i<userchoices.size();i++){
                Log.d("thisme", String.valueOf(userchoices.get(i)));
            }
            String result = getResult();
            result_tv.setText("Your prakruthi is " + result);
            restart_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i  = new Intent(QuestionsActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }else{
            main_rl.setVisibility(View.VISIBLE);
            finished_ll.setVisibility(View.GONE);
        }

    }
    public String getResult() {
        String res = "";
        vata_value.setText(""+ userchoices.get(0));
        pitta_value.setText(""+userchoices.get(1));
        kapha_value.setText(""+userchoices.get(2));
        if(userchoices.get(0) >= (questions.size()/3)){
            res = res + " Vata";
            vata_value.setBackgroundColor(Color.GREEN);
            vata_value.setTextColor(Color.BLACK);
        }
        if(userchoices.get(1) >= (questions.size()/3)){
            res = res + " ,Pitta";
            pitta_value.setBackgroundColor(Color.GREEN);
            pitta_value.setTextColor(Color.BLACK);
        }if(userchoices.get(2) >= (questions.size()/3)){
            res = res + " ,Kapha";
            kapha_value.setBackgroundColor(Color.GREEN);
            kapha_value.setTextColor(Color.BLACK);
        }

        return res;
    }



}