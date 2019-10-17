package com.example.activityrecyclerviewfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderHorizontal extends RecyclerView.ViewHolder {

    public static final String NUMBER = "NUMBER";
    public final Button button1;
    public final Button button2;
    public final Button button3;
    public final Button button4;
    public Context currentContext = itemView.getContext();

    public ViewHolderHorizontal(@NonNull final View itemView) {
        super(itemView);
        button1 = itemView.findViewById(R.id.button1);
        button2 = itemView.findViewById(R.id.button2);
        button3 = itemView.findViewById(R.id.button3);
        button4 = itemView.findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) button1.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) button2.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) button3.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) button4.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
    }

    public void toShowNumberFragment(String putNumber) {
        ShowNumberFragment showNumberFragment = new ShowNumberFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NUMBER, putNumber);
        showNumberFragment.setArguments(bundle);
        AppCompatActivity appCompatActivity = (AppCompatActivity) currentContext;
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, showNumberFragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
