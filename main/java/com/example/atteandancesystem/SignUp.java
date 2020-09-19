package com.example.atteandancesystem;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
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

public class SignUp extends AppCompatActivity {

    DatabaseHelper myDb,myDb1;
    Toolbar toolbar;
    EditText email,password,name,etype;

    ImageButton signup;
    Button signin;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb = new DatabaseHelper(this);
        myDb1=new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText)findViewById(R.id.email_et);
        password = (EditText)findViewById(R.id.pass_et);
        name = (EditText)findViewById(R.id.name_et);
        etype=(EditText) findViewById(R.id.usertype_et);


        signup =(ImageButton)findViewById(R.id.signup_bt);

        signin = (Button) findViewById(R.id.signin);
        awesomeValidation.addValidation(this, R.id.name_et, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.pass_et, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(), "Validation Successful", Toast.LENGTH_LONG).show();
                    Cursor res = myDb1.getAllData(email.getText().toString());
                    if(res.getCount() == 0) {
                        // show message

                    boolean isInserted = myDb.insertData(name.getText().toString(),email.getText().toString(), password.getText().toString(),etype.getText().toString());
                    if(isInserted == true)
                        Toast.makeText(SignUp.this,"Data Inserted",Toast.LENGTH_LONG).show();


                    else
                        Toast.makeText(SignUp.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        showMessage("Error","Email Already Registered");
                        return;
                    }
                }

name.setText(" ");
                email.setText(" ");
                password.setText(" ");
                etype.setText(" ");

              // boolean isinsertedData= myDb.insertData("alisha","alisha@gmail.com","ali1234","Student");



            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,signin.class);
                startActivity(i);
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