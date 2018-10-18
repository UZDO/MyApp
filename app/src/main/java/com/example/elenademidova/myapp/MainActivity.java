package com.example.elenademidova.myapp;

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


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView Textview;
    private Button ButtonOK;
    private static final String MY_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeneres();
    }

    private void initViews() {
        Textview = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        ButtonOK = (Button) findViewById(R.id.buttonOK);

    }

    private void initListeneres() {
        // присвоим обработчик редактируемому полю (editText)
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Textview.setVisibility(View.INVISIBLE);
            }
        });

        //присвоим обработчик кнопке ОК
        ButtonOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextString = editText.getText().toString();
                if (!TextUtils.isEmpty(editTextString)) {
                    if (MY_KEY.equals(editTextString)) {
                        Intent intent = new Intent(getApplicationContext(), com.example.elenademidova.myapp.ListActivity.class);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Введён неверный ключ", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                    }
                }
            }
        });

    }


}