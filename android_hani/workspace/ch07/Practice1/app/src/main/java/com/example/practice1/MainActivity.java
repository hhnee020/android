package com.example.practice1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practice1.helper.FileHelper;
import com.example.practice1.model.Score;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;
    List<Score> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        list = new ArrayList<>();
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        File dir = getFilesDir();
        String filePath = dir.getAbsolutePath() + "/score.txt";

        switch (v.getId()) {
            case R.id.button1:  // 입력화면 이동
                intent = new Intent(this, InputActivity.class);
                intent.putExtra("list", (Serializable) list);
                startActivityForResult(intent, 100);
                break;
            case R.id.button2:  // 목록화면 이동
                intent = new Intent(this, OutputActivity.class);
                intent.putExtra("list", (Serializable) list);
                startActivity(intent);
                break;
            case R.id.button3:  // 파일 저장
                boolean result = FileHelper.getInstance().write(filePath, list);
                String msg = "";
                if(result) msg = "저장 성공";
                else msg = " 저장 실패";
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:  // 파일 읽기
                // 리스트 데이터 삭제
                list.clear();
                list = FileHelper.getInstance().read(filePath);
                String msg1 = "";
                if(list.size() > 0) msg1 = "읽기 성공";
                else msg1 = " 읽기 실패";
                Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();
                break;
        }
    }
    // 입력화면에서 되돌아온 list 저장
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            if(resultCode == RESULT_OK) {
                list = (List)data.getSerializableExtra("list");
            }
        }
    }
}