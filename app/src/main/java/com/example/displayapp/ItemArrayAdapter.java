package com.example.displayapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {

    private List<String[]> scoreList = new ArrayList<String[]>();

    static class ItemViewHolder {
        TextView subject;
        TextView au;
        TextView grade;
    }

    public ItemArrayAdapter(Context context, int resourse) {
        super (context, resourse);
    }

    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int position) {
        return this.scoreList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.subject = (TextView) row.findViewById(R.id.subject);
            viewHolder.au = (TextView) row.findViewById(R.id.au);
            viewHolder.grade = (TextView) row.findViewById(R.id.grade);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) row.getTag();
        }

        String[] stat = getItem(position);
        viewHolder.subject.setText(stat[0]);
        viewHolder.au.setText(stat[1]);
        viewHolder.grade.setText(stat[2]);
        return row;
    }
}
