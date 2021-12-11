package com.example.a4_activityforresultexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;
    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        memo = getIntent().getStringExtra("memo");
        // 넘어온 데이터로 edittext 설정
        editText.setText(memo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                // 수정내용 읽기
                String edit = editText.getText().toString().trim();
                // 수정 내용을 저장하기 위해 빈 인텐트 생성
                Intent intent = new Intent();
                intent.putExtra("edit", edit);
                // 데이터를 보낸다는 의미로 OK데이터를 담아서, 시스템에게 인텐트를 돌려줌
                setResult(RESULT_OK, intent);
                // 현재화면 종료
                finish();
                break;
            case R.id.button2:
                // 데이터를 안보내겠다는 의미로 CANCELED데이터를 담아서, 시스템에게 돌려줌
                setResult(RESULT_CANCELED);
                // 현재화면 종료
                finish();
                break;
        }
    }
}