package com.zb.basework.di.module;

import com.zb.basework.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * fragment对象初始化提供者
 * Created by zb on 2019/5/5.
 */
@FragmentScope
@Module
public class FragmentModule {

    @Provides
    @FragmentScope
    CompositeDisposable provideComposite(){
        return new CompositeDisposable();
    }

}
