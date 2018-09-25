package com.example.elenademidova.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ArrayList<Person> persons = new ArrayList<Person>();
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        persons = fillListWithPersons();
        // создаем адаптер
        listAdapter = new ListAdapter(this, persons);

        // настраиваем список
        ListView listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(listAdapter);
    }

    private ArrayList<Person> fillListWithPersons() {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Андрей","21 год"));
        list.add(new Person("Сергей","19 лет"));
        list.add(new Person("Мария", "30 лет"));
        list.add(new Person("Константин", "40 лет"));
        return list;
    }


}




