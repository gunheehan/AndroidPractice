package com.redhorse.caclulatoer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private enum CaculateType{
        Add,
        Minus,
        Multiply,
        Divide
    }

    EditText editTextNum1;
    EditText editTextNum2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNum1 = findViewById(R.id.activity_main__editTextNum1);
        editTextNum2 = findViewById(R.id.activity_main__editTextNum2);
        textView = findViewById(R.id.activity_main__textViewRs);
    }

    private boolean CheckInputValue()
    {
        editTextNum1.setText(editTextNum1.getText().toString().trim());

        if(editTextNum1.getText().toString().length() == 0){
            toast("숫자 1을 입력해주세요");
            editTextNum1.requestFocus();
            return false;
        }

        editTextNum2.setText(editTextNum2.getText().toString().trim());

        if(editTextNum2.getText().toString().length() == 0){
            toast("숫자 2을 입력해주세요");
            editTextNum2.requestFocus();
            return false;
        }

        return true;
    }

    private void OnCaculater(CaculateType type)
    {
        if(!CheckInputValue())
            return;

        int rs = 0;
        int num1 = Integer.parseInt(editTextNum1.getText().toString());
        int num2 = Integer.parseInt(editTextNum2.getText().toString());

        switch (type){

            case Add:
                rs = num1 + num2;
                break;
            case Minus:
                rs = num1 - num2;
                break;
            case Multiply:
                rs = num1 * num2;
                break;
            case Divide:
                rs = num1 / num2;
                break;
        }

        textView.setText("결과 " + rs);
        editTextNum1.setText("");
        editTextNum2.setText("");
    }

    public void btnAddClicked(View view) {
        OnCaculater(CaculateType.Add);
    }

    public void btnMinusClicked(View view) {
        OnCaculater(CaculateType.Minus);
    }

    public void btnClearClicked(View view) {
        editTextNum1.setText("");
        editTextNum2.setText("");
    }

    private void toast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}