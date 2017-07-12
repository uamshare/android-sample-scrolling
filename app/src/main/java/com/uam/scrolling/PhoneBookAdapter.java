package com.uam.scrolling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Iforce on 7/12/2017.
 */

public class PhoneBookAdapter extends BaseAdapter {
    private Context mContext;
    private List<PhoneBook> listPhoneBook;

    public PhoneBookAdapter(Context context, List<PhoneBook> list) {
        mContext = context;
        listPhoneBook = list;
    }

    @Override
    public int getCount() {
        return listPhoneBook.size();
    }

    @Override
    public Object getItem(int pos) {
        return listPhoneBook.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // get selected entry
        PhoneBook entry = listPhoneBook.get(pos);

        // inflating list view layout if null
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        // set avatar
        ImageView ivAvatar = (ImageView)convertView.findViewById(R.id.imgAvatar);
        ivAvatar.setImageBitmap(entry.getAvatar());

        // set name
        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
        tvName.setText(entry.getName());

        // set phone
        TextView tvPhone = (TextView)convertView.findViewById(R.id.tvPhone);
        tvPhone.setText(entry.getPhone());

        // set email
        TextView tvEmail = (TextView)convertView.findViewById(R.id.tvEmail);
        tvEmail.setText(entry.getEmail());

        return convertView;
    }
}
