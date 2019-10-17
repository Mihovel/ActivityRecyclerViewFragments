package com.example.activityrecyclerviewfragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderTexts> {

    private List<DataSource.Data> myData;

    RecyclerViewAdapter(List<DataSource.Data> myData) {
        this.myData = myData;
    }

    @NonNull
    @Override
    public ViewHolderTexts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewOfListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.three_numbers,
                parent, false);
        return new ViewHolderTexts(viewOfListItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTexts holder, int position) {
        DataSource.Data data = myData.get(position);
        holder.leftNumberButton.setText(data.leftText);
        holder.middleNumberButton.setText(data.middleText);
        holder.rightNumberButton.setText(data.rightText);
        setButtonColor(holder, position);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    private void setButtonColor(@NonNull ViewHolderTexts holder, int position) {
        //В зависимости от номера строчки, четность чисел меняется
        if (position % 2 == 1) {
            holder.leftNumberButton.setTextColor(Color.RED);
            holder.middleNumberButton.setTextColor(Color.BLUE);
            holder.rightNumberButton.setTextColor(Color.RED);
        } else {
            holder.leftNumberButton.setTextColor(Color.BLUE);
            holder.middleNumberButton.setTextColor(Color.RED);
            holder.rightNumberButton.setTextColor(Color.BLUE);
        }
    }

    void notifyData(List<DataSource.Data> list) {
        this.myData = list;
        notifyDataSetChanged();
    }
}
