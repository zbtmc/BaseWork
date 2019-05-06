package com.zb.basework.di.component;

import com.zb.basework.ui.main.MainActivity;
import com.zb.basework.di.module.ActivityModule;
import com.zb.basework.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by zb on 2019/5/5.
 */
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
