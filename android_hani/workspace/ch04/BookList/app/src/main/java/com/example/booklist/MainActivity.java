package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booklist.adapter.BookAdapter;
import com.example.booklist.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Book> list;
    BookAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new BookAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        // 어댑터 설정
        listView.setAdapter(adapter);   // 이줄 이후부터는 리스트뷰와 어댑터가 소통을 함
        // 이벤트 설정
        listView.setOnItemClickListener(this);
        // 리스트 객체에 데이터 저장
        addData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Book item = adapter.getItem(position);
        String result = item.getSubject() + "\n"
                      + item.getWriter() + "\n"
                      + item.getPublisher();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
    // 어댑터 객체를 통해서 리스트에 데이터 추가
    void addData() {
        adapter.add(new Book("안드로이드: 플랫폼 포팅과 활용",
                "전용준 김한철 외 2 명 지음", "진한엠앤비 펴냄", R.drawable.book01));
        adapter.add(new Book("안드로이드 프로그래밍",
                "천인국 지음", "생능출판사 펴냄", R.drawable.book02));
        adapter.add(new Book("안드로이드 앱 프로그래밍",
                "정재곤 지음", "이지스퍼블리싱 펴냄", R.drawable.book03));
        adapter.add(new Book("안드로이드 프로그래밍 정복. 1",
                "김상형 지음", "한빛미디어 펴냄", R.drawable.book04));
        adapter.add(new Book("안드로이드 프로그래밍 정복. 2",
                "김상형 지음", "한빛미디어 펴냄", R.drawable.book05));
        adapter.add(new Book("아두이노와 안드로이드로 45개 프로젝트 만들기",
                "서민우 지음", "앤써북 펴냄", R.drawable.book06));
        adapter.add(new Book("안드로이드 프로그래밍",
                "장용식 성낙현 지음", "인피니티북스 펴냄", R.drawable.book07));
        adapter.add(new Book("안드로이드는 전기양을 꿈꾸는가",
                "필립 K. 딕 지음 / 이선주 옮김", "황금가지 펴냄", R.drawable.book08));
        adapter.add(new Book("안드로이드 스마트폰 베스트 앱 200",
                "이동규 지음", "정보문화사 펴냄", R.drawable.book09));
        adapter.add(new Book("안드로이드를 지배하는 통신 프로그래밍",
                "박헌재 지음", "프리렉 펴냄", R.drawable.book10));
    }
}