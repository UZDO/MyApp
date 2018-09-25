package com.example.elenademidova.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Person> objects;

    ListAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        objects = persons;
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        Person person = getPerson(position);
        // заполняем View в пункте списка данными: имя, возраст
        ((TextView) view.findViewById(R.id.textviewName)).setText(person.getName());
        ((TextView) view.findViewById(R.id.textviewOld)).setText(person.getOld());
        return view;

    }

    // человек по позиции
    private Person getPerson(int position) {
        return ((Person) getItem(position));
    }
}