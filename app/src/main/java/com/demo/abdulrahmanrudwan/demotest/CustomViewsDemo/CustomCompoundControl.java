package com.demo.abdulrahmanrudwan.demotest.CustomViewsDemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.abdulrahmanrudwan.demotest.R;

/**
 * Created by Abdulrahman Rudwan on 13/01/2018.
 */

public class CustomCompoundControl extends LinearLayout implements View.OnClickListener {
    View rootView;
    Button plus;
    Button minus;
    int currentResult = 0;
    TextView result;
    private static final String KEY_SUPER_STATE = "superState";
    private static final String KEY_RESULTS = "results";

    public CustomCompoundControl(Context context) {
        super(context);
        init();
    }

    public CustomCompoundControl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCompoundControl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomCompoundControl(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    void init() {

        // inflate the layout of the custom controller
        LayoutInflater inflater = LayoutInflater.from(getContext());
        rootView = inflater.inflate(R.layout.custom_compound_control, this);

        // define layout members
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        result = findViewById(R.id.result);

        // set listeners for click event
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        // update results based on current result
        updateResults(currentResult);


    }

    void updateResults(int x) {
        currentResult = x;
        plus.setEnabled(currentResult < 10);
        minus.setEnabled(currentResult != 0);
        result.setText(String.valueOf(currentResult));


    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState());
        bundle.putInt(KEY_RESULTS, currentResult);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            currentResult = bundle.getInt(KEY_RESULTS);

            super.onRestoreInstanceState(bundle.getParcelable(KEY_SUPER_STATE));
        } else {
            super.onRestoreInstanceState(state);
        }
        updateResults(currentResult);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.plus:
                updateResults(++currentResult);

                break;
            case R.id.minus:
                updateResults(--currentResult);
                break;


        }

    }
}
