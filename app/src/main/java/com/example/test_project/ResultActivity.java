package com.example.test_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvCorrect,tvWrong,tvResultFinal;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvCorrect = findViewById(R.id.tvCorrect);
        tvWrong = findViewById(R.id.tvWrong);
        tvResultFinal = findViewById(R.id.tvResultFinal);
        btnRestart = findViewById(R.id.btnRestart);

        StringBuffer ta = new StringBuffer();
        ta.append("Correct Answers: "+GameActivity.correct+"\n");
        StringBuffer ta2 = new StringBuffer();
        ta2.append("Wrong Answers: "+GameActivity.wrong+"/n");
        StringBuffer ta3 =new StringBuffer();
        ta3.append("Final Score: "+GameActivity.correct+"/n");
        tvCorrect.setText(ta);
        tvWrong.setText(ta2);
        tvResultFinal.setText(ta3);

        GameActivity.correct=0;
        GameActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}