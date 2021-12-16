package com.example.listex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// id 불러오기

        list =(ListView)findViewById(R.id.list);

        // 형태 만들기 데이터 하기 전 자료형 (스트링 형태로) 리스트 만들기

        List<String> data = new ArrayList<String>();

        // 연결 해주는 역활 data와 list 중간다리;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);

        // 리스트에 어댑터 셋팅
        list.setAdapter(adapter);

        data.add("최하니");
        data.add("930220");
        data.add("안드로이드");

        //데이터 저장;
        adapter.notifyDataSetChanged();
    }
}