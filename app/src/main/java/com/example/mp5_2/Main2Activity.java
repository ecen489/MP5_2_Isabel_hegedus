package com.example.mp5_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    String[][] questions = new String[3][];
    String[][] answers = new String[3][];
    int sel=0;
    int quest=0;
    String[] topics = {"top1","top2","top3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        questions[0] = getResources().getStringArray(R.array.t1q);
        questions[1] = getResources().getStringArray(R.array.t2q);
        questions[2] = getResources().getStringArray(R.array.t3q);

        answers[0] = getResources().getStringArray(R.array.t1a);
        answers[1] = getResources().getStringArray(R.array.t2a);
        answers[2] = getResources().getStringArray(R.array.t3a);







    }

    protected void onResume(){
        super.onResume();
        //String extra = getIntent().getStringExtra("TOPIC");
        Bundle extras =getIntent().getExtras();
        String extra= extras.getString("TOPIC");
        System.out.print(extra);
        System.out.print(extras);
        try{sel= Integer.parseInt(extra)-1;}
        catch (NumberFormatException n){
            System.out.println("ya done goofed");

        }
        //sel=extra;
        Random r = new Random();
        quest=r.nextInt(questions[sel].length);
        TextView teee = findViewById(R.id.ques);
        teee.setText(questions[sel][quest]);
        TextView teeee = findViewById(R.id.topic);
        teeee.setText(topics[sel]);
    }

    public void butt(View v){
        String ans ="";
        EditText et = findViewById(R.id.edText);
        ans=et.getText().toString();
        int correct =Integer.parseInt(getIntent().getStringExtra("SCORE"));
        if(ans.equals(answers[sel][quest])){
            correct+=1;
        }

        Intent in =new Intent(getBaseContext(),MainActivity.class);
        in.putExtra("CORRECT",Integer.toString(correct));
        startActivity(in);


    }
}
