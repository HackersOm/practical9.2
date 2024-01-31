package com.example.simplecaculator2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt ;
    int num1 =0;
    int num2 = 0;
    String result = "";
    TextView txt ;
    String operator ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt= (EditText)findViewById(R.id.edt1);
        txt = (TextView)findViewById(R.id.result);


    }
    public void Display(View view) {
        Button btn = ((Button) view).findViewById(view.getId());
        String str = edt.getText().toString();
        str+=btn.getText().toString();
            edt.setText(str);


    }



    public void add(View view)
    {
        edt.setText(edt.getText()+" + ");
        operator = "+";
    }
    public void sub(View view)
    {
        edt.setText(edt.getText().toString()+" - ");
        operator = "-";
    }
    public void mul(View view)
    {
        edt.setText(edt.getText().toString()+" * ");
        operator = "*";
    }
    public void div(View view)
    {
        edt.setText(edt.getText().toString()+" / ");
        operator = "/";
    }
    public void ac(View view)
    {
        edt.setText("");
        txt.setText("");
    }
    public void Del(View view)
    {
        if(txt.getText()==""){
            edt.setText("");
        }
        else {
            String str = edt.getText().toString();
            edt.setText(str.substring(0, str.length() - 1));
            txt.setText("");
        }
    }
    public void assign(View view)
    {

        if(edt.getText().equals(" ")) {
          edt.setText(" Value is empty");
       }
        else {
          result=edt.getText().toString();
        String[] str = result.split(" ");
        num1 = Integer.parseInt(str[0]);
        num2 = Integer.parseInt(str[2]);
          //  Log.d("Action",num1+"and "+num2);
            switch (operator) {
                case "+":
                    txt.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    txt.setText(String.valueOf(num1 - num2));
                    break;
                case "*":
                    txt.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 == 0)
                        txt.setText("Error Cannot Divide by Zero");
                    else
                        txt.setText(String.valueOf(num1 / num2));
                    break;
            }
        }
    }

}