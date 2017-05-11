package androidlab.epam.com.modulehometask4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private static final String TEXT_PLACEMENT = "777" ;
    private ImageView imageTouch;
    private TextView textMove;
    private float x;
    private float y;
    private static int textPlacement=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageTouch= (ImageView)findViewById(R.id.image_touch);
        Picasso.with(this)
                .load( "https://static.baza.farpost.ru/v/1459084418662_bulletin")
                .into(imageTouch);
        imageTouch.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        textMove = (TextView) findViewById(R.id.text_move);
        Toast toast = Toast.makeText(getApplicationContext(),"AMAZING!",Toast.LENGTH_SHORT);
        toast.show();
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        switch(textPlacement){
            case 1: param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                textPlacement=2;
                break;
            case 2: param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                textPlacement=3;
                break;
            case 3: param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                textPlacement=4;
                break;
            case 4: param.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                textPlacement=1;
                break;
        }
        textMove.setLayoutParams(param);
        return false;
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(TEXT_PLACEMENT, textPlacement);
        super.onSaveInstanceState(outState);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        switch (savedInstanceState.getInt(TEXT_PLACEMENT)){
            case 1:param.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                break;
            case 2: param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                break;
            case 3: param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            case 4: param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
        }
        textMove = (TextView) findViewById(R.id.text_move);
        textMove.setLayoutParams(param);
    }

}
