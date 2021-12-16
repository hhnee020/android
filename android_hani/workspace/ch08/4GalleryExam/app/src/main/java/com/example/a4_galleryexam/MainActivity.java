package com.example.a4_galleryexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4_galleryexam.helper.FileUtils;
import com.example.a4_galleryexam.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;
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
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // 파일 필터링
        intent.setType("image/*");
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if(resultCode == RESULT_OK) {
                Uri photoUri = data.getData();
                String filePath = FileUtils.getPath(this, photoUri);
                // photoUri = content://com.android.providers.media.documents/document/image%3A34
                // filePath = /storage/emulated/0/DCIM/p2021-12-16 19-15-37.jpg
                Log.d("[TEST]", "photoUri = " + photoUri);
                Log.d("[TEST]", "filePath = " + filePath);
                // 이미지뷰에 출력
                //imageView.setImageBitmap(PhotoHelper.getInstance().getThumb(this, filePath));
                imageView.setImageURI(photoUri);
            }
        }
    }
}