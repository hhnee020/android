package com.example.booklist.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booklist.R;
import com.example.booklist.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    Activity activity;  // MainActivity 객체 저장
    int resource;       // list_item.xml 파일의 id

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);   // 이줄 이후부터 어댑터가 리스트를 관리함
        activity = (Activity) context;
        this.resource = resource;
    }
    // 1줄 화면 만들기
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1. 1줄 화면
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. 1줄 데이터
        Book item = getItem(position);
        // 3. 1줄 화면 + 1줄 데이터
        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);
            // 1줄화면 설정
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getSubject());
            textView2.setText(item.getWriter());
            textView3.setText(item.getPublisher());
        }
        // 4. 1줄 화면 리턴
        return convertView;
    }
}





