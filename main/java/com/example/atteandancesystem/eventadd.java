package com.example.atteandancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

public class eventadd extends AppCompatActivity {
    DatabaseHelper myDb;
    Toolbar toolbar;
    EditText evn,dt;

    ImageButton submit;
    Button vw,back;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventadd);
        myDb = new DatabaseHelper(this);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        evn=(EditText)findViewById(R.id.ev_et);
        dt=(EditText)findViewById(R.id.dt_et);
        submit=(ImageButton)findViewById(R.id.subdata_bt);
        back=(Button)findViewById(R.id.back_bt);
        vw=(Button) findViewById(R.id.vw_bt);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //if (awesomeValidation.validate()) {
                // Toast.makeText(getApplicationContext(), "Validation Successful", Toast.LENGTH_LONG).show();
                // boolean isInserted = myDb.insertData1("abc","abc.gmail.com", "abcdad@gmail.com","d","BE");
                boolean isInserted = myDb.insertData3(evn.getText().toString(),dt.getText().toString());

                if(isInserted == true)
                    Toast.makeText(eventadd.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(eventadd.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }


            //



            //}
        });

    }
}
