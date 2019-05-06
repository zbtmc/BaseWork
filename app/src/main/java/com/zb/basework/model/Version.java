package com.zb.basework.model;

import java.io.Serializable;

/**
 * app版本信息封装类
 *
 */
public class Version implements Serializable {

    //版本名称
    private String versionName;

    //版本更新说明
    private String versionNote;

    //版本 APK 的下载地址
    private String downloadURL;

    //版本代码
    private int versionCode;

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }


    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionNote(String versionNote) {
        this.versionNote = versionNote;
    }

    public String getVersionNote() {
        return versionNote;
    }
}
