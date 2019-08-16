package com.coxtunes.listviewcheckbox;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SubCategoryAdapter extends ArrayAdapter<SubCategory> {

    private ArrayList<SubCategory> subCategories;

    public SubCategoryAdapter(Context context, int iewResourceId, ArrayList<SubCategory> subCategories) {
        super(context, iewResourceId, subCategories);
        this.subCategories = new ArrayList<SubCategory>();
        this.subCategories.addAll(subCategories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater vi = ((Activity) getContext()).getLayoutInflater();

            convertView = vi.inflate(R.layout.custom_layout, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.status = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SubCategory subCategory = subCategories.get(position);
        holder.title.setText(subCategory.getTitle());
        holder.status.setChecked(subCategory.isStatus());
        return convertView;

    }

    private class ViewHolder {
        TextView title;
        CheckBox status;
    }

}
