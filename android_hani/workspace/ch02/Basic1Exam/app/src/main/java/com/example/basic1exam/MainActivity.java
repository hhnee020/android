package com.example.basic1exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 클래스 선언
    LinearLayout linearLayout;
    TextView textView;    // 문자열 1개 출력 클래스
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(linearLayout);
    }

    void init() {
        // layout 생성
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        textView = new TextView(this);
        textView.setText("Hello Android!!");
        textView.setTextSize(30);
        linearLayout.addView(textView);

        // view 클래스의 가로 세로 지정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,    // width
                ViewGroup.LayoutParams.WRAP_CONTENT     // height
        );

        button = new Button(this);
        button.setText("확인");
        button.setTextSize(30);
        button.setLayoutParams(params);
        linearLayout.addView(button);
    }
}