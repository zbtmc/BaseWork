package com.zb.basework.di.module;

import com.zb.basework.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * ActivityScope作用域
 * Created by zb on 2019/5/5.
 */
@ActivityScope
@Module
public class ActivityModule {

    @Provides
    @ActivityScope
    CompositeDisposable provideComposite(){
        return new CompositeDisposable();
    }
}
