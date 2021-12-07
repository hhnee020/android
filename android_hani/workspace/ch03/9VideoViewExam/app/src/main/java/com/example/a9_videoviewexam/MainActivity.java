package com.example.a9_videoviewexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;   // 재생버튼, 뒤로, 앞으로, 슬라이더바의 컨트롤러
    final int MY_PERMISSIONS = 100;     // 허락해주세요 알림창의 id
    boolean permissionCK = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 타이틀바 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        // 객체 초기화
        videoView = findViewById(R.id.videoView);
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        // 퍼미션 체크
        permissionCheck();
        if(permissionCK) startVideo();
    }

    void permissionCheck() {
        // ActivityCompat.checkSelfPermission
        // => 권한 보유 여부를 확인하는 함수
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            /* 퍼미션이 허락되지 않았을 경우 */
            // ActivityCompat.shouldShowRequestPermissionRationale()
            // => 이전에 퍼미션을 거부당했는 지 검사하는 함수
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // 거부당했을 때 코드 작업
                // 허락해주세요 알림창 띄우기 함수
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS);
            } else {
                // 이전에 퍼미션을 거부당하지 않았을 경우 : 처음 앱을 실행했을 경우
                // 허락해주세요 알림창 띄우기 함수
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS);
            }
        } else {
            // 퍼미션이 허락되었을 경우
            permissionCK = true;
        }
    }

    // 허락해주세요 알림창에서 허락을 하든지, 거부를 하든지 무조건 1번 호출된다.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS:
                // 퍼미션이 허락되었는 지 검사
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startVideo();
                } else {
                    Toast.makeText(this, "동영상을 실행할 수가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    void startVideo() {
        // 내부 저장소 경로
        // 삼성폰 : phone 폴더
        // 가상머신 : storage/emulated/0 폴더
        File sdcard = Environment.getExternalStorageDirectory();
        String video_path = sdcard.getAbsolutePath() + "/BigBuck.mp4";
        videoView.setVideoPath(video_path);
        videoView.start();
    }
}