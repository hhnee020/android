package com.example.a5_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 회원가입되었다고 가정하고, 아이디와 비밀번호를 toast로 출력시킴
            case R.id.button1:
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                String result = "아이디 : " + id + "\n" + "비밀번호 : " + pw;
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                break;
            // 회원가입 절차 진행
            case R.id.button2:
                Intent intent = new Intent(this, Join1Activity.class);
                startActivity(intent);
                break;
        }
    }
}