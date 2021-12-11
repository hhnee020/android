package com.example.a1_simpledialogexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                showAlertDialog();
                break;
            case R.id.button2:
                showConfirmDialog();
                break;
            case R.id.button3:
                showListDialog();
                break;
        }
    }

    private void showAlertDialog() {
        // 다이얼로그 구성 클래스
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 제목 설정
        builder.setTitle("알림");
        // 내용 설정
        builder.setMessage("알림 대화상자 입니다.");
        // 아이콘 설정
        builder.setIcon(R.mipmap.ic_launcher);
        // backkey를 눌렀을 때, 창이 닫히지 않는 설정
        builder.setCancelable(false);

        // 확인 버튼 추가
        // builder.setPositiveButton(문자열, 이벤트)
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "확인을 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 설정한대로 다이얼로그 생성
        AlertDialog alertDialog = builder.create();
        // 창 출력
        alertDialog.show();
    }

    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage("확인 대화상자 입니다.");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setCancelable(false);

        // 긍정 버튼 추가 : 오른쪽 배치
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "OK를 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // 부정 버튼 추가 : 왼쪽 배치
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CANCEL을 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // 중립 버튼 추가 : 제일 왼쪽 배치
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소를 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 다이얼로그 생성
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        // setMessage()로 설정된 값은 자리를 차지하고, 안비켜 줌
        // 그렇기 때문에 가운데 부분에 다른 내용을 출력할 경우에는, setMessage()를 사용하면 안됨
        //builder.setMessage("List Dialog");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setCancelable(false);

        // 가운데 출력할 문자열 배열
        String[] items = {"축구", "농구", "배구"};
        // 긍정의 버튼 역할을 함
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which],
                        Toast.LENGTH_SHORT).show();
            }
        });
        // cancel 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "CANCEL을 눌렀습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}











