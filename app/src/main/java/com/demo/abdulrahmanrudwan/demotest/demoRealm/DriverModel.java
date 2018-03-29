package com.demo.abdulrahmanrudwan.demotest.demoRealm;

import android.graphics.Bitmap;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.demo.abdulrahmanrudwan.demotest.DemoApplication;
import com.demo.abdulrahmanrudwan.demotest.R;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Abdulrahman Rudwan on 08/01/2018.
 */

public class DriverModel extends RealmObject {

    @Required
    private String name;
    @PrimaryKey
    private String id;
    @Required
    private String job;

    @Required
    private byte[] arryaImage;

    public byte[] getArryaImage() throws ExecutionException, InterruptedException {
        return setArryaImage();
    }

    public byte[] setArryaImage() throws ExecutionException, InterruptedException {
//        try {
            DemoApplication demoApplication = new DemoApplication();

            Bitmap theBitmap = Glide.
                    with(DemoApplication.getContext()).
                    load("https://firebasestorage.googleapis.com/v0/b/educaty-9304b.appspot.com/o/educaty_chat%2F17626107_1306007586148102_5441976966960461609_n.jpg?alt=media&token=8ba76226-859d-44fb-8bb4-3c6d43e4cebe").
                    asBitmap().
                    into(100, 100). // Width and height
                    get();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            theBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            arryaImage=byteArray;
            Log.d("TAG", arryaImage.toString());
        return arryaImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
