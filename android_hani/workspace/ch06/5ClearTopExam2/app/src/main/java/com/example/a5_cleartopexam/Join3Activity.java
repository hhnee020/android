package com.example.a5_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Join3Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 회원가입이 되었다고 가정하고, 데이터들을 toast로 출력
        String id = getIntent().getStringExtra("id");
        String pw = getIntent().getStringExtra("pw");
        String hobby = getIntent().getStringExtra("hobby");
        int age = Integer.parseInt(editText.getText().toString().trim());
        String result = "아이디 : " + id + "\n"
                      + "비밀번호 : " + pw + "\n"
                      + "취미 : " + hobby + "\n"
                      + "나이 : " + age;

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

        // MainActivity로 돌아감
        Intent intent = new Intent(this, MainActivity.class);
        // 1. history stack 비우기
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // 2. 새로운 화면을 만들지 말고, 기존화면 보여주세요 설정
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}