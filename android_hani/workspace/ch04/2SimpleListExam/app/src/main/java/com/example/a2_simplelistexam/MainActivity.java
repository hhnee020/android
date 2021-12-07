package com.example.a2_simplelistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        // 이벤트 설정
        listView.setOnItemClickListener(this);
    }

    /**
     * listView의 항목을 클릭할 때마다 호출
     * @param parent    : listView 객체
     * @param view      : 선택된 항목의 view 클래스
     * @param position  : 선택된 위치값
     * @param id        : 선택된 위치값
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) listView.getItemAtPosition(position);
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }
}