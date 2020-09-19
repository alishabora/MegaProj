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

public class add_student_details extends AppCompatActivity {

    EditText sn,semail,spmail,imurl,syr;
    Button back;
    ImageButton submit;
    DatabaseHelper myDb;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        setContentView(R.layout.activity_add_student_details);
        sn = (EditText)findViewById(R.id.name_et);
        semail = (EditText)findViewById(R.id.email_et);
        spmail = (EditText)findViewById(R.id.parentemail_et);
        imurl=(EditText) findViewById(R.id.iurl_et);
        syr=(EditText) findViewById(R.id.syear_et);
        submit=(ImageButton)findViewById(R.id.subdata_bt);
        myDb = new DatabaseHelper(this);
        back=(Button)findViewById(R.id.back_bt) ;

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //if (awesomeValidation.validate()) {
                   // Toast.makeText(getApplicationContext(), "Validation Successful", Toast.LENGTH_LONG).show();
                   // boolean isInserted = myDb.insertData1("abc","abc.gmail.com", "abcdad@gmail.com","d","BE");
                   boolean isInserted = myDb.insertData1(sn.getText().toString(),semail.getText().toString(), spmail.getText().toString(),imurl.getText().toString(),syr.getText().toString());

                if(isInserted == true)
                        Toast.makeText(add_student_details.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else
                       Toast.makeText(add_student_details.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                    sn.setText(" ");
                    semail.setText(" ");
                    spmail.setText(" ");
                    imurl.setText(" ");
                    syr.setText(" ");

                }


                //



            //}
        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(add_student_details.this,Teacher_dashboard.class);
                startActivity(i);





                //System.exit(0);
            }
        });

    }
}
