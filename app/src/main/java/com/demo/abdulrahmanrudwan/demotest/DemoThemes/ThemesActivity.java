package com.demo.abdulrahmanrudwan.demotest.DemoThemes;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.abdulrahmanrudwan.demotest.R;

public class ThemesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        TextView headerText = findViewById(R.id.styled_text);
        LinearGradient gradient = new LinearGradient(0,0,0,headerText.getTextSize(), Color.RED,Color.GREEN, Shader.TileMode.MIRROR);
        headerText.getPaint().setShader(gradient);

    }
}
