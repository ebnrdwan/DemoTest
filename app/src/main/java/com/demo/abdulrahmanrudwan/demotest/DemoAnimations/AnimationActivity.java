package com.demo.abdulrahmanrudwan.demotest.DemoAnimations;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.demo.abdulrahmanrudwan.demotest.R;

public class AnimationActivity extends AppCompatActivity implements Animation.AnimationListener {

    ImageView image;
    Button alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        image = findViewById(R.id.iv_anim);
        alpha = findViewById(R.id.button);

    }

    public void playAnim(View view) {
        switch (view.getId()) {
            case R.id.button:
                setAnimation(R.anim.alpha_anim);

                break;
            case R.id.button2:
                setAnimation(R.anim.scale_anim);
                break;
            case R.id.button3:
                setAnimation(R.anim.translate_anim);
                break;
            case R.id.button4:
                setAnimation(R.anim.rotate_anim);
                break;
            default:
                setAnimation(R.anim.fadein_anim);

        }
    }

    public void scaleAnimation(View view) {
        Animation mScaleAnim
                = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        mScaleAnim.setAnimationListener(this);
        image.startAnimation(mScaleAnim);
    }

    void setAnimation(int animation) {
        Animation anim = AnimationUtils.loadAnimation(this, animation);
        anim.setAnimationListener(this);
        image.setAnimation(anim);
        image.startAnimation(anim);
    }


    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(this, "strted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(this, "end", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
