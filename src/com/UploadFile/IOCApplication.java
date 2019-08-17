package com.UploadFile;


import android.app.Application;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import roboguice.RoboGuice;

public class IOCApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.
        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(this), new IOCModule());


    }


}
