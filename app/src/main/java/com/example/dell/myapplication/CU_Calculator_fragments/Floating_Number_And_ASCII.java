package com.example.dell.myapplication.CU_Calculator_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.myapplication.R;

import static java.lang.Integer.parseInt;

public class Floating_Number_And_ASCII extends Fragment implements View.OnClickListener {
    String str1 = "";
    String str2 = "";

    Button button_CHAR2ASCII;
    Button button_ASCII2CHAR;
    Button button_Decimal_Fraction2Floating;
    Button button_Floating2Decimal_Fraction;
    EditText editText_CHAR;
    EditText editText_ASCII;
    EditText editText_Decimal_Fraction;
    EditText editText_Floating;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View calcLayout = inflater.inflate(R.layout.fragment_folating_number_and_ascii, container, false);
        initViews(calcLayout);


        return calcLayout;

    }

    private void initViews(View view) {
        button_CHAR2ASCII = view.findViewById(R.id.button_CHARTOASCII);
        button_ASCII2CHAR = view.findViewById(R.id.button_ASCII2CHAR);
        button_Decimal_Fraction2Floating = view.findViewById(R.id.button_DECIMAL_FRACTION_TO_FLOATING);
        button_Floating2Decimal_Fraction = view.findViewById(R.id.button_FLOATING_TO_DECIMAL_FRACTION);
        editText_CHAR = view.findViewById(R.id.editText_char);
        editText_ASCII = view.findViewById(R.id.editText_ASCII);
        editText_Decimal_Fraction = view.findViewById(R.id.editText_decimal_fraction);
        editText_Floating = view.findViewById(R.id.editText_Floating);

        button_CHAR2ASCII.setOnClickListener(this);
        button_ASCII2CHAR.setOnClickListener(this);
        button_Decimal_Fraction2Floating.setOnClickListener(this);
        button_Floating2Decimal_Fraction.setOnClickListener(this);
        editText_CHAR.setOnClickListener(this);
        editText_ASCII.setOnClickListener(this);
        editText_Decimal_Fraction.setOnClickListener(this);
        editText_Floating.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_CHARTOASCII: {
                if (editText_CHAR.getText().toString().equals("") == false) {
                    editText_ASCII.setText(""+(int) editText_CHAR.getText().toString().toCharArray()[0]);
                }
                break;
            }
            case R.id.button_ASCII2CHAR: {
                if (editText_ASCII.getText().toString().equals("") == false) {
                            //   try {
                        editText_CHAR.setText(""+((char) parseInt(editText_ASCII.getText().toString())));
                   // } catch (Exception e) {

                    //} finally {
                      //  break;
                    //}
                }
                break;
            }
            case R.id.button_DECIMAL_FRACTION_TO_FLOATING: {
                if (editText_Decimal_Fraction.getText().toString().equals("") == false) {
                    String binaryFloatPointArray = "";
                    String[] temp = editText_Decimal_Fraction.getText().toString()
                            .split("\\.");//用小数点分割输入值
                    long integerPart = Long.parseLong(temp[0]);
                    double decimalPart = Double.parseDouble("0." + temp[1]);
                    String binaryIntegerString = Long.toBinaryString(integerPart);//十进制整数转换为二进制整数字符串
                    String binaryDecimalString = doubleToBinaryString(decimalPart);//十进制小数转换为二进制小数字符串
                    binaryFloatPointArray = getFloatPointArray(binaryIntegerString, binaryDecimalString);//获得二进制浮点字符串
                    editText_Floating.setText(""+binaryFloatPointArray);
                }
                break;
            }
            case R.id.button_FLOATING_TO_DECIMAL_FRACTION: {

                if (editText_Floating.getText().toString().equals("") == false
                        && (editText_Floating.getText().toString().length() == 32
                        ||editText_Floating.getText().toString().length() ==34)) {
                    String strr =editText_Floating.getText().toString();
                    double db = getOriginalInput(strr);
                    editText_Decimal_Fraction.setText(""+db);
                }
                break;
            }
            default:
                break;
        }
    }


    private static final String intervalChar = " "; //二进制浮点字符串中的间隔符，便于查看和处理
    private static long E = 0;//指数值
    private static final long bias = 127;//指数偏移值
    private static long e = 0;//十进制指数存储值 = 指数值 + 指数便宜值

    /**
     * 输入：二进制整数字符串，二进制小数字符串
     * 输出：IEEE 754标准的二进制浮点数字符串
     **/

    private static String getFloatPointArray(String binaryIntegerString, String binaryDecimalString) {
        String result = "";
        if (!binaryIntegerString.equals("0")) { //输入值 > 1
            E = binaryIntegerString.length() - 1;//获得小数点前移的位数
            e = E + bias;//十进制指数存储值
            result = "0" + intervalChar
                    + autoCompleteBinaryExponentArray(Long.toBinaryString(e)) +
                    intervalChar
                    + autoCompleteBinaryDecimalArray(binaryIntegerString.substring(1, binaryIntegerString.length()) + binaryDecimalString);
        } else {
            if (binaryDecimalString.indexOf("1") >= (126 - 1)) { //输入值 <= 2^(-125)
                result = "0"
                        + intervalChar
                        + "00000000"
                        + intervalChar
                        + autoCompleteBinaryDecimalArray(binaryDecimalString.substring(126, binaryDecimalString.length()));
            } else { //输入值介于 2^(-125) 与 1 之间
                E = binaryDecimalString.indexOf("1") + 1;
                e = 0 - E + bias;
                result = "0"
                        + intervalChar
                        + autoCompleteBinaryExponentArray(Long.toBinaryString(e))
                        + intervalChar
                        + autoCompleteBinaryDecimalArray(binaryDecimalString.
                        substring((int) E, binaryDecimalString.length()));
            }
        }
        return result;
    }

    private static String autoCompleteBinaryExponentArray(String input) {
        String temp = "00000000";//8 zeros
        if (input.length() > 8) {
            System.out.println("Overflow Error in Exponent Part");
        }
        return temp.substring(0, 8 - input.length()) + input;
    }

    private static String autoCompleteBinaryDecimalArray(String input) {
        String temp = "00000000000000000000000";//23 zeros
        if (input.length() > 23) {
            return input.substring(0, 23);
        } else {
            return input + temp.substring(0, 23 - input.length());


        }





    }
    private static String doubleToBinaryString(double input2 ){
        String result = "";
        int temp2 = 0;
        for (int i = 0; i < 150; i++){
            temp2 = (int) (input2 * 2);
            input2 = input2 * 2 - (double)temp2;
            result += temp2;
        }
        return result;
    }


    /**
     * 输入：二进制浮点数字符串
     * 输出：double类型的十进制小数值
     ***/
    private static double getOriginalInput(String floatPointArray){
        String[] results = floatPointArray.split(intervalChar);
        double originInput = 0.0;
        if (results[1].equals("00000000")){ //非规格化值
            originInput = binaryStringToDouble(results[2]) * Math.pow(2, -126);
        } else if (!results[1].equals("11111111")){ //规格化值
            originInput = (binaryStringToDouble(results[2]) + 1) * Math.pow(2, Integer.valueOf(results[1], 2) - bias);
        }
        return originInput;
    }
    private static double binaryStringToDouble(String input){
        double output = 0;
        for (int i = 0; i < input.length(); i++){
            output += (Double.parseDouble(String.valueOf(input.charAt(i)))) /(Math.pow(2, i + 1));
        }
        return output;
    }

}
