package com.zb.basework.ui.home;

import com.zb.basework.base.BaseContact;

/**
 * 接口控制类
 * Created by zb on 2019/5/6.
 */

public interface HomeContact {
    interface View extends BaseContact.BaseView{
        void showHomeData(String data);
    }

    interface Presenter extends BaseContact.Presenter<HomeContact.View>{
        void getHomeData();
    }
}
