package com.example.a3_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a3_activityexam.model.Answer;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = editText1.getText().toString().trim();
        String password = editText2.getText().toString().trim();
        String email = editText3.getText().toString().trim();

        Answer answer = new Answer(id, password, email);
        // 인텐트 생성
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("answer", answer);
        startActivity(intent);
    }
}