package com.example.wangyunwen.lab3;

import java.lang.String;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;

/**
 * Created by wangyunwen on 16/10/13.
 */


public class MyAdapter extends BaseAdapter {
    private List<Contact> list;
    private Context context;

    public MyAdapter(Context context, List<Contact> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        if(list == null)
            return 0;
        else
            return list.size();
    }

    @Override
    public Contact getItem(int i) {
        if(list == null)
            return null;
        else
            return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView;
        ViewHolder viewHolder;

        if(view == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.initial = (Button) convertView.findViewById(R.id.initial);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            convertView = view;
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.initial.setText(list.get(i).getName().substring(0, 1));
        viewHolder.name.setText(list.get(i).getName());

        return convertView;
    }
    private class ViewHolder {
        public Button initial;
        public TextView name;
    }
}
