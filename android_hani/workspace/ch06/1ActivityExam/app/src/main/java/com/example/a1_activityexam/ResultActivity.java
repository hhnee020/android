package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textView);

        Intent fromIntent = getIntent();
        name = fromIntent.getStringExtra("name");
        // getIntExtra("이름", 기본값)
        age = fromIntent.getIntExtra("age", 0);
        // textView에 단어별로 색상을 사용할 때는,
        // HTML 태그를 사용해서 설정한다.
        String result = "<font color=blue>" + name + "님</font>의 나이는 "
                      + "<font color=red>" + age + "세</font>입니다.";
        textView.setText(Html.fromHtml(result));
    }
}