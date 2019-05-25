package com.example.dell.myapplication.RecyclerView;
//修改过levelAdapter
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.dell.myapplication.CPUfragments.CUFragment;
import com.example.dell.myapplication.CPUfragments.CalcFragment;
import com.example.dell.myapplication.CU_Calculator_fragments.Binary_Calculator;
import com.example.dell.myapplication.CU_Calculator_fragments.Binary_To_Decimal;
import com.example.dell.myapplication.CU_Calculator_fragments.Floating_Number_And_ASCII;
import com.example.dell.myapplication.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {

    private List<LevelToPass> levelList;
    private Context context;
    private Fragment infragment;

    static class ViewHolder extends RecyclerView.ViewHolder {
        //添加事件监听
        View levelView;

        ImageView levelImage;
        TextView levelName;

        ViewHolder(View view) {
            super(view);
            //添加事件监听
            levelView = view;

            levelImage = (ImageView) view.findViewById(R.id.level_image);
            levelName = (TextView) view.findViewById(R.id.level_name);
        }
    }

    public LevelAdapter(List<LevelToPass> levelList, Fragment fragment) {

        this.levelList = levelList;
        this.infragment = fragment;
    }

    //每个Item inflater生成一个View，返回的是一个ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.level_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        //添加事件监听
        holder.levelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                LevelToPass ltp = levelList.get(position);
                //待修改为弹出相应的fragment
                FragmentManager fm = infragment.getFragmentManager();
                if (ltp.getImageID() == R.drawable.three) {
                    Toast.makeText(v.getContext(), "you clicked on image" + ltp.getName(), Toast.LENGTH_LONG).show();
                    switch (ltp.getName()) {
                        case "关卡3-0": {
                            addFragment(new Binary_Calculator(), fm);
                            break;
                        }
                        case "关卡3-1": {
                            addFragment(new Binary_To_Decimal(), fm);
                            break;
                        }
                        case "关卡3-2": {
                            addFragment(new Floating_Number_And_ASCII(), fm);
                            break;
                        }
                    }
                }
            }
            //Toast.makeText(v.getContext(),"you clicked on view"+ltp.getName(),Toast.LENGTH_LONG).show();

            //待添加关卡信息至数据库

        });


        holder.levelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = infragment.getChildFragmentManager();
                int position = holder.getAdapterPosition();
                LevelToPass ltp = levelList.get(position);
                //待修改为弹出相应的fragment
                //Toast.makeText(v.getContext(),"you clicked on image"+ltp.getName(),Toast.LENGTH_LONG).show();
                if (ltp.getImageID() == R.drawable.three) {
                    if (ltp.getName().equals("关卡3-0")) {
                        addFragment(new Binary_Calculator(), fm);
                    }
                    Toast.makeText(v.getContext(), "you clicked on image" + ltp.getName(), Toast.LENGTH_LONG).show();
                    switch (ltp.getName()) {
                        case "关卡3-0": {
                            addFragment(new Binary_Calculator(), fm);
                            break;
                        }
                        case "关卡3-1": {
                            addFragment(new Binary_To_Decimal(), fm);
                            break;
                        }
                        case "关卡3-2": {
                            addFragment(new Floating_Number_And_ASCII(), fm);
                            break;
                        }
                    }
                }
                //待添加关卡信息至数据库
            }
        });


        return holder;
    }

    //适配渲染数据到View中
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        LevelToPass levelToPass = levelList.get(i);

        viewHolder.levelImage.setImageResource(levelToPass.getImageID());
        viewHolder.levelName.setText(levelToPass.getName());

    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }


    private void addFragment(Fragment fragment, FragmentManager fm) {

        FragmentManager fragmentManager;
        fragmentManager = fm;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, fragment);
        transaction.show(fragment);
        //隐藏recyclerview
        CalcFragment.setVisibilityOfRecyclerView(false);
        transaction.commit();
    }
}