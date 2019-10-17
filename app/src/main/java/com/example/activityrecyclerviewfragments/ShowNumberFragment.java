package com.example.activityrecyclerviewfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

import static com.example.activityrecyclerviewfragments.ViewHolderTexts.NUMBER;

public class ShowNumberFragment extends AbstractFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_number_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle incomeNumber = getArguments();
        String number = Objects.requireNonNull(incomeNumber).getString(NUMBER);
        ((TextView) view.findViewById(R.id.showNumber)).setText(number);
        assert number != null;
        if (Integer.parseInt(number) % 2 == 1) {
            ((TextView) view.findViewById(R.id.showNumber)).setTextColor(Color.BLUE);
        } else {
            ((TextView) view.findViewById(R.id.showNumber)).setTextColor(Color.RED);
        }

    }
}
