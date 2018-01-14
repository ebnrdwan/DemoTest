package com.demo.abdulrahmanrudwan.demotest.CustomViewsDemo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.demo.abdulrahmanrudwan.demotest.R;


public class CustomViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        CustomTextView customTextView = new CustomTextView(this);
//        setContentView(customTextView);
        CustomCompoundControl compoundControl = findViewById(R.id.custom_control);
//        compoundControl.setOnClickListener(new);

    }
}
