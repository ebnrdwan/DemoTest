package com.demo.abdulrahmanrudwan.demotest;

import android.app.Application;

import com.actors.ActorLite;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Abdulrahman Rudwan on 09/01/2018.
 */

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("demoRealm.realm")
                .build();
        ActorLite.with(this);
    }
}
