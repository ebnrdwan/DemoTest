package com.demo.abdulrahmanrudwan.demotest.demoRealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.abdulrahmanrudwan.demotest.R;

import java.sql.Driver;
import java.util.UUID;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

public class DemoRealmActivity extends AppCompatActivity {

    Realm realm;
    RealmAsyncTask realmAsyncTask;
    String id;
    TextView outPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        outPut = findViewById(R.id.output);
        setContentView(R.layout.activity_demo_realm);
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
    public void DisplayAll(View view){

        // querying with fluid interface
        RealmResults <DriverModel> realmResults =  realm.where(DriverModel.class)
                .contains("name","ahmed", Case.INSENSITIVE)
                .findAll();
        Log.d(DemoRealmActivity.class.getSimpleName(),realmResults.toString());
        StringBuilder builder = new StringBuilder();
        for (DriverModel driver : realmResults){
            builder.append(driver.getId() +"||"+driver.getName()+"||" +driver.getJob()+"\n \n");
            Log.d(DemoRealmActivity.class.getSimpleName(),driver.getId() +"||"+driver.getName()+"||" +driver.getJob()+"\n \n");
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
