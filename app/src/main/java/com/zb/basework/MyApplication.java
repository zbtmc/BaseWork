package com.zb.basework;

import android.app.Application;

import com.zb.basework.di.component.AppComponent;
import com.zb.basework.di.component.DaggerAppComponent;
import com.zb.basework.di.module.AppModule;

/**
 * 初始化
 * Created by zb on 2019/5/5.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }


}
