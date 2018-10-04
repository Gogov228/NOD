package com.example.nickolay.nod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static final String TAG ="myLogs";

    public void onButtonClick(View v){
        EditText num1=(EditText)findViewById(R.id.num);
        EditText num2=(EditText)findViewById(R.id.num2);
        TextView Result=(TextView)findViewById(R.id.Result);

        int a=Integer.parseInt(num1.getText().toString());
        int b=Integer.parseInt(num2.getText().toString());
        Log.i(TAG,"Находим НОД чисел "+a+" "+b);
        try {
            while(a!=0&&b!=0) {
                if(a>b)
                    a%=b;
                else
                    b%=a;

            }
            Log.i(TAG,"Результат: "+(a+b));
        } catch (Exception e) {
            Log.d(TAG,"Ошибка в вычислении, хотя хз какая может быть ошибка)");
        }
        Result.setText(Integer.toString(a+b));

    }


}
