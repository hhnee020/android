package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.practice1.adapter.ScoreAdapter;
import com.example.practice1.model.Score;

import java.util.List;

public class OutputActivity extends AppCompatActivity implements View.OnClickListener {
    List<Score> list;
    ScoreAdapter adapter;
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        // 객체 초기화
        list = (List<Score>) getIntent().getSerializableExtra("list");
        adapter = new ScoreAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        // 어댑터 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}