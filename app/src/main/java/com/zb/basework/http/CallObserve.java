package com.zb.basework.http;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 自定义观察者
 * Created by zb on 2019/5/5.
 */

public abstract class CallObserve<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        //rxjava生命周期管理
        addDiasPosed(d);
    }

    @Override
    public void onNext(T t) {
        onSucess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailed("请求失败");
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSucess(T t);
    public abstract void onFailed(String errorMsg);
    public abstract void addDiasPosed(Disposable d);

}
