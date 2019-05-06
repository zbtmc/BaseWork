package com.zb.basework.http;

import com.zb.basework.model.ArticleListResponse;
import com.zb.basework.model.Version;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by zb on 2019/5/5.
 */
public class AppClient {

    ServiceApi mServiceApi;

    @Inject
    public AppClient(ServiceApi mServiceApi){
        this.mServiceApi = mServiceApi;
    }

    class RxMapFunction<T> implements Function<HttpResult<T>,T> {

        @Override
        public T apply(HttpResult<T> tHttpResult) throws Exception {

//            if (tHttpResult.getCode()==200){
//
//            }

            return tHttpResult.getData();
        }
    }

    public Observable<ArticleListResponse> getArticles(Map<String,String>params){
        Observable<ArticleListResponse> observable = mServiceApi.getArticles(params)
                .map(new RxMapFunction<ArticleListResponse>());
        return observable;
    }
    public Observable<Version> checkVersion(Map<String,String>params){
        Observable<Version> observable = mServiceApi.checkVersion(params);
        return observable;
    }
}
