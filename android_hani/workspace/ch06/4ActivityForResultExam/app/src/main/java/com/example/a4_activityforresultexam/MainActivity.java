package com.example.a4_activityforresultexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String memo = textView.getText().toString();

                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("memo", memo);
                // 저쪽 액티비티로부터 데이터를 요청할 때 사용
                // deprecated 명령어 : 조만간 없어질 명령어라는 의미미
                startActivityForResult(intent, 100);
                //startActivity(intent);  // 일방적으로 보여주기만 함
                break;
        }
    }

    // 시스템으로부터 데이터를 돌려받을 때 자동호출됨
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if(resultCode == RESULT_OK) {
                    String edit = data.getStringExtra("edit");
                    textView.setText(edit);
                }
                break;
        }
    }
}










