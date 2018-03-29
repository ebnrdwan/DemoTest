package com.demo.abdulrahmanrudwan.demotest.CustomViewsDemo;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.demo.abdulrahmanrudwan.demotest.R;

/**
 * Created by Abdulrahman Rudwan on 28/01/2018.
 */

public class CustomEditText extends TextInputLayout {
    private View rootView;
    EditText editText;

    public CustomEditText(Context context) {
        super(context);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }


    void init() {

        // inflate the layout of the custom controller
        LayoutInflater inflater = LayoutInflater.from(getContext());
        rootView = inflater.inflate(R.layout.custom_edit_text,this);
        editText = rootView.findViewById(R.id.etEmail);
        editText.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_blue_bright), PorterDuff.Mode.SRC_ATOP);




    }


}
