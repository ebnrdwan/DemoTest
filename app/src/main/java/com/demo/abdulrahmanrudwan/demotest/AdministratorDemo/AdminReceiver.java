package com.demo.abdulrahmanrudwan.demotest.AdministratorDemo;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Abdulrahman Rudwan on 11/02/2018.
 */

public class AdminReceiver extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
    }
}
