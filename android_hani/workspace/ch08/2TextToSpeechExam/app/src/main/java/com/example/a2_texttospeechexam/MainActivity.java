package com.example.a2_texttospeechexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/*
    TTS 엔진이 무겁기 때문에, 초기화 시간이 오래 걸린다.(1초)
    초기화 작업은 백그라운드로 실행되며, 초기화가 완료되면 이벤트를 발생시킨다.
 */
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, TextToSpeech.OnInitListener {
    EditText editText;
    Button button;
    TextToSpeech tts;
    boolean init;   // tts 객체 초기화 여부 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        tts = new TextToSpeech(this, this);
        // 이벤트 설정
        button.setOnClickListener(this);
        // tts 초기화 설정
        init = false;
    }

    @Override
    public void onInit(int status) {
        init = (status == TextToSpeech.SUCCESS);

        String msg = "";
        if(init) msg = "엔진이 초기화 되었습니다.";
        else msg = "엔진이 초기화에 실패했습니다.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    // 액티비티가 종료되기 직전에 자동 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // tts는 앱이 종료되어도 메모리에 상주하기 때문에
        // 앱이 종료될 시점에 메모리에서 해제시켜야 한다.
        if(tts != null) {
            tts.stop();     // 음성 출력 정지
            tts.shutdown(); // tts 종료
        }
    }

    @Override
    public void onClick(View v) {
        if(!init) {
            Toast.makeText(this, "아직 초기화 되지 않았습니다.",
                    Toast.LENGTH_SHORT).show();
            return;     // 함수 강제 종료
        }
        // 입력값 저장
        String msg= editText.getText().toString().trim();
        // 입력 검사
        if(msg.equals("")) {
            Toast.makeText(this, "내용을 입력하세요",
                    Toast.LENGTH_SHORT).show();
            return;     // 함수 강제 종료
        }
        // 사용할 언어 설정
        Locale loc = Locale.KOREA;
        // 해당언어를 지원하는 지 검사
        int available = tts.isLanguageAvailable(loc);
        if(available < 0) {
            Toast.makeText(this, "지원되지 않는 언어입니다.",
                    Toast.LENGTH_SHORT).show();
            return;     // 함수 강제 종료
        }

        // tts 동작
        tts.setLanguage(loc);
        tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
    }
}