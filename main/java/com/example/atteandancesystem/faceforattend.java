package com.example.atteandancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;



public class faceforattend extends AppCompatActivity {

    Button sc,test;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faceforattend);
        sc=(Button)findViewById(R.id.cap_bt);
        test=(Button)findViewById(R.id.sc_bt);
        iv=(ImageView)findViewById(R.id.fview_iv);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable=true;
              //  Bitmap myBitmap = BitmapFactory.decodeResource(
                //        getApplicationContext().getResources(),
                  //      R.drawable.test1, options);
            }
        });

    }
}
