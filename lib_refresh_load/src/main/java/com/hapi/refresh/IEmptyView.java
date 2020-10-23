package com.hapi.refresh;

import android.view.View;

public interface IEmptyView {

    /**
     * 隐藏
     */
    int HIDE_LAYOUT = 3;
    /**
     * 网络异常
     */
    int NETWORK_ERROR = 1;
    /**
     * 服务器数据空
     */
    int NODATA = 2;


    int START_REFREASH=-1;
    int END_REFREASH=0;

    View getContentView();


    void setStatus(int type);


}
