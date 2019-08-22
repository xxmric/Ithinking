package com.example.ithinking.listener;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ActionBarTabListener implements ActionBar.TabListener {
    private final Activity mActivity;//用于指定要加载Fragment的Activity
    private final Class mClass;//用于指定要加载的fragment所对应的类
    private Fragment mFragment;//定义Fragment对象

    public ActionBarTabListener(Activity activity, Class aClass) {
        mActivity = activity;
        mClass = aClass;
    }

    /**被选择时****/
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity,mClass.getName());
            ft.add(android.R.id.content,mFragment,null);
        }
        ft.attach(mFragment);//显示新页面
    }

    /**退出选中状态**/
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            ft.detach(mFragment);//删除旧页面
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
