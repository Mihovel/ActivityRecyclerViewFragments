package com.example.activityrecyclerviewfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderTexts extends RecyclerView.ViewHolder {

    static final String NUMBER = "NUMBER";
    final Button leftNumberButton;
    final Button middleNumberButton;
    final Button rightNumberButton;
    private Context currentContext = itemView.getContext();

    ViewHolderTexts(@NonNull final View itemView) {
        super(itemView);
        leftNumberButton = itemView.findViewById(R.id.leftNumberButton);
        middleNumberButton = itemView.findViewById(R.id.middleNumberButton);
        rightNumberButton = itemView.findViewById(R.id.rightNumberButton);

        leftNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) leftNumberButton.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
        middleNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) middleNumberButton.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
        rightNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendNumber = (String) rightNumberButton.getText();
                if (!sendNumber.equals("")) {
                    toShowNumberFragment(sendNumber);
                }
            }
        });
    }

    private void toShowNumberFragment(String s) {
        ShowNumberFragment showNumberFragment = new ShowNumberFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NUMBER, s);
        showNumberFragment.setArguments(bundle);
        AppCompatActivity appCompatActivity = (AppCompatActivity) currentContext;
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, showNumberFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
