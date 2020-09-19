package com.example.atteandancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class Teacher_dashboard extends AppCompatActivity {


    ImageButton stu_add,atd_view,par_mail,time_table;
    Button back_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
        stu_add =(ImageButton)findViewById(R.id.stuadd_ibt);
        atd_view=(ImageButton)findViewById(R.id.att_ibt);
        par_mail=(ImageButton)findViewById(R.id.pmail_ibt);
        time_table=(ImageButton)findViewById(R.id.tt_ibt);

        back_bt=(Button)findViewById(R.id.bt_back);

        stu_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Teacher_dashboard.this,add_student_details.class);
                startActivity(i);
            }
        });

        atd_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Teacher_dashboard.this,view_attendance.class);
                startActivity(i);
            }
        });
        par_mail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Teacher_dashboard.this,parent_email.class);
                startActivity(i);
            }
        });

        time_table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Teacher_dashboard.this,entertimetable.class);
                startActivity(i);
            }
        });

        back_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(Teacher_dashboard.this,add_student_details.class);
               // startActivity(i);
                System.exit(0);
            }
        });


    }
}
