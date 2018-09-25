package com.example.elenademidova.myapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity{

    private EditText editText;
    private TextView Textview;
    private Button ButtonOK;
    private static final String MY_KEY="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        Textview = (TextView)findViewById(R.id.TextView);
        editText = (EditText)findViewById(R.id.editText);
        ButtonOK = (Button)findViewById(R.id.buttonOK);

        //создаем обработчик нажатия на editText
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Textview.setVisibility(View.INVISIBLE);
            }
        };
        // присвоим обработчик редактируемому полю (editText)
        editText.setOnFocusChangeListener(onFocusChangeListener);

        //создаем обработчик нажатия на кнопку ок
        OnClickListener onClickButtonOK = new OnClickListener() {
            @Override
            public void onClick(View v) {

                //проверим поле на пустоту
                if (TextUtils.isEmpty(editText.getText().toString())){
                    return;
                }
                else if (MY_KEY.equals(editText.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), com.example.elenademidova.myapp.ListActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast toast= Toast.makeText(getApplicationContext(), "Введён неверный ключ", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                }
            }
        };
        //присвоим обработчик кнопке ОК
        ButtonOK.setOnClickListener(onClickButtonOK);

    }

}
