package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice1.model.Score;

import java.io.Serializable;
import java.util.List;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    List<Score> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        // 객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        list = (List)getIntent().getSerializableExtra("list");
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:  // 값을 읽어와서 리스트에 저장하고 돌려줌
                String hak = editText1.getText().toString().trim();
                String name = editText2.getText().toString().trim();
                String kor = editText3.getText().toString().trim();
                String eng = editText4.getText().toString().trim();
                String mat = editText5.getText().toString().trim();
                Score score = new Score(hak, name, kor, eng, mat);
                list.add(score);
                // 돌려주기
                Intent intent = new Intent();
                intent.putExtra("list", (Serializable) list);
                setResult(RESULT_OK, intent);
                Toast.makeText(this, "저장", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}