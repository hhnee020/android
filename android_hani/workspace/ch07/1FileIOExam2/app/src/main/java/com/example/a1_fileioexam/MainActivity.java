package com.example.a1_fileioexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1_fileioexam.helper.FileHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1, button2;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        File dir = getFilesDir(); // 우리 앱의 저장 폴더위치 얻어오기
        // filePath = /data/user/0/com.example.a1_fileioexam/files/mymemo.txt
        String filePath = dir.getAbsolutePath() + "/mymemo.txt";
        Log.d("[TEST]", "filePath = " + filePath);

        String encType = "utf-8";

        switch (v.getId()){
            case R.id.button1:   // 저장하기
                String content = editText.getText().toString().trim();
                boolean result = FileHelper.getInstance().writeString(filePath, content, encType);

                String msg = "";
                if(result) msg = "저장 성공";
                else msg = "저장 실패";

                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:  // 불러오기
                String read_str = FileHelper.getInstance().readString(filePath, encType);
                textView2.setText(read_str);
                break;
        }
    }
}