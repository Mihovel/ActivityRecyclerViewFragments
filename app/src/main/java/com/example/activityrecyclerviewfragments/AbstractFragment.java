package com.example.activityrecyclerviewfragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//дебаг-класс
public abstract class AbstractFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LifeCycle", "onActivityCreated");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("LifeCycle", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle", "onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("LifeCycle", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("LifeCycle", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("LifeCycle", "onDetach");
    }
}

