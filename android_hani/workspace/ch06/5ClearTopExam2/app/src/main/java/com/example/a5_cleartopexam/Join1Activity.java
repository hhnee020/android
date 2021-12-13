package com.example.a5_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Join1Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join1);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = editText1.getText().toString().trim();
        String pw = editText2.getText().toString().trim();

        Intent intent = new Intent(this, Join2Activity.class);
        intent.putExtra("id", id);
        intent.putExtra("pw", pw);
        startActivity(intent);
    }
}