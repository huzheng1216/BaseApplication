package com.flyersoft.baseapplication;

import android.app.Application;

/**
 * creat by: huzheng
 * date: 2019-09-20
 * description:
 * （分模块开发）基础application
 */
public abstract class BaseApplication extends Application {

    //修改顶部栏颜色
    public abstract void setStatusBarColor(int color);

    //搜索栏是否显示
    public abstract void setSearchBarVisible(boolean visible);
}
