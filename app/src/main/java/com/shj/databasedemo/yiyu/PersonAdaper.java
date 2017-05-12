package com.shj.databasedemo.yiyu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shj.databasedemo.R;

import java.util.List;

/**
 * Created by Reus on 2017/5/12.
 */

public class PersonAdaper extends BaseAdapter {
    private List<Person> mList;
    private Context context;
    public PersonAdaper( Context context,List<Person> mList){
        this.context =context;
        this.mList = mList;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            vh.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(mList.get(position).id+" "+mList.get(position).name+" "+mList.get(position).sex+" ");
        return convertView;
    }
    private static class ViewHolder{
        private TextView tv;
    }
}
