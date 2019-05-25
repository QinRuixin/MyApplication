package com.example.dell.myapplication.CU_Calculator_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.myapplication.R;

public class Binary_To_Decimal  extends Fragment implements View.OnClickListener {
    String numString="";
    String operater = "";
    int num;
    //列出button和textview
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_C;
    Button button_B2D;
    Button button_D2B;
    TextView tf ;
    //初始化
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View calcLayout = inflater.inflate(R.layout.fragment_binary_to_decimal, container, false);
        initViews(calcLayout);

        return calcLayout;

    }
    //初始化按钮和view
    private void initViews(View view){
        button_0 = view.findViewById(R.id.button_ZERO22);
        button_1 = view.findViewById(R.id.button_ONE2);
        button_2 = view.findViewById(R.id.button_TWO2);
        button_3 = view.findViewById(R.id.button_THREE2);
        button_4 = view.findViewById(R.id.button_FOUR2);
        button_5 = view.findViewById(R.id.button_FIVE2);
        button_6 = view.findViewById(R.id.button_SIX2);
        button_7 = view.findViewById(R.id.button_SEVEN2);
        button_8 = view.findViewById(R.id.button_EIGHT2);
        button_9 = view.findViewById(R.id.button_NINE2);
        button_C = view.findViewById(R.id.button_RESET2);
        button_B2D = view.findViewById(R.id.button_B2D);
        button_D2B = view.findViewById(R.id.button_D2B);
        tf = view.findViewById(R.id.tf);

        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_C.setOnClickListener(this);
        button_B2D.setOnClickListener(this);
        button_D2B.setOnClickListener(this);
        tf.setOnClickListener(this);
    }

    //按钮监听
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_RESET2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = "";
                operater = "";
                tf.setText("");
                break;

            }
            case R.id.button_B2D:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                char m;
                boolean isBinary = true;
                for(int i = 0;i<numString.length();i++){
                    if(( m = numString.charAt(i))!='0'&&numString.charAt(i)!='1'){
                        isBinary = false;
                        break;
                    }
                }

                    if(isBinary==true) {
                        num = Integer.parseInt(numString, 2);

                        numString = "" + num;
                        tf.setText(numString);
                    }

                    else {
                        tf.setText("Error!Please input valid number!");
                        numString = "";
                    }
                break;
            }
            case R.id.button_D2B:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                tf.setText("");
            }
                numString  = Integer.toBinaryString(Integer.parseInt(numString));
                tf.setText(numString);
                break;
            }
            case R.id.button_ZERO22:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"0";
                tf.setText(numString);
                break;
            }
            case R.id.button_ONE2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"1";
                tf.setText(numString);
                break;
            }
            case R.id.button_TWO2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"2";
                tf.setText(numString);
                break;
            }
            case R.id.button_THREE2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"3";
                tf.setText(numString);
                break;
            }
            case R.id.button_FOUR2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"4";
                tf.setText(numString);
                break;
            }case R.id.button_FIVE2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"5";
                tf.setText(numString);
                break;
            }case R.id.button_SIX2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"6";
                tf.setText(numString);
                break;
            }case R.id.button_SEVEN2:{
                numString = numString+"7";
                tf.setText(numString);
                break;
            }case R.id.button_EIGHT2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"8";
                tf.setText(numString);
                break;
            }case R.id.button_NINE2:{
                if(tf.getText().toString().equals("This is a Binary-Decimal converter.")){
                    tf.setText("");
                }
                numString = numString+"9";
                tf.setText(numString);
                break;
            }
        default:break;


        }

    }
}
