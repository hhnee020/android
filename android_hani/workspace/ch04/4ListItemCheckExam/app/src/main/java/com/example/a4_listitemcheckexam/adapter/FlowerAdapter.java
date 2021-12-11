package com.example.a4_listitemcheckexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a4_listitemcheckexam.R;
import com.example.a4_listitemcheckexam.model.Flower;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {
    Activity activity;
    int resource;

    public FlowerAdapter(@NonNull Context context, int resource, @NonNull List<Flower> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    // 1줄 화면만들기
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1. 1줄 화면
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. 1줄 데이터
        Flower item = getItem(position);
        // 3. 1줄 화면 + 1줄 데이터
        if(item != null) {
            CheckBox checkBox = convertView.findViewById(R.id.checkBox);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            // checkBox 이벤트 설정
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // checkBox의 상태를 flower 객체에 저장
                    item.setCheck(isChecked);
                }
            });
            // 화면설정
            checkBox.setChecked(item.isCheck());
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }
        // 4. 1줄 화면 리턴
        return convertView;
    }
}












