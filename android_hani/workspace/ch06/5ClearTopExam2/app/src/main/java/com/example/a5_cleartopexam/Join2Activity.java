package com.example.a5_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Join2Activity extends AppCompatActivity implements View.OnClickListener {
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = getIntent().getStringExtra("id");
        String pw = getIntent().getStringExtra("pw");
        String hobby = "";

        if(checkBox1.isChecked()) {
            hobby += checkBox1.getText().toString() + " ";
        }
        if(checkBox2.isChecked()) {
            hobby += checkBox2.getText().toString() + " ";
        }
        if(checkBox3.isChecked()) {
            hobby += checkBox3.getText().toString();
        }

        Intent intent = new Intent(this, Join3Activity.class);
        intent.putExtra("id", id);
        intent.putExtra("pw", pw);
        intent.putExtra("hobby", hobby);
        startActivity(intent);
    }
}