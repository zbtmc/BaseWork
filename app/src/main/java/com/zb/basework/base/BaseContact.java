package com.zb.basework.base;


import io.reactivex.disposables.Disposable;

/**
 * Created by zb on 2019/5/5.
 */

public interface BaseContact {
    interface BaseView{
        void showSomeMsg(String msg);
        //处理rxjava生命周期的东东
        void addDisposable(Disposable disposable);
    }

    interface Presenter<V extends BaseContact.BaseView>{
        void attachView(V view);
        void detachView();
    }
}
