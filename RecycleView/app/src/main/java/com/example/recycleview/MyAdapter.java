package com.example.recycleview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    ArrayList<modle> lst;

    public MyAdapter(ArrayList<modle> lst) {
        this.lst = lst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modle modle = lst.get(position);
        holder.t1.setText(modle.getName());
        holder.t2.setText(modle.getNumber());

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 =itemView.findViewById(R.id.text1);
            t2 =itemView.findViewById(R.id.text2);
        }
    }


}

