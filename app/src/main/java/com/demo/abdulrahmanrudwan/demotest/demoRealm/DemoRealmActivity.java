package com.demo.abdulrahmanrudwan.demotest.demoRealm;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.abdulrahmanrudwan.demotest.DemoApplication;
import com.demo.abdulrahmanrudwan.demotest.R;

import java.sql.Driver;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

public class DemoRealmActivity extends AppCompatActivity {

    Realm realm;
    RealmAsyncTask realmAsyncTask;
    String id;
    TextView outPut;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_realm);
        outPut = findViewById(R.id.output);
      imageView = findViewById(R.id.imageView);
        realm = Realm.getDefaultInstance();

    }


    public void addDriver(View view) {
//        realm.beginTransaction();
        // doesn't have success or error listeners
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                id = UUID.randomUUID().toString();
                /* primary key just passed to the constructor of the RealmObject
                 * if you set the (id) to the object by driverModel.setId() method it will throw exception
                 */
                DriverModel driverModel = realm.createObject(DriverModel.class, id);
                driverModel.setName("ahmed");
                driverModel.setJob("BMW");
                Toast.makeText(DemoRealmActivity.this, "added successfully", Toast.LENGTH_SHORT).show();
            }
        });


        // adding realm request asyncronously to background with success , error listeners
        realmAsyncTask = realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                id = UUID.randomUUID().toString();
                DriverModel driverModel = realm.createObject(DriverModel.class, id);
                driverModel.setName("background ahmed");
                driverModel.setJob("background BMW");
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(DemoRealmActivity.this, "background added successfully", Toast.LENGTH_SHORT).show();

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(DemoRealmActivity.this, "background error", Toast.LENGTH_SHORT).show();

            }
        });

//        realm.commitTransaction();
    }
    public void DisplayAll(View view) throws ExecutionException, InterruptedException {

        DemoApplication demoApplication = new DemoApplication();
        // querying with fluid interface
        RealmResults <DriverModel> realmResults =  realm.where(DriverModel.class)
                .contains("name","ahmed", Case.INSENSITIVE)
                .findAll();
        Log.d(DemoRealmActivity.class.getSimpleName(),realmResults.toString());
        StringBuilder builder = new StringBuilder();
        for (DriverModel driver : realmResults){
            builder.append(driver.getId() +"||"+driver.getName()+"||" +driver.getJob()+"\n \n"+ driver.getArryaImage()+"array");
            Log.d(DemoRealmActivity.class.getSimpleName(),driver.getId() +"||"+driver.getName()+"||" +driver.getJob()+"\n \n");
            Glide.with(DemoRealmActivity.this)
                    .load(driver.getArryaImage())
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.chip_background)
                    .into(imageView);

            RequestManager manager = Glide.with(this);
            manager.load("https://assets-cdn.github.com/images/modules/site/universe-logo.png")
                    .into(imageView);
            Handler handler=  new Handler();

        }

        builder.append("\n final fluid interface");
        Log.d("driversFLUID",realmResults.toString());
        outPut = findViewById(R.id.output);
        outPut.setText(builder.toString());




        // querying drivers with normal Query Object
        RealmQuery<DriverModel>queryDrivers = realm.where(DriverModel.class)
                .contains("name","ahmed");
        RealmResults<DriverModel> drivers= queryDrivers.findAll();
        Log.d("driversNORMAL",drivers.toString());


    }
    static void loadImage(RequestManager glide, String url, ImageView view) throws ExecutionException, InterruptedException {
        Bitmap theBitmap = glide.
                load("https://firebasestorage.googleapis.com/v0/b/educaty-9304b.appspot.com/o/educaty_chat%2F17626107_1306007586148102_5441976966960461609_n.jpg?alt=media&token=8ba76226-859d-44fb-8bb4-3c6d43e4cebe").
                asBitmap().
                into(100, 100). // Width and height
                get();
    }
    void deleteData(){
        RealmResults<DriverModel>result=realm.where(DriverModel.class)
                .sort("name", Sort.ASCENDING) // C1 ..AND
                .beginGroup()
                .beginsWith("name","a" ) // C2
                .or() // ..OR
                .contains("name", "ahmed") // C3
                .endGroup()
                .findAll();
        result.deleteFromRealm(3);

    }

    @Override
    protected void onStop() {
        super.onStop();
        // stop realmAysncTask in background if any interruption
        if (realmAsyncTask!=null&&!realmAsyncTask.isCancelled()) realmAsyncTask.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // close realm to not cause memory leaks
        realm.close();
    }
}
