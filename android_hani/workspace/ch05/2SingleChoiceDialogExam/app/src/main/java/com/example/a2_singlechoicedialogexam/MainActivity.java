package com.example.a2_singlechoicedialogexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;

    // 가운데 출력할 문자열 배열
    String[] items= {"선택항목1", "선택항목2", "선택항목3"};
    // 선택 상태 저장
    int checkedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                showSingleChoiceDialog();
                break;
        }
    }

    private void showSingleChoiceDialog() {
        // 이전 선택 상태 저장
        // => cancel 버튼 클릭시, 이전 상태로 복원하기 위함
        int temp = checkedItem;

        // 다이얼로그 구성 객체
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setCancelable(false);

        // 가운데 부분 구성
        // builder.setSingleChoiceItems(문자열 배열, 선택위치, 이벤트)
        builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 선택 위치값 저장
                checkedItem = which;
                // 선택 결과 확인
                Toast.makeText(getApplicationContext(), items[which],
                        Toast.LENGTH_SHORT).show();
            }
        });

        // OK 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[checkedItem],
                        Toast.LENGTH_SHORT).show();
            }
        });
        // CANCEL 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 이전 선택값으로 원복시킴
                checkedItem = temp;
            }
        });
        // 다이얼로그 생성
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}