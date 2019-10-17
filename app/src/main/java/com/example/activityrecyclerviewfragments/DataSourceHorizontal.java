package com.example.activityrecyclerviewfragments;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DataSourceHorizontal {

    public static class Data {
        String text1;
        String text2;
        String text3;
        String text4;


        Data(String text1, String text2, String text3, String text4) {
            this.text1 = text1;
            this.text2 = text2;
            this.text3 = text3;
            this.text4 = text4;
        }

        @NonNull
        @Override
        public String toString() {
            return text1 + " " + text2 + " " + text3 + " " + text4;
        }
    }

    static List<Data> getListOfDataByCount(int n) {
        List<Data> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i += 4) {
            if ((n % 4 == 1) && (i == n)) {
                resultList.add(new Data(String.valueOf(i), "",
                        "", ""));
                Log.i("Misha", String.valueOf(i));
                continue;
            }
            if ((n % 4 == 2) && (i == n - 1)) {
                resultList.add(new Data(String.valueOf(i), String.valueOf(i + 1),
                        "", ""));
                continue;
            }
            if ((n % 4 == 3) && (i == n - 2)) {
                resultList.add(new Data(String.valueOf(i), String.valueOf(i + 1),
                        String.valueOf(i + 2), ""));
                continue;
            }
            resultList.add(new Data(String.valueOf(i), String.valueOf(i + 1),
                    String.valueOf(i + 2), String.valueOf(i + 3)));
        }
        return resultList;
    }
}
