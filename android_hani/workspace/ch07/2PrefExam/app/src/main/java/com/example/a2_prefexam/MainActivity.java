package com.example.a2_prefexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }

    // 액티비티 화면이 뜨기 직전에 자동 호출됨
    @Override
    protected void onResume() {
        super.onResume();

        // 설정 데이터 읽기
        // 1) 공통 정보 관리 객체 생성 (파일명, 접근 제한)
        SharedPreferences pref = getSharedPreferences("CONFIG", MODE_PRIVATE);
        // 2) 데이터 값 추출
        String name = pref.getString("name", "설정안됨");
        String id = pref.getString("id", "알수없음");
        // 3) 결과 출력
        String result = "이름 : " + name + "\n" + "아이디 : " + id;
        textView.setText(result);
    }
}







