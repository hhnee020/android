package com.example.apptest1.apptest;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apptest1.R;
import com.example.apptest1.model.Food;

import java.util.List;

public class Adapter extends ArrayAdapter<Food> {
    Activity activity;
    int resource;


    public Adapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);  // 이 줄 이후로 어댑터 객체가 리스트 객체를 관리함
        activity = (Activity) context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            // 1. 1줄 화면 만들기
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }

        Food item = getItem(position);

        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }

        return convertView;
    }
}
