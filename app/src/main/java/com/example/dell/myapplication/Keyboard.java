package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.myapplication.LitePal.Pass;

public class Keyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        Button clear = (Button) findViewById(R.id.keyboardClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接对返回的值操作？
//                Pass pass = new Pass();
//                pass.setPassed(true);
//                pass.updateAll("name = ?","Keyboard");

                Intent intent = new Intent();
                intent.putExtra("data_return1", true);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
