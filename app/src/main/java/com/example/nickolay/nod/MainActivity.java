package com.example.nickolay.nod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    private static final String KEY_NUM = "NUM";
    private static final String KEY_NUM2 = "NUM2";
    int a, b, nod;
    NOD result = new NOD();

    public static final String EXTRA_MESSAGE = "com.example.nickolay.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Магический поворот экрана");
        outState.putInt(KEY_NUM, a);
        outState.putInt(KEY_NUM2, b);
    }

    private static final String TAG = "myLogs";

    public void onButtonClick(View v) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText num1 = (EditText) findViewById(R.id.num);
        EditText num2 = (EditText) findViewById(R.id.num2);

        a = Integer.parseInt(num1.getText().toString());
        b = Integer.parseInt(num2.getText().toString());
        Log.d(TAG, "Найдём НОД чисел " + a + " " + b);

            nod=result.resNod(a,b);

        String message = Integer.toString(nod);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        result.showList();

    }

    public class NOD {
        private LinkedList<Integer> List = new LinkedList<Integer>();

        public int resNod(int a, int b) {
            List.add(a);
            List.add(b);
            while (a != 0 && b != 0) {
                if (a > b)
                    a %= b;
                else
                    b %= a;
            }
                List.add(a+b);
                return a+b;

        }
        public void showList(){
                for(int i=0;i<List.size();i+=3) {
                    Log.d(TAG, " num1 = " + List.get(i) + " num2 = " + List.get(i + 1) + " answer = " + List.get(i + 2));
                }
            }

        public void clearList(){
            List.clear();
        }


    }
}
