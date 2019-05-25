package com.example.dell.myapplication.CPUfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.RecyclerView.LevelAdapter;
import com.example.dell.myapplication.RecyclerView.LevelToPass;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.INVISIBLE;

public class CalcFragment extends Fragment {
    //用于设置fragment的layout
    private View calcLayout;
    public static RecyclerView recyclerView;//修改过

    private LevelAdapter levelAdapter;
    //用于添加关卡
    private List<LevelToPass> levelList = new ArrayList<>();
    public FragmentManager ManagerOfCalcFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calcLayout = inflater.inflate(R.layout.fragement_calculator,container,false);

        //        加载一个RecylerView
//        先初始化关卡数据
        initCalcLevels();
        //初始化recyclerView
        initRecyclerView();
        return calcLayout;
    }


    private void initRecyclerView() {
        recyclerView = calcLayout.findViewById(R.id.recycler_view_calculator);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        levelAdapter = new LevelAdapter(levelList,this);
        recyclerView.setAdapter(levelAdapter);
    }

    private void initCalcLevels() {
        //待修改为正常关卡添加
        for (int i = 0; i < 3; i++) {
            LevelToPass ltp = new LevelToPass("关卡3-"+i, R.drawable.three);
            levelList.add(ltp);
        }
    }

    public static void setVisibilityOfRecyclerView(boolean isvisible){
        if(isvisible==true){


        }
        else recyclerView.setVisibility(INVISIBLE);
    }
}