package com.zb.basework.di.module;

import com.zb.basework.Config;
import com.zb.basework.MyApplication;
import com.zb.basework.http.LoggingInterceptor;
import com.zb.basework.http.ServiceApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 全局对象提供者
 * Created by zb on 2019/5/5.
 */
@Module
public class AppModule {

    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        //不配置client则创建默认的okhttp
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttp(){
        //自定义okhttp对象，提供给Retrofit使用
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Config.connectTime, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        return okHttpClient;
    }

    @Provides
    @Singleton
    ServiceApi provideApiService(Retrofit retrofit){
        return retrofit.create(ServiceApi.class);
    }


}
