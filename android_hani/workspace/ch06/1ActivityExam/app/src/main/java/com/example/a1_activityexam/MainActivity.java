package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                // SecondActivity 요청 정보 저장
                Intent intent = new Intent(this, SecondActivity.class);
                // 시스템에게 Activity 요청
                startActivity(intent);
                break;
            case R.id.button2:
                // 앱 종료
                finish();   // Activity 종료 메소드드
               break;
        }
    }
}