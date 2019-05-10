package com.example.dell.myapplication;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.myapplication.CPUfragments.CUFragment;
import com.example.dell.myapplication.CPUfragments.CalcFragment;
import com.example.dell.myapplication.CPUfragments.RegiFragment;

/**
 * 三个碎片嵌入此活动
 */
public class CPU extends AppCompatActivity implements View.OnClickListener {
    /**
     * 用于展示控制器，寄存器，运算器的Fragment
     */
    private CUFragment cuFragment;
    private RegiFragment regiFragment;
    private CalcFragment calcFragment;
    /**
     * 控制器，寄存器，运算器界面布局
     */
    private View cuLayout;
    private View regiLayout;
    private View calcLayout;
    /**
     * 在Tab布局上显示控制器，寄存器，运算器图标的控件
     */
    private ImageView cuImage;
    private ImageView regiImage;
    private ImageView calcImage;
    /**
     * 在Tab布局上显示控制器，寄存器，运算器标题的控件
     */
    private TextView cuText;
    private TextView regiText;
    private TextView calcText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

//    public CPU() {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cpu);
        // 初始化布局元素
        initViews();
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);


//        Button clear = (Button) findViewById(R.id.cpuClear);
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("data_return0", true);
//                setResult(RESULT_OK,intent);
//                finish();
//            }
//        });


    }

    private void initViews() {
        cuLayout = findViewById(R.id.cu_layout);
        regiLayout = findViewById(R.id.regi_layout);
        calcLayout = findViewById(R.id.calc_layout);

        cuImage = (ImageView)findViewById(R.id.cu_image);
        regiImage = (ImageView)findViewById(R.id.regi_image);
        calcImage = (ImageView)findViewById(R.id.calc_image);

        cuText = (TextView) findViewById(R.id.cu_text);
        regiText = (TextView) findViewById(R.id.regi_text);
        calcText = (TextView) findViewById(R.id.calc_text);

        cuLayout.setOnClickListener(this);
        regiLayout.setOnClickListener(this);
        calcLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cu_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.regi_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(1);
                break;
            case R.id.calc_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(2);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示控制器，1表示寄存器，2表示运算器。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                cuImage.setImageResource(R.drawable.cu_selected);
                cuText.setTextColor(Color.WHITE);
                if (cuFragment == null) {
                    // 如果cuFragment为空，则创建一个并添加到界面上
                    cuFragment = new CUFragment();
                    transaction.add(R.id.content, cuFragment);
                } else {
                    // 如果cuFragment不为空，则直接将它显示出来
                    transaction.show(cuFragment);
                }
                break;

            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                regiImage.setImageResource(R.drawable.regi_selected);
                regiText.setTextColor(Color.WHITE);
                if (regiFragment == null) {
                    // 如果regiFragment为空，则创建一个并添加到界面上
                    regiFragment = new RegiFragment();
                    transaction.add(R.id.content, regiFragment);
                } else {
                    // 如果regiFragment不为空，则直接将它显示出来
                    transaction.show(regiFragment);
                }
                break;

            case 2:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                calcImage.setImageResource(R.drawable.calc_selected);
                calcText.setTextColor(Color.WHITE);
                if (calcFragment == null) {
                    // 如果calcFragment为空，则创建一个并添加到界面上
                    calcFragment = new CalcFragment();
                    transaction.add(R.id.content, calcFragment);
                } else {
                    // 如果calcFragment不为空，则直接将它显示出来
                    transaction.show(calcFragment);
                }
                break;

            default:
                break;
        }

        transaction.commit();

    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        cuImage.setImageResource(R.drawable.cu_unselected);
        cuText.setTextColor(Color.parseColor("#82858b"));
        regiImage.setImageResource(R.drawable.regi_unselected);
        regiText.setTextColor(Color.parseColor("#82858b"));
        calcImage.setImageResource(R.drawable.calc_unselected);
        calcText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (cuFragment != null) {
            transaction.hide(cuFragment);
        }
        if (regiFragment != null) {
            transaction.hide(regiFragment);
        }
        if (calcFragment != null) {
            transaction.hide(calcFragment);
        }

    }





}