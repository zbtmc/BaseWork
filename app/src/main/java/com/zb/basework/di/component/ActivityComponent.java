package com.zb.basework.di.component;

import com.zb.basework.ui.main.MainActivity;
import com.zb.basework.di.module.ActivityModule;
import com.zb.basework.di.scope.ActivityScope;

import dagger.Component;

/**
 * 作用域为 Activity的生命周期内 因为依赖了AppComponent所以在此Component内不能再使用 Singleton来标识作用域
 * Created by zb on 2019/5/5.
 */
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
