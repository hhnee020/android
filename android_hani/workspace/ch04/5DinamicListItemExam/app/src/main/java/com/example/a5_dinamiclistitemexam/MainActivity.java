package com.example.a5_dinamiclistitemexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a5_dinamiclistitemexam.adapter.ItemAdapter;
import com.example.a5_dinamiclistitemexam.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {
    List<Item> list;
    ItemAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;
    // 일렬번호를 관리할 변수
    public static int NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new ItemAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        // 어댑터 설정
        listView.setAdapter(adapter);   // 이줄 이후부터 리스트뷰와 어댑터는 서로 소통을 함
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = editText.getText().toString().trim();
        NUM++;
        Item item = new Item(NUM, input);
        adapter.insert(item, 0);  // 정해진 위치에 삽입, index=0이면 제일 첫번째 삽입
        //adapter.add(item);      // 제일 뒤쪽으로 추가시킴

        editText.setText("");  // 입력된 글자 지우기
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = adapter.getItem(position);
        String result = item.getNum() + " / " + item.getName();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}