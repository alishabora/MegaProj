package com.example.atteandancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;

public class parent_email extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button back;
    ImageButton sendbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_email);
        editTextTo=(EditText)findViewById(R.id.to_ev);
        editTextSubject=(EditText)findViewById(R.id.emadd_et);
        editTextMessage=(EditText)findViewById(R.id.msg_et);
        sendbt=(ImageButton)findViewById(R.id.send_bt);
        back=(Button)findViewById(R.id.dash_bt);

        sendbt.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });

        back.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {

                Intent dboard=new Intent(parent_email.this,Teacher_dashboard.class);
                startActivity(dboard);

            }

        });

    }
}
