package com.demo.abdulrahmanrudwan.demotest.nav_silde_Demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.abdulrahmanrudwan.demotest.R;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import com.yarolegovich.slidingrootnav.transform.ScaleTransformation;

public class SlideNavDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_nav_demo);
        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.nav_menu_layout)
                .withDragDistance(140) //Horizontal translation of a view. Default == 180dp
                .withRootViewScale(0.7f) //Content view's scale will be interpolated between 1f and 0.7f. Default == 0.65f;
                .withRootViewElevation(10) //Content view's elevation will be interpolated between 0 and 10dp. Default == 8.
                .withRootViewYTranslation(4) //Content view's translationY will be interpolated between 0 and 4. Default == 0
                .addRootTransformation(new ScaleTransformation(23f))
                .inject();
        new SlidingRootNavBuilder(this)
                .withMenuOpened(true) //Initial menu opened/closed state. Default == false
                .withMenuLocked(false) //If true, a user can't open or close the menu. Default == false.
                .withGravity(SlideGravity.LEFT) //If LEFT you can swipe a menu from left to right, if RIGHT - the direction is opposite.
                .withSavedState(savedInstanceState) //If you call the method, layout will restore its opened/closed state
                .withContentClickableWhenMenuOpened(true) ;//Pretty self-descriptive. Builder Default == true
    }
}
