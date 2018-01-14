package com.demo.abdulrahmanrudwan.demotest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.ex.chips.BaseRecipientAdapter;
import com.android.ex.chips.RecipientEditTextView;
import com.android.ex.chips.recipientchip.DrawableRecipientChip;

import java.util.List;

public class DemoChips extends AppCompatActivity {

    String ss = " styetuetryi, dgjfgjdtk, <xfjdgjfyj>, <57dyiryireu5>, ";
   RecipientEditTextView phoneRetv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_chips);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         phoneRetv =
                (RecipientEditTextView) findViewById(R.id.phone_retv);
        phoneRetv.setMaxChips(20);
    setText(ss);
        phoneRetv.setChipNotCreatedListener(new RecipientEditTextView.ChipNotCreatedListener() {
            @Override
            public void chipNotCreated(String chipText) {
                Toast.makeText(DemoChips.this, "You set the max number of chips to 20. Chip not created for: " + chipText, Toast.LENGTH_SHORT).show();
            }
        });
        phoneRetv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        BaseRecipientAdapter adapter = new BaseRecipientAdapter(BaseRecipientAdapter.QUERY_TYPE_PHONE, this);
        adapter.setShowMobileOnly(true);
        String [] items = {"arabic","english"};
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        phoneRetv.setAdapter(adapter);
        phoneRetv.dismissDropDownOnItemSelected(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DrawableRecipientChip[] chips = phoneRetv.getSortedRecipients();
                for (DrawableRecipientChip chip : chips) {
                    Log.v("DrawableChip", chip.getEntry().getDisplayName() + " " + chip.getEntry().getDestination());
                }
            }
        }, 5000);

        final ImageButton showAll = (ImageButton) findViewById(R.id.show_all);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneRetv.showDropDown();
                Log.d("TT",getText(phoneRetv.getText().toString()));
            }
        });
    }
    int count = 0;
    String getText(String response) {
        if (response == null) {
            return "";
        } else {
            String regx = "<";
            response = response.replaceAll(regx, "");
            response = response.replaceAll(">", "");

            return response;
        }
    }
    private void setText(String str) {

        final String[] names = str.split(",");
        count = names.length-1;


        final Handler h = new Handler();

        Runnable r = new Runnable() {

            @Override
            public void run() {


                String s = names[(names.length-1) - (count)];
                count--;
                phoneRetv.append(s + ",");
                if (count > 0)
                    h.postDelayed(this, 50);
            }
        };
        h.post(r);

    }

}