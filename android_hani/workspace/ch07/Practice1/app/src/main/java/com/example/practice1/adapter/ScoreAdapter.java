package com.example.practice1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practice1.R;
import com.example.practice1.model.Score;

import java.util.List;

public class ScoreAdapter extends ArrayAdapter<Score> {
    Activity activity;
    int resource;

    public ScoreAdapter(@NonNull Context context, int resource, @NonNull List<Score> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1줄 화면
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 1줄 데이터
        Score item = getItem(position);
        // 1줄 화면 + 1줄 데이터
        if(item != null) {
            TextView textView = convertView.findViewById(R.id.textView);
            textView.setText(item.toString());
        }
        // 1줄 화면 리턴
        return convertView;
    }
}
