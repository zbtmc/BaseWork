package com.zb.basework.base;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zb.basework.MyApplication;
import com.zb.basework.di.component.DaggerFragmentComponent;
import com.zb.basework.di.component.FragmentComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * fragment基类
 * Created by zb on 2019/5/6.
 */

public abstract class BaseFragment<P extends BaseContact.Presenter> extends Fragment implements BaseContact.BaseView {

    @Inject
    protected P presenter;

    @Inject
    protected CompositeDisposable compositeDisposable;

    protected Context mContext;

    //fragment提供者与使用者的桥梁
    protected FragmentComponent fragmentComponent;

    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

        fragmentComponent = DaggerFragmentComponent.builder().
                appComponent(((MyApplication) mContext.getApplicationContext()).getAppComponent()).build();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getResourceId(), container, false);
        bind = ButterKnife.bind(this, view);

        initView();
        initData();
        initListener();
        return view;
    }

    protected abstract int getResourceId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();


    @Override
    public void onDestroyView() {
        compositeDisposable.clear();
        bind.unbind();
        if (presenter != null)
            presenter.detachView();

        super.onDestroyView();
    }
}
