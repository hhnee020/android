package com.example.a1_textviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 1. xml에 만들어논 클래스 선언 : id와 똑같은 이름을 사용
    TextView textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2.객체 찾아오기
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        // 3. textview 내용 지정
        textView3.setText("안녕하세요. 안드로이드");
        textView4.setText(R.string.my_text);

        // 4. 글자 색상 지정
        int color = Color.rgb(255, 0, 0);
        textView3.setTextColor(color);

        Resources resources = getResources();
        int color2 = resources.getColor(R.color.my_blue);
        textView4.setTextColor(color2);

        // 5. 배경 색상 지정
        textView3.setBackgroundColor(Color.rgb(255, 255, 0));
        textView4.setBackgroundColor(getResources().getColor(R.color.my_orange));

        // 6. 글자 크기 지정
        textView3.setTextSize(30);
        float size = getResources().getDimension(R.dimen.my_size);
        textView4.setTextSize(size/2.5f);

        // 7. singleline 지정
        textView4.setSingleLine(true);
        textView4.setEllipsize(TextUtils.TruncateAt.END);


    }
}