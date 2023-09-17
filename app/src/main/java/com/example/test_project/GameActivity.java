package com.example.test_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    TextView tvQuestion,tvScore,tvName;
    Button btnNext,btnQuit;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    String name;
    String ques[] = {"Que1:Which method can be defined only once in a program?",
            "Que 2: Which keyword is used by method to refer to the current object that invoked it?",
            "Que 3: Which of these access specifiers can be used for an interface?",
            "Que 4: Which of the following is correct way of importing an entire package pkg'?",
            "Que 5: What is the return type of Constructors?"};
    String answer[] = {"main method","this","public","import pkg.","None of the Mentioned"};
    String option[] = {"finalize method","main method","static method","private method",
                       "import","this","catch","abstract",
                       "public","protected","private","All of the mentioned",
                       "lmport pkg.","import pkg.","Import pkg.","import pkg.",
                       "int","float","void","None of the mentioned"};
    int flag = 0;
    static int finalScore=0,correct= 0,wrong= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        tvName = findViewById(R.id.tvName);
        btnNext = findViewById(R.id.btnNext);
        btnQuit = findViewById(R.id.btnQuit);
        rg = findViewById(R.id.rg);
        rb1= findViewById(R.id.rb1);
        rb2= findViewById(R.id.rb2);
        rb3= findViewById(R.id.rb3);
        rb4= findViewById(R.id.rb4);
        tvQuestion.setText(ques[flag]);
        rb1.setText(option[0]);
        rb2.setText(option[1]);
        rb3.setText(option[2]);
        rb4.setText(option[3]);

        name = getIntent().getStringExtra("name");
        tvName.setText("Hello"+name);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Please fill choice",Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans = findViewById(rg.getCheckedRadioButtonId());
                String ansVal = ans.getText().toString();

                if(ansVal.equals(answer[flag])){
                    correct++;
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                }else {
                    wrong++;
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                }
                flag++;

                if(tvScore != null){tvScore.setText(""+correct);}
                if(flag<ques.length){
                    tvQuestion.setText(ques[flag]);
                    rb1.setText(option[flag*4]);
                    rb2.setText(option[flag*4+1]);
                    rb3.setText(option[flag*4+2]);
                    rb4.setText(option[flag*4+3]);
                }else {
                    finalScore=correct;
                    Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                    startActivity(intent);
                }
                rg.clearCheck();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });


    }
}