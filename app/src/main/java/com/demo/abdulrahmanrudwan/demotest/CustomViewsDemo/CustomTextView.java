package com.demo.abdulrahmanrudwan.demotest.CustomViewsDemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Abdulrahman Rudwan on 10/01/2018.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);

        setText("hey there from the custom editText ");
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setText("hey there from the custom editText ");
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setText("hey there from the custom editText ");
    }

}
