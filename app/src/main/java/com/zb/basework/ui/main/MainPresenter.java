package com.zb.basework.ui.main;

import com.zb.basework.base.BasePresenter;
import com.zb.basework.http.AppClient;
import com.zb.basework.http.CallObserve;
import com.zb.basework.model.Version;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 主界面presenter类
 * Created by zb on 2019/5/6.
 */

public class MainPresenter extends BasePresenter<MainContact.MainView> implements MainContact.Presenter {


    //这个就是使用者，应为他的作用域是全局
    @Inject
    AppClient appClient;

    //这里的Inject是提供者而不是使用者
    @Inject
    public MainPresenter(){
    }

    @Override
    public void getUpdateInfo() {

        Map<String,String> params = new HashMap<>();

        Observable<Version> observable = appClient.checkVersion(params);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallObserve<Version>() {
                    @Override
                    public void onSucess(Version version) {
                        getView().showUpdateInfo(version);
                    }

                    @Override
                    public void onFailed(String errorMsg) {
                        getView().showSomeMsg(errorMsg);
                    }

                    @Override
                    public void addDiasPosed(Disposable d) {
                        getView().addDisposable(d);
                    }
                });
    }
}
