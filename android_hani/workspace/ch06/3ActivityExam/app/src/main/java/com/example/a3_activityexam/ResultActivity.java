package com.example.a3_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.a3_activityexam.model.Answer;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    Answer answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textView);
        // 인테트 데이터 추출
        answer = (Answer) getIntent().getSerializableExtra("answer");

        String result = "아이디 : " + answer.getId() + "\n"
                      + "비밀번호 : " + answer.getPassword() + "\n"
                      + "이메일 : " + answer.getEmail();

        textView.setText(result);
    }
}