package com.zb.basework.base;

/**
 * presenter基类
 * Created by zb on 2019/5/5.
 */

public class BasePresenter<V extends BaseContact.BaseView> implements BaseContact.Presenter<V> {

    private V view;


    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public V getView(){
        return view;
    }

    //判断是否绑定View
    public boolean isAttachView(){
        return view!=null;
    }
}
