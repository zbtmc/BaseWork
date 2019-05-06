package com.zb.basework.di.component;

import com.zb.basework.di.module.AppModule;
import com.zb.basework.http.AppClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zb on 2019/5/5.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    AppClient getAppClient();
}
