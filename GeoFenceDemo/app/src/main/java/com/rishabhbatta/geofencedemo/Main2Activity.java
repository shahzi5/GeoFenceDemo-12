package com.rishabhbatta.geofencedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1=(Button) findViewById(R.id.loc);
        button2=(Button) findViewById(R.id.loc1);
        button3=(Button) findViewById(R.id.time1);

    }


    public void location(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void location1(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void time(View view){
        Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }


}
