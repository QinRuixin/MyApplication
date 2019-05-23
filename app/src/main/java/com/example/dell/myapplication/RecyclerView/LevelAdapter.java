package com.example.dell.myapplication.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.myapplication.R;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {

    private List<LevelToPass> levelList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        //添加事件监听
        View levelView;

        ImageView levelImage;
        TextView levelName;

        ViewHolder(View view){
            super(view);
            //添加事件监听
            levelView = view;

            levelImage = (ImageView) view.findViewById(R.id.level_image);
            levelName = (TextView) view.findViewById(R.id.level_name);
        }
    }

    public LevelAdapter(List<LevelToPass> levelList){
        this.levelList = levelList;
    }

    //每个Item inflater生成一个View，返回的是一个ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.level_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        //添加事件监听
        holder.levelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                LevelToPass ltp = levelList.get(position);
                //待修改为弹出相应的fragment
                Toast.makeText(v.getContext(),"you clicked on view"+ltp.getName(),Toast.LENGTH_LONG).show();

                //待添加关卡信息至数据库
            }
        });

        holder.levelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                LevelToPass ltp = levelList.get(position);
                //待修改为弹出相应的fragment
                Toast.makeText(v.getContext(),"you clicked on image"+ltp.getName(),Toast.LENGTH_LONG).show();

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

}
