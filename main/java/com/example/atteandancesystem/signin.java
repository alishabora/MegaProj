package com.example.atteandancesystem;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class signin extends AppCompatActivity {

    Toolbar toolbar;
    EditText email,password;
    ImageButton signin;
    Button signup;
    private AwesomeValidation awesomeValidation;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb=new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        signin =(ImageButton)findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.password, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(), "Validation Successful", Toast.LENGTH_LONG).show();
                    Cursor res = myDb.getAllData(email.getText().toString());
                    if(res.getCount() == 0) {
                        // show message
                        showMessage("Error","Nothing found");
                        return;
                    }
                    else
                    {
                        res.moveToFirst();
                        gloabaldata application=(gloabaldata) getApplication();
                        final String id=res.getString(1);
                        application.setuname(id);
                        String resdata=res.getString(4);
                        application.setcat(resdata);
                        if(resdata.equals("Student"))
                        {
                            finish();
                            Intent i = new Intent(signin.this,student_dashboard.class);
                            startActivity(i);
                        }
                        else
                        {
                            finish();
                            Intent i = new Intent(signin.this,Teacher_dashboard.class);
                            startActivity(i);
                        }
                        //showMessage("NoError",resdata);
                        return;
                    }
                }

                    //process the data further
                }


        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signin.this,SignUp.class);
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

