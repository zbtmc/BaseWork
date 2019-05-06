package com.zb.basework.ui.main;

import com.zb.basework.base.BaseContact;
import com.zb.basework.model.Version;

/**
 * 主界面管理器
 * Created by zb on 2019/5/6.
 */

public interface MainContact {
    interface MainView extends BaseContact.BaseView{
        //处理MainActivity自己的逻辑
        void doSomeSelf();

        void showUpdateInfo(Version version);


    }

    interface Presenter extends BaseContact.Presenter<MainView>{
        void getUpdateInfo();
    }
}
