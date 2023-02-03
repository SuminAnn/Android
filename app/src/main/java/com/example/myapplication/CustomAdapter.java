package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    int layout = R.layout.item;
    List<Item> itemList;
    LayoutInflater mLayoutInflater;

    CustomAdapter(List<Item> itemList, LayoutInflater mLayoutInflater){

        this.itemList = itemList;
        this.mLayoutInflater = mLayoutInflater;
    }



    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int icon = itemList.get(position).icon;
        String id = itemList.get(position).id;
        String pass = itemList.get(position).pwd;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(layout, parent, false);
        }


        ImageView Img_icon = convertView.findViewById(R.id.Img_icon);
        TextView  Text_id = convertView.findViewById(R.id.Text_id);
        TextView Text_pwd = convertView.findViewById(R.id.Text_pwd);

        Img_icon.setImageResource(icon);
        Text_id.setText(id);
        Text_pwd.setText(pass);

        return convertView;
    }
}
