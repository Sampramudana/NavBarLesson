package com.pramudana.sam.navbarlesson;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sampramudana on 2/12/18.
 */

public class ListAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] pict;
    Context mContext;

    public ListAdapter(@NonNull Context context, String[] dataName, int[] pictList) {
        super(context, R.layout.listview_item);

        this.names = dataName;
        this.pict = pictList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mPict = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        }else {

            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.mPict.setImageResource(pict[position]);
        mViewHolder.mName.setText(names[position]);

        return convertView;
    }
    static class ViewHolder {

        ImageView mPict;
        TextView mName;

    }
}
