package com.example.a5_dinamiclistitemexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a5_dinamiclistitemexam.R;
import com.example.a5_dinamiclistitemexam.model.Item;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    Activity activity;      // MainActivity 저장
    int resource;           // list_item.xml 파일의 id

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    // 1줄 화면 만들기
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("[TEST]", "position = " + position);

        // 1. 1줄 화면
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. 1줄 데이터
        Item item = getItem(position);
        // 3. 1줄 화면 + 1줄 데이터
        if(item != null) {
            Button button2 = convertView.findViewById(R.id.button2);
            TextView textView = convertView.findViewById(R.id.textView);
            // button 이벤트 설정
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 어댑터 객체를 통해서 list의 데이터 삭제
                    remove(item);
                }
            });

            textView.setText(item.getNum() + " >> " + item.getName());
        }
        // 1줄 화면 리턴
        return convertView;
    }
}
