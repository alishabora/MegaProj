package com.example.atteandancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import com.basgeekball.awesomevalidation.model.NumericRange;
import com.basgeekball.awesomevalidation.validators.BasicValidator;
import com.basgeekball.awesomevalidation.validators.ColorationValidator;
import com.basgeekball.awesomevalidation.validators.Validator;
import com.basgeekball.awesomevalidation.validators.UnderlabelValidator;
import java.util.regex.Pattern;
import android.util.Patterns;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;
import android.database.Cursor;
import android.widget.Toast;

public class entertimetable extends AppCompatActivity {

    EditText d,t,syr,sub,teac,knd;
    Button back1,update;
    ImageButton submit;
    DatabaseHelper myDb;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertimetable);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        d = (EditText)findViewById(R.id.day_et);
        t = (EditText)findViewById(R.id.time_et);
        syr = (EditText)findViewById(R.id.yrr_et);
        sub=(EditText) findViewById(R.id.sub_et);
        teac=(EditText) findViewById(R.id.tea_et);
        knd=(EditText) findViewById(R.id.form_et);
        submit=(ImageButton)findViewById(R.id.subdata_bt);
        back1=(Button)findViewById(R.id.back_bt);
        update=(Button)findViewById(R.id.uo_bt);

        myDb = new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //if (awesomeValidation.validate()) {
                // Toast.makeText(getApplicationContext(), "Validation Successful", Toast.LENGTH_LONG).show();
                 //boolean isInserted = myDb.insertData1("abc","abc.gmail.com", "abcdad@gmail.com","d","BE");
              boolean isInserted = myDb.insertData2(d.getText().toString(),t.getText().toString(), syr.getText().toString(),sub.getText().toString(),teac.getText().toString(),knd.getText().toString());


                if(isInserted == true)
                    Toast.makeText(entertimetable.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else

                    Toast.makeText(entertimetable.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                d.setText(" ");
                t.setText(" ");
                syr.setText(" ");
                sub.setText(" ");
                teac.setText(" ");
                knd.setText(" ");

            }


            //



            //}
        });

        back1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(entertimetable.this,Teacher_dashboard.class);
                startActivity(i);
            }
        });


    }
}
