package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;
    // 이전화면에서 전달된 값을 저장할 변수
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 이전 화면에서 전달된 데이터 추출
        Intent fromIntent = getIntent();
        name = fromIntent.getStringExtra("name");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                String age_str = editText.getText().toString().trim();
                if(age_str.equals("")) {
                    Toast.makeText(this, "나이를 입력해주세요",
                            Toast.LENGTH_SHORT).show();
                    return;     // 메소드 강제 종료
                }
                int age = Integer.parseInt(age_str);
                // 인텐트 생성
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                startActivity(intent);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}