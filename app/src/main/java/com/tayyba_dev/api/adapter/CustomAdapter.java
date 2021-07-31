package com.tayyba_dev.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tayyba_dev.api.model.Hits;
import com.tayyba_dev.api.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Hits> hits;


    public CustomAdapter(Context context, List<Hits> hits) {
        this.context = context;
        this.hits = hits;
    }

    @Override
    public int getCount() {
        return hits.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);

        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textView=convertView.findViewById(R.id.view);
        textView.setText(hits.get(position).getName());

        Glide.with(context).load(hits.get(position).getImageurl()).into(imageView);

        return convertView;
    }
}

