package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    /*正式版需用文件存储这些数据，在该版本中回到主菜单后下面四个数据会重置*/
    private  boolean part0IsClear;
    private  boolean part1IsClear;
    private  boolean part2IsClear;
    private  boolean part3IsClear;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 0:
                if(resultCode == RESULT_OK){
                    part0IsClear = data.getBooleanExtra("data_return0",false);
                }break;
            case 1:
                if(resultCode == RESULT_OK){
                    part1IsClear = data.getBooleanExtra("data_return1",false);
                }break;
            case 2:
                if(resultCode == RESULT_OK){
                    part2IsClear = data.getBooleanExtra("data_return2",false);
                }break;
            case 3:
                if(resultCode == RESULT_OK){
                    part3IsClear = data.getBooleanExtra("data_return3",false);
                }break;
                default:

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button cpu = (Button) findViewById(R.id.CPU);
        Button keyboard = (Button) findViewById(R.id.keyboard);
        Button memory = (Button) findViewById(R.id.memory);
        Button printer = (Button) findViewById(R.id.printer);
        Button returnMain = (Button)findViewById(R.id.returnToMain);

        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(MapActivity.this,CPU.class);
                startActivityForResult(intent0,0);
            }
        });

        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MapActivity.this,Keyboard.class);
                startActivityForResult(intent1,1);
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(part1IsClear){
                    Intent intent2 = new Intent(MapActivity.this,Memory.class);
                    startActivityForResult(intent2,2);
                }else{
                    Toast.makeText(MapActivity.this,"请先完成键盘关卡",Toast.LENGTH_SHORT).show();
                }
            }
        });

        printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(part2IsClear){
                    Intent intent3 = new Intent(MapActivity.this,Printer.class);
                    startActivityForResult(intent3,3);
                }else{
                    Toast.makeText(MapActivity.this,"请先完成存储器关卡",Toast.LENGTH_SHORT).show();
                }
            }
        });

        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}