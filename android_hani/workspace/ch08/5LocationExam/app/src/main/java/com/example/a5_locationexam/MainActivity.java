package com.example.a5_locationexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView textView1, textView2, textView3;
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        }
    }

    // 화면이 뜨기 직전마다 자동 호출
    @Override
    protected void onResume() {
        super.onResume();

        // 현재 사용가능한 하드웨어 이름 얻기
        // gps, network
        String provider = lm.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "BestProvider : " + provider, Toast.LENGTH_SHORT).show();

        if (provider == null) {
            Toast.makeText(this, "위치정보를 사용할 수 있는 상태가 아닙니다.",
                    Toast.LENGTH_SHORT).show();
            return;     // 강제 종료
        }
        // 퍼미션이 허락되있는지 검사
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;    // 강제 종료
        }
        // 해당 장치가 마지막으로 수신한 위치얻기
        Location location = lm.getLastKnownLocation(provider);
        if(location != null) {
            onLocationChanged(location);   // 이벤트 함수 호출
        }
        // 위치 정보 취득 시작
        // (하드웨어이름, 갱신주기(ms), 갱신거리주기(m), 이벤트)
        lm.requestLocationUpdates(provider, 1000, 1, this);
    }
    // 화면이 가려질 때마다 자동 호출
    @Override
    protected void onPause() {
        super.onPause();
        // 위치정보 수신 종료
        lm.removeUpdates(this);
    }

    // 위도와 경도를 기반으로 주소구하기
    public String getAddress(double lat, double lng) {
        String str_addr = null;

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> list = null;

        try {
            list = geocoder.getFromLocation(lat, lng, 1);
            if(list.size() > 0) {
                Address address = list.get(0);
                str_addr = address.getAddressLine(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str_addr;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double lat = location.getLatitude();    // 위도
        double lng = location.getLongitude();   // 경도

        textView1.setText(String.valueOf(lat));
        textView2.setText(String.valueOf(lng));
        textView3.setText(getAddress(lat, lng));
    }
}