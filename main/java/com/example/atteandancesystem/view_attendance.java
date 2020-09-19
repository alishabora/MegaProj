package com.example.atteandancesystem;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.atteandancesystem.signin;
import android.widget.TextView;
import android.widget.Toast;

public class view_attendance extends AppCompatActivity {

    Button vw,back;
    DatabaseHelper myDb;
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb=new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        back=(Button)findViewById(R.id.back_bt);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView8);
        tv3=(TextView)findViewById(R.id.textView14);
        gloabaldata application=(gloabaldata) getApplication();
        String un=application.getuname();
        Cursor res = myDb.getAttend("Alisha");
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }
        else
        {
            res.moveToFirst();
            String dt=res.getColumnName(1) ;
            String td=res.getColumnName(2);
            tv1.setText(28+" "+"12.15 GMT");
            tv2.setText("Alisha");
            tv3.setText("P");
         }

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(view_attendance.this,student_dashboard.class);
                 startActivity(i);





                //System.exit(0);
            }
        });

    }
        public void showMessage(String title,String Message){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();
        }
}
