package com.demo.abdulrahmanrudwan.demotest.demoRealm;

import com.google.gson.annotations.SerializedName;

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
