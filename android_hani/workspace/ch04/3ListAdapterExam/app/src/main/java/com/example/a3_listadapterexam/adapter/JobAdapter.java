package com.example.a3_listadapterexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a3_listadapterexam.R;
import com.example.a3_listadapterexam.model.Job;

import java.util.List;

// 리스트 객체에 데이터를 저장하거나 읽어올 때는 반드시 어댑터 객체를 사용해야함
public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;  // MainActivity 객체 저장
    int resource;       // list_item.xml 파일의 id 저장

    /**
     * MainActivity에서 사용하는 생성자
     * @param context   : activity가 전달됨
     * @param resource  : list_item.xml 파일의 id가 전달됨
     * @param objects   : list객체가 전달됨
     */
    public JobAdapter(@NonNull Context context, int resource, @NonNull List<Job> objects) {
        super(context, resource, objects);  // 이 줄 이후로 어댑터 객체가 리스트 객체를 관리함
        activity = (Activity) context;
        this.resource = resource;
    }

    /** 1줄화면 + 1줄데이터 결합하는 기능의 함수
     * => ListView가 List에 저장된 데이터 갯수만큼 호출하는 함수
     * @param position      : list 객체의 데이터 위치값
     * @param convertView   : 1줄화면을 관리하는 객체
     * @param parent        : ListView 객체(사용안함)
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1줄화면 객체가 null이면
        if(convertView == null) {
            // 1. 1줄 화면 만들기
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 2. list에서 데이터 1개 꺼내기
        Job item = getItem(position);
        // 3. 1줄화면 + 1줄 데이터
        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            // 화면 설정
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }
        // 4. 1줄화면 리턴
        return convertView;
    }
}
