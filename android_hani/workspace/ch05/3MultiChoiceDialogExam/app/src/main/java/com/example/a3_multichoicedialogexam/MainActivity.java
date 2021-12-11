package com.example.a3_multichoicedialogexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    // 가운데 사용할 문자열 배열
    String[] items = {"선택항목1", "선택항목2", "선택항목3"};
    // 선택 상태 저장
    boolean[] checkedItems = {false, false, false};

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
                showMultiChoiceDialog();
                break;
        }
    }

    private void showMultiChoiceDialog() {
        // 이전 상태값 임시저장
        // => cancel 버튼 클릭시, 상태를 복원시키기 위함
        boolean[] temp = new boolean[checkedItems.length];
        // 배열값 복사
        System.arraycopy(checkedItems, 0, temp, 0, checkedItems.length);

        // 다이얼로그 구성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        builder.setCancelable(false);

        // 가운데 부분
        //builder.setMultiChoiceItems(문자열, 선택 상태값, 이벤트)
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });

        // OK 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 선택되어진 값 출력
                String result = "";
                for(int i=0; i<checkedItems.length; i++) {
                    if(checkedItems[i]) {
                        result += items[i] + "  ";
                    }
                }
                if(result.equals("")) {
                    result = "선택된 항목이 없습니다.";
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
        // CANCEL 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 이전 상태로 원복
                System.arraycopy(temp, 0, checkedItems, 0, temp.length);
            }
        });

        // 다이얼로그 생성
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}