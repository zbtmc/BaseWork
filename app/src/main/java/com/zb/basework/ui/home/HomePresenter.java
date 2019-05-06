package com.zb.basework.ui.home;

import com.zb.basework.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by zb on 2019/5/6.
 */

public class HomePresenter extends BasePresenter<HomeContact.View> implements HomeContact.Presenter {

    @Inject
    public HomePresenter(){}

    @Override
    public void getHomeData() {
        getView().showHomeData("数据传过去了");
    }
}
