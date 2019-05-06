package com.zb.basework.http;

import com.zb.basework.model.Version;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zb on 2019/5/5.
 */

public interface ServiceApi {

    /**
     * 检查更新
     *
     * @return
     */
    @FormUrlEncoded
    @POST("android/checkVersion")
    Observable<Version> checkVersion(@FieldMap Map<String, String> params);
}
