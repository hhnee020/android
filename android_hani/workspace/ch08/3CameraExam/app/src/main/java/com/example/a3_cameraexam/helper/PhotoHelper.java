package com.example.a3_cameraexam.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;

import java.io.File;
import java.util.Calendar;

public class PhotoHelper {
    // 싱글톤 패턴 시작
    private static PhotoHelper instance;

    public static PhotoHelper getInstance() {
        if(instance == null) instance = new PhotoHelper();

        return instance;
    }

    private PhotoHelper() {}
    // 싱글톤 패턴 끝

    // DCIM 폴더 하위에 새로 저장될 이미지 파일의 이름을 생성
    public String getNewPhotoPath() {
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        String fileName = String.format("p%04d-%02d-%02d %02d-%02d-%02d.jpg",
                                        yy, mm, dd, hh, mi, ss);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        if(!dir.exists()) dir.mkdirs();

        String photoPath = dir.getAbsolutePath() + "/" + fileName;
        return photoPath;
    }

    // 큰 이미지를 스마트폰 크기로 줄이기
    public Bitmap getThumb(Activity activity, String path) {
        // 이미지를 저장하는 객체
        Bitmap bmp = null;

        // 1) 스마트폰 화면 해상도 얻기
        // 해상도 관리 객체
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        // 스마트폰의 가로, 높이 크기 얻기
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        // 긴 쪽을 선택
        int maxScale = deviceWidth;
        if(deviceWidth < deviceHeight) maxScale = deviceHeight;

        // 2) 이미지 파일의 해상도 얻기
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;  // 이미지 정보만 읽어오는 설정
        // 이미지 읽어오기
        BitmapFactory.decodeFile(path, options);

        // 긴 쪽 저장
        int fScale = options.outWidth;
        if(options.outWidth < options.outHeight) fScale = options.outHeight;

        // 3) 스마트폰 크기에 맞춰 이미지 파일 읽어오기
        if(maxScale < fScale) {  // 이미지가 더 클 경우
            int sampleSize = fScale / maxScale;
            // 새 옵션 생성
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = sampleSize;  // 값이 3이면, 1/3 크기로 불러온다.
            // 이미지 불러오기
            bmp = BitmapFactory.decodeFile(path, options2);
        } else {  // 원본 크기로 불러오기
            bmp = BitmapFactory.decodeFile(path);
        }
        return bmp;
    }
}
