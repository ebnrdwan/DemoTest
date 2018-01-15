package com.demo.abdulrahmanrudwan.demotest.EventBusDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.demo.abdulrahmanrudwan.demotest.MainActivity;
import com.demo.abdulrahmanrudwan.demotest.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        // Create Instance of EventBus subscriber at first
        EventBus.getDefault().register(this);
        publisher("hey there");



    }

    @Subscribe(threadMode = ThreadMode.MAIN ) // subscribe methods must be public otherwise it will crash
    public void onEvent(MessageEvent event) {
        Toast.makeText(this, "Hey, my message" + event.getMessage(), Toast.LENGTH_SHORT).show();
    }


    void publisher(String ee) {  // invoke it from any location in your project
        EventBus.getDefault().post(ee);
        Log.d("QQ","publish");
    }



    @Override
    public void onStop() {
        // unregister in onPause or OnDestroy
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    public class MessageEvent {

        public String mMessage;

        public MessageEvent(String message) {
            mMessage = message;
        }

        public String getMessage() {
            return mMessage;
        }
    }
}
