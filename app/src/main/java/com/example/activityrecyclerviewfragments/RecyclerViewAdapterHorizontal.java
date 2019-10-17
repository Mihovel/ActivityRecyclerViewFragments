package com.example.activityrecyclerviewfragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterHorizontal extends RecyclerView.Adapter<ViewHolderHorizontal> {

    public List<DataSourceHorizontal.Data> myData;

    public RecyclerViewAdapterHorizontal(List<DataSourceHorizontal.Data> myData) {
        this.myData = myData;
    }

    @NonNull
    @Override
    public ViewHolderHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewOfListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.four_numbers,
                parent, false);
        return new ViewHolderHorizontal(viewOfListItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHorizontal holder, int position) {
        DataSourceHorizontal.Data data = myData.get(position);
        holder.button1.setText(data.text1);
        holder.button2.setText(data.text2);
        holder.button3.setText(data.text3);
        holder.button4.setText(data.text4);
        setButtonColor(holder);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    private void setButtonColor(@NonNull ViewHolderHorizontal holder) {
        holder.button1.setTextColor(Color.BLUE);
        holder.button2.setTextColor(Color.RED);
        holder.button3.setTextColor(Color.BLUE);
        holder.button4.setTextColor(Color.RED);
    }

    public void notifyData(List<DataSourceHorizontal.Data> list) {
        this.myData = list;
        notifyDataSetChanged();
    }
}
