package com.alejandrolg.toucevents;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener{

    private  static final String DEBUG_TAG = "Gesture";
    private GestureDetectorCompat mDetector;
    private ConstraintLayout view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        this.view = (ConstraintLayout) findViewById(R.id.home_view);
}
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        TextView textView = findViewById(R.id.hello_world);
        textView.setText("Touch coordinates : " +
                String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.view.setBackgroundColor(Color.YELLOW);
        TextView textView = findViewById(R.id.que_colores);
        textView.setText("Que pedo raza");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.view.setBackgroundColor(Color.RED);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        this.view.setBackgroundColor(Color.GREEN);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        this.view.setBackgroundColor(Color.CYAN);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        this.view.setBackgroundColor(Color.BLACK);

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.view.setBackgroundColor(Color.WHITE);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
