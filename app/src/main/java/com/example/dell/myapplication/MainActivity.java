package com.example.dell.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.myapplication.LitePal.Pass;
import com.example.dell.myapplication.LitePal.Words;
import com.example.dell.myapplication.SQLiteDatabase.MydatabaseHelper;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //待添加点击后弹出提示框，是否确定退出
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //待添加清除游戏进度功能
        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Pass.class);
                LitePal.deleteAll(Words.class);
                Toast.makeText(MainActivity.this,"设置成功",Toast.LENGTH_SHORT).show();
            }
        });

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
