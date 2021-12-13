package com.example.a6_intentexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        permissionCheck2();
    }

    private void permissionCheck2() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:     // 다이얼러 표시
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                startActivity(intent);
                break;
            case 1:     // 전화걸기
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01012345678"));
                startActivity(intent);
                break;
            case 2:     // 문자발송
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01012345678"));
                intent.putExtra("sms_body", "Hello Android");
                startActivity(intent);
                break;
            case 3:     // 이메일 보내기
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:hong@naver.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "메일 테스트");
                intent.putExtra(Intent.EXTRA_TEXT, "안드로이드에서 발송하는 메일입니다.");
                startActivity(intent);
                break;
            case 4:     // 웹 페이지 보기
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.daum.net"));
                startActivity(intent);
                break;
            case 5:     // 주소록
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case 6:     // 특정 App 설치 페이지 보기
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.fineapp.yogiyo"));
                startActivity(intent);
                break;
            case 7:     // 동영상 재생
                break;
            case 8:     // MP3 재생
                break;
            case 9:     // 시스템 환경 설정 페이지 보기
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case 10:    // GPS 설정화면 보기
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case 11:    // WIFI 설정화면 보기
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case 12:    // 카카오톡 (테스트할 때, 스마트폰으로)
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "text");
                intent.setPackage("com.kakao.talk");
                startActivity(intent);
                break;
        }
    }
}