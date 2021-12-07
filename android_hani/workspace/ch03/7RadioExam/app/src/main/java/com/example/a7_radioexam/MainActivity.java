package com.example.a7_radioexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;
    TextView textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        // 이벤트 설정
        radioGroup.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int checkedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(checkedId);
        Toast.makeText(this, radioButton.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.radioGroup:
                RadioButton radioButton = findViewById(checkedId);
                textView2.setText(radioButton.getText().toString());
                break;
        }
    }
}