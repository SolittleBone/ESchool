package org.jit.sose.eschool.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import org.jit.sose.eschool.R;
import org.jit.sose.eschool.course.AbsGridAdapter;
import org.jit.sose.eschool.course.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: dongdongdong
 * Date: 2018/6/23
 * GITHUB: https://github.com/Lulululuya/ESchool
 * Description: 课程表的Activity
 */
public class CourseActivity extends Activity {

    private Spinner weekSpinner;                        //课程表 周的下拉框
    private Spinner yearSpiner;                         //课程表 学年的下拉框

    private GridView detailCource;                      //课程信息的GridView控件

    private String[][] contents;                        //具体课程的数据

    private AbsGridAdapter secondAdapter;               //课程信息数据的适配器

    private List<String> dataList;                      //课程表 周的数据集
    private List<String> yearList;                      //课程表 年的数据集

    private ArrayAdapter<String> spinnerWeekAdapter;        //课程表 周的适配器
    private ArrayAdapter<String> spinnerYearAdapter;    //课程表 年的适配器


    //课程表界面初始化的方面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);

        //初始化课程表的界面的控件
        initWidget();

        //创建课程表的课程数据
        fillStringArray();

        //在GridView视图上绑定课程表的数据源
        initAdapter(secondAdapter,contents,detailCource);


        fillDataList();         //创建 课程表_周的下拉框的数据
        fillYearList();         //创建 课程表_年的下拉框的数据

        //将 课程表_周的下拉框中的数据绑定到视图控件上
        initSpinnerAdapter(this,spinnerWeekAdapter,R.layout.support_simple_spinner_dropdown_item,dataList,weekSpinner);


        //将 课程表_年的下拉框中的数据绑定到视图控件上
        initSpinnerAdapter(this,spinnerYearAdapter,R.layout.support_simple_spinner_dropdown_item,yearList,yearSpiner);
    }


    //初始化控件
    public void initWidget(){
        weekSpinner = (Spinner)findViewById(R.id.switchWeek);           //课程表 周的下拉框
        yearSpiner = (Spinner) findViewById(R.id.switchYear);       //课程表 年的下拉框
        detailCource = (GridView)findViewById(R.id.courceDetail);   //课程表 课程数据的GridView布局控件
    }


    /**
     * 在GridView视图上绑定课程表的数据源
     * @param adapter   绑定数据到视图上面所采用的适配器
     * @param content   在视图上面需要绑定的数据
     * @param gridView  所要绑定的视图
     */
    public void initAdapter(AbsGridAdapter adapter,String[][] content,GridView gridView){
        adapter = new AbsGridAdapter(this);
        adapter.setContent(content, 6, 7);
        gridView.setAdapter(adapter);
    }

    /**
     * 将数据通过 spinnerAdapter 绑定到 spinner控件上
     * @param context           界面的上下面对象
     * @param spinnerAdapter    下拉框的适配器
     * @param id                系统的下拉框布局控件
     * @param data              下拉框的数据集
     * @param spinner           下拉框的控件
     */
    public void initSpinnerAdapter(Context context,ArrayAdapter<String> spinnerAdapter,int id,List<String> data,Spinner spinner){
        spinnerAdapter = new ArrayAdapter<String>(context, id, data);
        spinnerAdapter.setDropDownViewResource(id);
        spinner.setAdapter(spinnerAdapter);
    }



    //创建周的下拉框数据
    public void fillDataList() {
        dataList = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            dataList.add("第" + i + "周");
        }
    }

    //创建年的下拉框数据
    public void fillYearList() {
        yearList = new ArrayList<>();
        for(int i = 2015; i <= 2017; i++) {
            yearList.add(i + "年");
        }
    }

    /**
     * 准备数据（模拟出来的课程数据）
     */
    public void fillStringArray() {
        contents = new String[6][7];
        contents[0][0] = "现代测试技术\nB211";
        contents[1][0] = "微机原理及应用\nE203";
        contents[2][0] = "电磁场理论\nA212";
        contents[3][0] = "传感器电子测量A\nC309";
        contents[4][0] = "";
        contents[5][0] = "";
        contents[0][1] = "数据结构与算法\nB211";
        contents[1][1] = "";
        contents[2][1] = "面向对象程序设计\nA309";
        contents[3][1] = "面向对象程序设计\nA309";
        contents[4][1] = "";
        contents[5][1] = "";
        contents[0][2] = "微机原理及应用\nE203";
        contents[1][2] = "电磁场理论\nA212";
        contents[2][2] = "现代测试技术\nB211";
        contents[3][2] = "";
        contents[4][2] = "";
        contents[5][2] = "";
        contents[0][3] = "面向对象程序设计\nA309";
        contents[1][3] = "传感器电子测量A\nC309";
        contents[2][3] = "";
        contents[3][3] = "";
        contents[4][3] = "";
        contents[5][3] = "";
        contents[0][4] = "数据结构与算法\nB211";
        contents[1][4] = "微机原理及应用\nE203";
        contents[2][4] = "";
        contents[3][4] = "";
        contents[4][4] = "";
        contents[5][4] = "";
        contents[0][5] = "";
        contents[1][5] = "";
        contents[2][5] = "";
        contents[3][5] = "";
        contents[4][5] = "";
        contents[5][5] = "";
        contents[0][6] = "";
        contents[1][6] = "";
        contents[2][6] = "";
        contents[3][6] = "";
        contents[4][6] = "";
        contents[5][6] = "测试基础万盛道";
    }
}
