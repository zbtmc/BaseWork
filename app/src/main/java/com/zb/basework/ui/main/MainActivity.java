package com.zb.basework.ui.main;

import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.zb.basework.R;
import com.zb.basework.base.BaseActivity;
import com.zb.basework.http.CallObserve;
import com.zb.basework.model.Version;
import com.zb.basework.ui.home.HomeFragment;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.MainView {

    @BindView(R.id.tv_show)
    TextView tvShow;

    @Inject
    HomeFragment homeFragment;

    @Override
    protected int getResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //要先注入才绑定
        activityComponent.inject(this);
        presenter.attachView(this);
    }

    @Override
    protected void initData() {
        showDialog("加载中,请稍后...");
        presenter.getUpdateInfo();
    }

    @Override
    protected void initListener() {

        RxView.clicks(tvShow)
                .throttleFirst(1, TimeUnit.SECONDS) //防止暴力点击
                .subscribe(new CallObserve<Object>() {
                    @Override
                    public void onSucess(Object o) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.cl_main,homeFragment);
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onFailed(String errorMsg) {

                    }

                    @Override
                    public void addDiasPosed(Disposable d) {
                        compositeDisposable.add(d);
                    }
                });
    }

    @Override
    public void showSomeMsg(String msg) {
        showToast(msg);
        hideDialog();
    }

    @Override
    public void doSomeSelf() {

    }

    @Override
    public void showUpdateInfo(Version version) {
        hideDialog();
        tvShow.setText(version.getVersionName());
        showToast(version.getVersionName());
    }

    @Override
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }
}
