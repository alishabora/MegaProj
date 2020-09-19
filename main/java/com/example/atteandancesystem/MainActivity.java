package com.example.atteandancesystem;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

ImageButton img_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_bt=(ImageButton) findViewById(R.id.start_imgbt);
        img_bt.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent s;
                s = new Intent(MainActivity.this,signin.class);
                startActivity(s);
        }
        });
        }



}






