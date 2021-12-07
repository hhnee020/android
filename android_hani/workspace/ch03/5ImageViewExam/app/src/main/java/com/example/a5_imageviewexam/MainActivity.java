package com.example.a5_imageviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                imageView.setImageResource(R.drawable.img1);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.button2:
                imageView.setImageResource(R.drawable.img2);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
        }
    }
}