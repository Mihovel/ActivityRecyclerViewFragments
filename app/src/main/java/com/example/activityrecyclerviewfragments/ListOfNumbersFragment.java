package com.example.activityrecyclerviewfragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfNumbersFragment extends AbstractFragment {

    static int n = 100;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerViewAdapterHorizontal recyclerViewAdapterHorizontal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.list_of_numbers_fragment, container, false);
        Log.i("debug1", "onCreateView" + n);
        final RecyclerView recyclerView = inflate.findViewById(R.id.listOfNumbers);
        int orientation = this.getActivity().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewAdapter = new RecyclerViewAdapter(DataSource.
                    getInstance(n).getListOfDataByCount(n));
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
            inflate.findViewById(R.id.buttonAddANumber).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<DataSource.Data> listOfDataByCount = DataSource.getListOfDataByCount(++n);
                    recyclerViewAdapter.notifyData(listOfDataByCount);
                }
            });
        } else {
            recyclerViewAdapterHorizontal = new RecyclerViewAdapterHorizontal(DataSourceHorizontal.getInstance().
                    getListOfDataByCount(n));

            recyclerView.setAdapter(recyclerViewAdapterHorizontal);
            recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
            inflate.findViewById(R.id.buttonAddANumber).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<DataSourceHorizontal.Data> listOfDataByCountHorizontal =
                            DataSourceHorizontal.getListOfDataByCount(++n);
                    recyclerViewAdapterHorizontal.notifyData(listOfDataByCountHorizontal);
                }
            });
        }
        return inflate;
    }
}
