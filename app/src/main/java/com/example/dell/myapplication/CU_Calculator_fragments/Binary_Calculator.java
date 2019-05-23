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

public class Binary_Calculator extends Fragment implements View.OnClickListener
{    //列出button和textview
    Button button_1;
    Button button_ZERO;
    Button button_ADD;
    Button button_SUB;
    Button button_MUL;
    Button button_DIV;
    Button button_LEFTMOVE;
    Button button_RIGHTMOVE;
    Button button_EQU;
    Button button_AND;
    Button button_OR;
    Button button_NOT;
    // Button button_ASCII;
    Button button_RESET;
    TextView tf;//textfield;


    //第一个
    private String first;

    //操作
    private String operator;
    //第二个
    private String second;

    //重置
    private boolean reset = false;
    //String text = "";

    //初始化
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View calcLayout = inflater.inflate(R.layout.fragment_binary_calculator, container, false);
        initViews(calcLayout);

        return calcLayout;
    }

    //初始化
    private void initViews(View view) {
        button_ZERO = view.findViewById(R.id.button_ZERO2);
        button_1 = view.findViewById(R.id.button_1);
        button_ADD = view.findViewById(R.id.button_ADD);
        button_SUB = view.findViewById(R.id.button_SUB);
        button_MUL = view.findViewById(R.id.button_MULT);
        button_DIV = view.findViewById(R.id.button_DIV);
        button_LEFTMOVE = view.findViewById(R.id.button_LEFTMOVE);
        button_RIGHTMOVE = view.findViewById(R.id.button_RIGHTMOVE);
        button_EQU = view.findViewById(R.id.button_EQU);
        button_AND = view.findViewById(R.id.button_AND);
        button_OR = view.findViewById(R.id.button_OR);
        button_NOT = view.findViewById(R.id.button_NOT);
        //button_ASCII = getView().findViewById(R.id.button_ASCII);
        button_RESET = view.findViewById(R.id.button_RESET);
        tf = view.findViewById(R.id.text);


        button_ZERO.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_ADD.setOnClickListener(this);
        button_SUB.setOnClickListener(this);
        button_MUL.setOnClickListener(this);
        button_DIV.setOnClickListener(this);
        button_LEFTMOVE.setOnClickListener(this);
        button_RIGHTMOVE.setOnClickListener(this);
        button_EQU.setOnClickListener(this);
        button_AND.setOnClickListener(this);
        //   button_ASCII.setOnClickListener(this);
        button_OR.setOnClickListener(this);
        button_NOT.setOnClickListener(this);
        button_RESET.setOnClickListener(this);
    }



    //按钮控制
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_ZERO2: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (reset) {
                    reset = false;
                    tf.setText("");
                }
                String text = tf.getText().toString();
                tf.setText(text + "0");
                break;
            }
            case R.id.button_1: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                //判断是否需要重置
                if (reset) {
                    reset = false;
                    tf.setText("");
                }
                String text = tf.getText().toString();
                tf.setText(text + "1");
                break;
            }

            case R.id.button_RESET: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                first = "";
                operator = "";
                tf.setText("");
                break;
            }
            case R.id.button_ADD: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (!tf.getText().toString().isEmpty()) {
                    String text = tf.getText().toString();
                    first = text;
                    operator = button_ADD.getText().toString();
                    System.out.println(first + operator);
                    tf.setText(first+operator);
                }
                break;
            }
            case R.id.button_SUB: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (tf.getText().toString().isEmpty()) {
                    System.out.println(false);
                    first = "-";
                    tf.setText("-");
                } else {
                    //System.out.println(false);
                    String text = tf.getText().toString();
                    first = text;
                    operator = button_SUB.getText().toString();
                    System.out.println(text + operator);
                    tf.setText(first+operator);

                }
                break;
            }
            case R.id.button_DIV: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (!tf.getText().toString().isEmpty()) {
                    String text = tf.getText().toString();
                    first = text;
                    operator = button_DIV.getText().toString();
                    System.out.println(text + operator);
                    tf.setText(first+operator);
                }
                break;
            }
            case R.id.button_MULT: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (!tf.getText().toString().isEmpty()) {
                    String text = tf.getText().toString();
                    first = text;
                    operator = button_MUL.getText().toString();
                    System.out.println(text + operator);
                    tf.setText(first+operator);
                }
                break;
            }
            case R.id.button_EQU: {
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (!tf.getText().toString().isEmpty()) {
                    int len = tf.getText().toString().length();
                    String text = tf.getText().toString();
                    int secondNum=0;// = Integer.parseInt(text, 2);
                    int firstNum =0;
                    String total;
                    // System.out.println("second: " + secondNum + "first:" + firstNum);
                    if (operator.equals("+")) {
                        int indexOfOperator = text.indexOf("+");

                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        System.out.println("second: " + secondNum + "first:" + firstNum);
                        total = Integer.toBinaryString(firstNum + secondNum);

                        tf.setText(text+"="+total);
                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }
                    if (operator .equals("-")) {
                        int indexOfOperator = text.indexOf("-");
                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        total = Integer.toBinaryString(firstNum - secondNum);

                        tf.setText(text+"="+total);
                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }
                    if (operator .equals("*") ) {
                        int indexOfOperator = text.indexOf("*");
                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        total = Integer.toBinaryString(firstNum * secondNum);

                        tf.setText(text+"="+total);
                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }
                    if (operator .equals("/")) {
                        int indexOfOperator = text.indexOf("/");

                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        total = Integer.toBinaryString(firstNum / secondNum);

                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }
                    if (operator.equals("&")) {
                        int indexOfOperator = text.indexOf("&");
                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        total = Integer.toBinaryString(firstNum & secondNum);

                        tf.setText(text+"="+total);

                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }
                    if (operator .equals("|")) {
                        int indexOfOperator = text.indexOf("|");
                        firstNum = Integer.parseInt(text.substring(0,indexOfOperator),2);
                        secondNum = Integer.parseInt(text.substring(indexOfOperator+1), 2);
                        total = Integer.toBinaryString(firstNum | secondNum);

                        tf.setText(text+"="+total);
                        //first=total;
                        reset = true;
                        System.out.println(total);
                    }

                    first = "";
                    break;
                }
            }
            case R.id.button_LEFTMOVE:{
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if (!tf.getText().toString().isEmpty()) {
                    String text = tf.getText().toString();
                    text = text + "0";
                    tf.setText(text);

                }
                break;}
            case R.id.button_RIGHTMOVE:{
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if(!tf.getText().toString().isEmpty()) {
                    String text=tf.getText().toString();
                    int length=text.length();
                    String newtext=text.substring(0, length-1);
                    tf.setText(newtext);
                }
                break;

            }
            case R.id.button_AND:{
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if(!tf.getText().toString().isEmpty()) {
                    String text=tf.getText().toString();
                    first=text;
                    operator=button_AND.getText().toString();
                    System.out.println(text+operator);
                    tf.setText(first+operator);
                }
                break;
            }
            case R.id.button_OR:{
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if(!tf.getText().toString().isEmpty()) {
                    String text=tf.getText().toString();
                    first=text;
                    operator=button_OR.getText().toString();
                    System.out.println(text+operator);
                    tf.setText(first+operator);
                }
                break;
            }
            case R.id.button_NOT:{
                if(tf.getText().toString().equals("This is a binary calculator that supports" +
                        " binary arithmetic and logic operations. Try it out!")){
                    tf.setText("");
                }
                if(!tf.getText().toString().isEmpty()) {
                    String text=tf.getText().toString();
                    int length= text.length();
                    String result="";
                    for(int i=0;i<length;i++) {
                        if(text.charAt(i)=='1') {
                            result=result+"0";
                        }else {
                            result=result+"1";
                        }
                    }
                    System.out.println("result:"+result);
                    tf.setText(result);
                }
                break;
            }
        }
    }
}