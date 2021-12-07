package com.example.a1_simplespinnerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        // 이벤트 설정
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int selectedIndex = spinner.getSelectedItemPosition();
        String[] data = getResources().getStringArray(R.array.spinner_data);
        Toast.makeText(this, data[selectedIndex], Toast.LENGTH_SHORT).show();
    }

    /**
     * spinner에서 항목을 선택했을 때 호출
     * @param parent    : spinner 객체
     * @param view      : 선택된 항목에 대한 view
     * @param position  : 선택된 위치값
     * @param id        : 선택된 위치값
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner:
                String selected_str = (String)parent.getSelectedItem();
                String result = position + "번째 항목 >> " + selected_str;
                textView.setText(result);
                break;
        }
        Log.d("[TEST]",  position + " / " + id);
    }
    // 선택해지가 되었을 때 호출 : 테스트해보면 동작안함
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("[TEST]", "onNothingSelected 호출");
    }
}