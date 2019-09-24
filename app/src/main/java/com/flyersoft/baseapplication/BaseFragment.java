package com.flyersoft.baseapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * creat by: huzheng
 * date: 2019-09-17
 * description:
 * 基础fragment
 * 防止重复inflater
 */
public abstract class BaseFragment extends Fragment {

    protected View contentView = null;
    protected boolean showActionBar = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = initView();
        }
        if (contentView != null) {
            return contentView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (contentView != null && contentView.getParent()!=null)
            ((ViewGroup) contentView.getParent()).removeView(contentView);
        super.onDestroyView();
    }

    /**
     * @author huzheng
     * @date 2019-09-24
     * @description
     * 控制actionbar是否显示。因为主界面使用的AppCompatActivity，这直接强制转换了。
     */
    protected void setActionBarVisible(boolean show){
        this.showActionBar = show;
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar supportActionBar = activity.getSupportActionBar();
        if(showActionBar){
            supportActionBar.show();
        }else {
            supportActionBar.hide();
        }
    }

    /**
     * @author huzheng
     * @date 2019-09-24
     * @description
     * 重新回到该fragment时，修改action bar状态
     *
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            setActionBarVisible(showActionBar);
        }
    }

    public abstract ViewGroup initView();
}
