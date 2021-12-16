package com.example.a3_cameraexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a3_cameraexam.helper.PhotoHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;
    String photoPath = null;
    Bitmap bmp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        // 이벤트 설정
        button.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        // 이미지 파일 경로 얻기
        photoPath = PhotoHelper.getInstance().getNewPhotoPath();
        File file = new File(photoPath);
        Uri uri = null;

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(this,
                    getApplicationContext().getPackageName() + ".fileprovider", file);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        // 저장될 경로 전달
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(AUDIO_SERVICE, false);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100) {
            if(resultCode == RESULT_OK) {
                // 촬영물을 MediaStore에 등록해야, 다른 앱에서 이미지파일을 사용할 수 있다.
                Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.parse("file://" + photoPath));
                sendBroadcast(photoIntent);

                // 이미지뷰에 이미지 출력
                // 기존에 표시되던 이미지 제거
                imageView.setImageBitmap(null);
                // Bitmap 객체의 메모리 해제를 시켜야, 이미지가 사라진다.
                if(bmp != null) {
                    bmp.recycle();
                    bmp = null;
                }

                // 이미지 얻어오기
                bmp = PhotoHelper.getInstance().getThumb(this, photoPath);
                imageView.setImageBitmap(bmp);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Bitmap 객체의 메모리 해제를 시켜야, 이미지가 사라진다.
        if(bmp != null) {
            bmp.recycle();
            bmp = null;
        }
    }
}