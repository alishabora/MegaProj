package com.example.atteandancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class student_dashboard extends AppCompatActivity {

    ImageButton stu_attend,atd_view,time_table;
    Button back_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        stu_attend =(ImageButton)findViewById(R.id.cap_ibt);
        atd_view=(ImageButton)findViewById(R.id.att_ibt);
        //time_table=(ImageButton)findViewById(R.id.tb_ibt);
     //   event_cal=(ImageButton)findViewById(R.id.ev_ibt);
        back_bt=(Button)findViewById(R.id.bt_back);

        stu_attend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
               Intent i = new Intent(student_dashboard.this,facerec_attend.class);
                startActivity(i);
            }
        });

        atd_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(student_dashboard.this,view_attendance.class);
                startActivity(i);
            }
        });



        back_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(Teacher_dashboard.this,add_student_details.class);
                // startActivity(i);
                finish();
            }
        });


    }
}
