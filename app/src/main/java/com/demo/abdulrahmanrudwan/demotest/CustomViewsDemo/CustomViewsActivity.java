package com.demo.abdulrahmanrudwan.demotest.CustomViewsDemo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;
import com.demo.abdulrahmanrudwan.demotest.R;


public class CustomViewsActivity extends AppCompatActivity {

    CircleImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        CustomTextView customTextView = new CustomTextView(this);
        imageView = findViewById(R.id.circle);
        imageView.setOnItemSelectedClickListener(new ItemSelectedListener() {
            @Override
            public void onSelected(View view) {
                view.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
            }

            @Override
            public void onUnselected(View view) {
                view.setBackgroundColor(getResources().getColor(R.color.materialYellow));
            }
        });
        EditText editText = findViewById(R.id.et_test);
        Drawable leftDrawable = getResources().getDrawable(R.drawable.ic_contact_picture);
        leftDrawable.setBounds( 0, 0, 100, 100 );

        editText.setCompoundDrawables(leftDrawable,null,null,null);
        editText.setCompoundDrawablePadding(8);
//        editText.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_contact_picture, 0, 0, 0);
//        setContentView(customTextView);
        CustomCompoundControl compoundControl = findViewById(R.id.custom_control);
        editText.setBackgroundColor(Color.BLUE);
        editText.setHintTextColor(Color.RED);
        int[][] states = new int[][] {
//                new int[] { android.R.attr.state_focused}, // enabled
//                new int[] {-android.R.attr.state_enabled}, // disabled
//                new int[] {-android.R.attr.state_checked}, // unchecked
//                new int[] { android.R.attr.state_window_focused},  // pressed
                new int[] {android.R.attr.colorControlNormal},
                new int[]{android.R.attr.colorActivatedHighlight},
                new int[]{android.R.attr.colorControlHighlight}

        };

        int[] colors = new int[] {
//                Color.GREEN,
//                Color.BLUE,
                Color.YELLOW,
//                Color.GRAY,
                Color.RED,
                Color.CYAN
        };

        ColorStateList myColorAccentList = new ColorStateList(states, colors);
      editText.setBackgroundTintList(myColorAccentList);
//        tintColorWidget(editText,Color.CYAN);
//        compoundControl.setOnClickListener(new);

    }
    public void tintColorWidget(View view, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(view.getBackground());
        view.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
//        view.setBackgroundDrawable(wrappedDrawable);
//        view.setBackground(wrappedDrawable);
    }
}
