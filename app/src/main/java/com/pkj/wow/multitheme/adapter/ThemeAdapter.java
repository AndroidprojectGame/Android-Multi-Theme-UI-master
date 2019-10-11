package com.pkj.wow.multitheme.adapter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkj.wow.multitheme.DemoActivity;
import com.pkj.wow.multitheme.R;
import com.pkj.wow.multitheme.ScrollingActivity1;
import com.pkj.wow.multitheme.TestActivity1;
import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.view.ThemeView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.MyViewHolder> {
 
    private List<Theme> themeList;
    private RecyclerViewClickListener mRecyclerViewClickListener;
    Activity activity;
 
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ThemeView themeView;
        private RecyclerViewClickListener mListener;
 
        public MyViewHolder(View view, RecyclerViewClickListener listener) {
            super(view);
            mListener = listener;
            themeView = (ThemeView) view.findViewById(R.id.themeView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
            ScrollingActivity1.selectedTheme = getAdapterPosition();

            SharedPreferences.Editor editor = activity.getSharedPreferences("Theme", MODE_PRIVATE).edit();
            editor.putInt("id", getAdapterPosition());
            editor.apply();

            ScrollingActivity1.mTheme = ScrollingActivity1.mThemeList.get(getAdapterPosition()).getId();
            TestActivity1.mTheme=  ScrollingActivity1.mThemeList.get(getAdapterPosition()).getId();
            DemoActivity.mTheme=  ScrollingActivity1.mThemeList.get(getAdapterPosition()).getId();
            themeView.setActivated(true);
            ThemeAdapter.this.notifyDataSetChanged();
        }
    }
 
 
    public ThemeAdapter(List<Theme> themeList,Activity activity, RecyclerViewClickListener recyclerViewClickListener) {
        this.themeList = themeList;
        mRecyclerViewClickListener = recyclerViewClickListener;
        this.activity=activity;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_theme, parent, false);
        return new MyViewHolder(itemView, mRecyclerViewClickListener);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Theme theme = themeList.get(position);
        holder.themeView.setTheme(theme);

        if(ScrollingActivity1.selectedTheme == position){
            holder.themeView.setActivated(true);
        }else {
            holder.themeView.setActivated(false);
        }
    }
 
    @Override
    public int getItemCount() {
        return themeList.size();
    }
}