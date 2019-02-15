package com.example.mp5_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onResume(){
        super.onResume();
        String extra= getIntent().getStringExtra("CORRECT");
        if(extra!=null){
            try{score=score+Integer.parseInt(extra);}
            catch(NumberFormatException n){

            }
            upScore();
        }
    }

    public void top1(View v){
        startQuest("1");
    }

    public void top2(View v){
        startQuest("2");
    }

    public void top3(View v){
        startQuest("3");
    }
    public void upScore(){
        TextView t =findViewById(R.id.sbd);
        t.setText(Integer.toString(score));
    }

    public void startQuest(String topic){
        Intent in = new Intent(getBaseContext(),Main2Activity.class);
        in.putExtra("TOPIC", topic);
        in.putExtra("SCORE",Integer.toString(score));
        startActivity(in);
    }

    public void reset(View v){
        score=0;
        upScore();

    }
}
