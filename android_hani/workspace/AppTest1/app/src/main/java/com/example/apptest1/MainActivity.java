package com.example.apptest1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.apptest1.apptest.Adapter;
import com.example.apptest1.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Food> list;
    Adapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new Adapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        // 어댑터 설정
        listView.setAdapter(adapter);   // 이 줄 이후부터, 어댑터와 listView는 서로 소통을 함함

        // 이벤트 설정
        listView.setOnItemClickListener(this);

        // 어댑터 객체를 통해서 리스트에 데이터 저장
        addData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Food item = adapter.getItem(position);
        String result = item.getTitle() + "\n" + item.getDescription();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    /** 데이터 추가 */

    public void addData() {
        adapter.add(new Food("고추잡채", "잘게 썬 돼지고기와 피망을 볶아 만든 중국식 잡채",R.drawable.food10));
        adapter.add(new Food("깐쇼새우", "튀긴 새우를 칠리소스와 함께 불에 볶은 요리", R.drawable.food02));
        adapter.add(new Food("깐풍기", "튀긴 닭고기에 소스를 얹어 강한 불에 살짝 끓인 요리", R.drawable.food03));
        adapter.add(new Food("난자완스", "쇠고기 또는 돼지고기를 다져서 완자를 만든 뒤 볶은 채소와 함께 소스에 졸인 요리", R.drawable.food04));
        adapter.add(new Food("라조기", "양념한 닭고기를 튀긴 뒤 야채들과 함께 매운 고추로 볶은 요리", R.drawable.food05));
        adapter.add(new Food("마파두부", "저민 돼지고기에 고추, 생강, 파 같은 양념을 듬뿍 넣어 향을 내고 혀가 얼얼할 정도로 맵고 새콤달콤한 맛을 내는 두부요리", R.drawable.food06));
        adapter.add(new Food("양장피", "각종 채소와 해산물을 넣고 매콤한 겨자향으로 입맛을 돋우는 한국식 중국 요리.", R.drawable.food07));
        adapter.add(new Food("유린기", "기름을 뿌린 닭고기라는 뜻이며, 양상추, 양파 등의 아삭한 색감을 가진 채소 위에 튀긴 닭고기를 얹은 뒤 청량고추와 홍고추를 가득 담은 간장 소스를 부어 먹는 요리", R.drawable.food08));
        adapter.add(new Food("유산슬", "돼지고기와 해삼 등 육류와 해산물 재료를 실처럼 얇고 길쭉하게 채를 썰고, 그 위에 달콤한 녹말소스를 뿌린 요리", R.drawable.food09));
        adapter.add(new Food("짜장면", "여러 가지 다진 야채와 돼지고기를 넣고 식용유와 중국 된장(춘장)으로 볶은 양념을 국수와 비벼 먹는 한국식 중화요리", R.drawable.food10));
        adapter.add(new Food("짬뽕", "해물 또는 고기와 다양한 야채를 기름에 볶아 닭이나 돼지뼈로 만든 육수를 넣고 매콤하게 끓인 다음 면을 말아 먹는 요리", R.drawable.food11));
        adapter.add(new Food("탕수육", "생선이나 고기를 양념하여 튀겨낸 뒤 녹말소스를 뿌린 요리", R.drawable.food12));
        adapter.add(new Food("팔보채", "해삼, 새우, 오징어, 전복 등의 해물을 죽순, 청경채, 양송이 등의 채소(菜: 나물 채)와 함께 고추기름에 볶은 요리", R.drawable.food13));
    }

}