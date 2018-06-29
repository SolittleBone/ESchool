package org.jit.sose.eschool.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.jit.sose.eschool.R;
import org.jit.sose.eschool.controller.MainFragmentController;

/**
 * Author: chenmin
 * Date: 2018/6/23
 * GITHUB: https://github.com/Lulululuya/ESchool
 * Description: 程序的主界面，主要负责App的Fragment视图绑定
 */
@EActivity(R.layout.main)
public class MainActivity extends AppCompatActivity {


    // 实例化fragmentcontroller（fragment的管理类）
    private MainFragmentController mainFragmentController;

    //log的TAG
    private static final String TAG = "MainActivity";

    //绑定底部导航栏的RadioGroup
    @ViewById(R.id.rg_bottomBar)
    RadioGroup rb_bottomBar;

    //界面初始化所调用的方法
    @AfterViews
    void showMain(){

        initFragment();                   //初始化底部导航栏的fragment
    }


    //初始化底部导航栏显示的按钮（通过RadioGroup来绑定Fragment）
    void initFragment(){
        mainFragmentController = MainFragmentController.getInstance(this, R.id.content);
        mainFragmentController.showFragment(0);
        //RadioGroup的点击事件
        rb_bottomBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_school:{
                        mainFragmentController.showFragment(0);
                        break;
                    }
                    case R.id.rb_course:{
                        mainFragmentController.showFragment(1);
                        break;
                    }
                    case R.id.rb_leave:{
                        mainFragmentController.showFragment(2);
                        Log.i(TAG, "onCheckedChanged: 点击请假");
                        break;
                    }
                    case R.id.rb_person:{
                        mainFragmentController.showFragment(3);
                        Log.i(TAG, "onCheckedChanged: 点击个人中心");
                        break;
                    }

                }
            }
        });
    }


    //解决fragment残留的视图问题
    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());         //获取PID
        System.exit(0);
    }


}
