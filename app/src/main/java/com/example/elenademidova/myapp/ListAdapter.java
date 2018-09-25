package com.example.elenademidova.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Person> objects;

    ListAdapter(Context context, ArrayList<Person> persons) {
        ctx = context;
        objects = persons;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // человек по позиции
    Person getPerson(int position) {
        return ((Person) getItem(position));
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }
        Person p = getPerson(position);
        // заполняем View в пункте списка данными: имя, возраст
        ((TextView) view.findViewById(R.id.textviewName)).setText(p.name);
        ((TextView) view.findViewById(R.id.textviewOld)).setText(p.old);
        return view;

    }
}