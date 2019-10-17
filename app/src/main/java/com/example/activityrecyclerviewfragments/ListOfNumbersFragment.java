package com.example.activityrecyclerviewfragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfNumbersFragment extends AbstractFragment {

    private static int countOfNumbers = 100;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerViewAdapterHorizontal recyclerViewAdapterHorizontal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.list_of_numbers_fragment, container, false);
        final RecyclerView recyclerView = inflate.findViewById(R.id.listOfNumbers);
        int orientation = this.getActivity().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewAdapter = new RecyclerViewAdapter(DataSource.
                    getListOfDataByCount(countOfNumbers));
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
            inflate.findViewById(R.id.buttonAddANumber).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<DataSource.Data> listOfDataByCount = DataSource.getListOfDataByCount(++countOfNumbers);
                    recyclerViewAdapter.notifyData(listOfDataByCount);
                }
            });
        } else {
            recyclerViewAdapterHorizontal = new RecyclerViewAdapterHorizontal(DataSourceHorizontal.
                    getListOfDataByCount(countOfNumbers));
            recyclerView.setAdapter(recyclerViewAdapterHorizontal);
            recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
            inflate.findViewById(R.id.buttonAddANumber).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<DataSourceHorizontal.Data> listOfDataByCountHorizontal =
                            DataSourceHorizontal.getListOfDataByCount(++countOfNumbers);
                    recyclerViewAdapterHorizontal.notifyData(listOfDataByCountHorizontal);
                }
            });
        }
        return inflate;
    }
}
