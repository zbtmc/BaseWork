package com.zb.basework.ui.home;

import android.widget.TextView;

import com.zb.basework.R;
import com.zb.basework.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * 首页界面
 * Created by zb on 2019/5/6.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContact.View {

    @BindView(R.id.tv_home_show)
    TextView tvHomeShow;

    @Inject
    public HomeFragment(){

    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        fragmentComponent.inject(this);

        if (presenter==null)
            return;

        presenter.attachView(this);
    }

    @Override
    protected void initData() {
        presenter.getHomeData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showSomeMsg(String msg) {

    }

    @Override
    public void addDisposable(Disposable disposable) {

    }

    @Override
    public void showHomeData(String data) {
        tvHomeShow.setText(data);
    }


}
