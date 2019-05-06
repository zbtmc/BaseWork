package com.zb.basework.di.component;

import com.zb.basework.di.module.FragmentModule;
import com.zb.basework.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by zb on 2019/5/5.
 */
@FragmentScope
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {
}
