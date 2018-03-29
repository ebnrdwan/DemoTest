package com.demo.abdulrahmanrudwan.demotest;

import android.app.Application;
import android.content.Context;


import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Abdulrahman Rudwan on 09/01/2018.
 */

public class DemoApplication extends Application {
  public static DemoApplication instance;
  Context context ;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("demoRealm.realm")
                .build();
      context  = getApplicationContext();

    }

    public static DemoApplication getInstance() {
       if (instance == null) instance = new DemoApplication();
        return instance;
    }

    public static Context getContext(){
        if (instance == null)
            instance = new DemoApplication();

        return instance.getApplicationContext();
        // or return instance.getApplicationContext();
    }

}
