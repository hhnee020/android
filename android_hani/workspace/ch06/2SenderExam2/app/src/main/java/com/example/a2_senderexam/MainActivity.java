package com.example.a2_senderexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button;
    String phoneNo, message;
    // 문자메시지 관리 클래스
    SmsManager sms;
    // 눌림 상태 확인 : 여러번 전송되는 것 방지
    boolean pressCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        sms = SmsManager.getDefault();
        // 이벤트 설정
        button.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
                // 거부 당했을 때
            } else {
                // 맨처음 앱을 실행했을 때
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        phoneNo = editText1.getText().toString().trim();
        message = editText2.getText().toString().trim();

        // 입력 검사
        if(!phoneNo.equals("") && !message.equals("")) {
            Toast.makeText(this, "전화번호와 메시지 설정 완료",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "전화번호와 메시지를 입력해주세요",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 하드웨어 키가 눌릴 때 호출
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(pressCheck == false) {
                    pressCheck = true;
                    // 입력값 검사
                    if(phoneNo==null || message==null || phoneNo.equals("") || message.equals("")) {
                        Toast.makeText(this, "전화번호나 메시지가 설정되지 않았습니다.",
                                Toast.LENGTH_SHORT).show();
                        return false;   // 강제종료
                    }
                    sms.sendTextMessage(phoneNo, null, message, null, null);
                }
                break;
            case KeyEvent.KEYCODE_BACK:
                finish();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    // 하드웨어 키를 뗄 때 호출
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        pressCheck = false;
        return super.onKeyUp(keyCode, event);
    }
}