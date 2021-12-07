package com.example.a3_buttonevnetexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 1. 클래스 선언
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2. 객체 얻어오기
        button = findViewById(R.id.button);

        // 3. 이벤트 설정
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼 클릭",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}