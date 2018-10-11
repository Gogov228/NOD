package com.example.nickolay.nod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.nickolay.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static final String TAG ="myLogs";


    public void onButtonClick(View v){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
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

        String message=Integer.toString(a+b);
        Result.setText(Integer.toString(a+b));
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
