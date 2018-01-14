package com.demo.abdulrahmanrudwan.demotest.CustomActorLite;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.actors.Actor;
import com.actors.Message;
import com.demo.abdulrahmanrudwan.demotest.R;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ActorLiteActivity extends AppCompatActivity implements Actor {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_lite);

    }

    @Override
    public void onMessageReceived(Message message) {

        Toast.makeText(ActorLiteActivity.this,"message is "+message.toString(),Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Scheduler observeOnScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
