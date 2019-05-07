package com.zb.basework.di.component;

import com.zb.basework.di.module.FragmentModule;
import com.zb.basework.di.scope.FragmentScope;
import com.zb.basework.ui.home.HomeFragment;

import dagger.Component;

/**
 * 作用域为Fragment的生命周期   因为依赖了AppComponent所以在此Component内不能再使用 Singleton来标识作用域
 * Created by zb on 2019/5/5.
 */
@FragmentScope
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);
}
