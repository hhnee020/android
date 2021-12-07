package com.example.a2_buttonexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.a2_buttonexam.R;

// 1. 이벤트 리스너 인터페이스 선택 및 메소드 구현
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 2. 사용할 클래스 선언
    Button button1, button2;
    ImageButton imageButton1, imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3. 객체 찾아오기
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);

        // 4. 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String msg = "";

        switch (id) {
            case R.id.button1:
                msg = "당신은 남자입니다.";
                break;
            case R.id.button2:
                msg = "당신은 여자입니다.";
                break;
            case R.id.imageButton1:
                msg = "남자를 선택하였습니다.";
                break;
            case R.id.imageButton2:
                msg = "여자를 선택하였습니다.";
                break;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}