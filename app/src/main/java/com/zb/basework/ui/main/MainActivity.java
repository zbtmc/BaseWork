package com.zb.basework.ui.main;

import android.widget.TextView;
import com.zb.basework.R;
import com.zb.basework.base.BaseActivity;
import com.zb.basework.model.Version;
import butterknife.BindView;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.MainView {

    @BindView(R.id.tv_show)
    TextView tvShow;

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
