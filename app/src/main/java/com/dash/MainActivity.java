package com.dash;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        reverseTimer(300,textView);     // Time assigned for 5 minutes (in seconds)
    }

    public void reverseTimer(int Seconds, final TextView textView){
        new CountDownTimer(Seconds*1000+1000,1000){
            public void onTick(long millisUntilFinished){
                int seconds=(int)(millisUntilFinished/1000);
                int minutes=seconds/60;
                seconds=seconds%60;
                int hours=minutes/60;
                minutes=minutes%60;
                textView.setText(String.format("%02d",hours)+":"+String.format("%02d",minutes)+":"+String.format("%02d",seconds));
            }
                    public void onFinish(){
                     textView.setText(R.string.text);
            }
        }.start();
    }

}
