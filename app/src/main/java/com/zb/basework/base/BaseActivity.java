package com.zb.basework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.zb.basework.MyApplication;
import com.zb.basework.di.component.ActivityComponent;
import com.zb.basework.di.component.DaggerActivityComponent;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Activity基类
 * Created by zb on 2019/5/5.
 */

public abstract class BaseActivity<P extends BaseContact.Presenter> extends AppCompatActivity implements BaseContact.BaseView {

    @Inject
    protected P presenter;

    //Dagger2的使用
    protected ActivityComponent activityComponent;

    //Rxjava  生命周期管理
    @Inject
    protected CompositeDisposable compositeDisposable;

    Unbinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResource());
        binder = ButterKnife.bind(this);

        activityComponent = DaggerActivityComponent.builder().appComponent(((MyApplication) getApplication()).getAppComponent())
                .build();

        initView();
        initData();
        initListener();
    }

    //加载布局
    protected abstract int getResource();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showDialog(String msg) {
        Toast.makeText(this, "进度框加载..." + msg, Toast.LENGTH_SHORT).show();
    }

    public void hideDialog() {
        Toast.makeText(this, "隐藏进度框", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        binder.unbind();
        compositeDisposable.clear();
        if (presenter!=null)
            presenter.detachView();
        super.onDestroy();
    }
}
