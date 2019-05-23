package com.example.dell.myapplication.CPUfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


public class CUFragment extends Fragment {
    //用于设置fragment的layout
    private View cuLayout;
    public RecyclerView recyclerView;
    private LevelAdapter levelAdapter;
    //用于添加关卡
    private List<LevelToPass> levelList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cuLayout = inflater.inflate(R.layout.fragement_controlunit, container, false);

//        加载一个RecylerView

//        先初始化CU关卡数据
        initCULevels();
        //初始化recyclerView
        initRecyclerView();

        return cuLayout;
    }

    private void initRecyclerView() {
        recyclerView = cuLayout.findViewById(R.id.recycler_view_control);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        levelAdapter = new LevelAdapter(levelList);
        recyclerView.setAdapter(levelAdapter);
    }

    private void initCULevels() {
        //待修改为正常关卡添加
        for (int i = 0; i < 3; i++) {
            LevelToPass ltp = new LevelToPass("关卡一", R.drawable.cu_selected);
            levelList.add(ltp);
        }
    }


}
