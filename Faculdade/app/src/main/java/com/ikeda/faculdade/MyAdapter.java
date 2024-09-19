package com.ikeda.faculdade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter< MyAdapter.MyViewHolder> {
    private String[][] mDataset;
    private Context context;

    public MyAdapter(String[][] myDataset,Context context_) {
        mDataset = myDataset;
        this.context = context_;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.line,
                parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position][0]);
        holder.textView2.setText(mDataset[position][1]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;

        public MyViewHolder(View v) {
            super(v);
            v.findViewById(R.id.my_text_view);
            v.findViewById(R.id.my_text_view2);
            textView = v.findViewById(R.id.my_text_view);
            textView2 = v.findViewById(R.id.my_text_view2);
        }
    }


}

