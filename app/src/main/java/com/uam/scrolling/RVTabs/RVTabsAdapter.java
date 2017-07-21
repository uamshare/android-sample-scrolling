package com.uam.scrolling.RVTabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uam.scrolling.R;

import java.util.ArrayList;
import java.util.List;

import at.grabner.circleprogress.CircleProgressView;

/**
 * Created by Iforce on 7/17/2017.
 */

public class RVTabsAdapter extends RecyclerView.Adapter<RVTabsAdapter.ViewHolder> {

    private List<RVTabsModel> items;
    private final LayoutInflater inflater;
    View view;
    RVTabsAdapter.ViewHolder holder;
    private Context context;

    public RVTabsAdapter(Context context){
        this.context=context;
        inflater= LayoutInflater.from(context);
        items = new ArrayList<>();
    }

    @Override
    public RVTabsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.item_simple, parent, false);
        holder = new RVTabsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RVTabsAdapter.ViewHolder holder, int position) {
        RVTabsModel list_items = items.get(position);

        holder.user_name.setText(list_items.getName());
        holder.content.setText(list_items.getContent());
        holder.time.setText(list_items.getTime());
        holder.mCircleView.setValue(list_items.getProgress());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Setting the arraylist
    public void setListContent(ArrayList<RVTabsModel> items){
        this.items = items;
        notifyItemRangeChanged(0,items.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView user_name,content,time;
        CircleProgressView mCircleView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            content=(TextView)itemView.findViewById(R.id.content);
            time=(TextView)itemView.findViewById(R.id.time);
            mCircleView = (CircleProgressView) itemView.findViewById(R.id.picture);
        }

        @Override
        public void onClick(View v) {

        }

    }
}