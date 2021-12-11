package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 객체 초기화
        editText = findViewById(R.id.editText);
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
                String name = editText.getText().toString().trim();
                // 인텐트 생성
                Intent intent = new Intent(this, ThirdActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.button2:
                // 이전 화면 이동
                finish();   // 현재 Activity 종료
                break;
        }
    }
}