package com.example.activityrecyclerviewfragments;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

class DataSource {

    public static class Data {
        String leftText;
        String middleText;
        String rightText;

        Data(String leftText, String middleText, String rightText) {
            this.leftText = leftText;
            this.middleText = middleText;
            this.rightText = rightText;
        }

        @NonNull
        @Override
        public String toString() {
            return leftText + " " + middleText + " " + rightText;
        }
    }

    static List<Data> getListOfDataByCount(int n) {
        List<Data> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i += 3) {
            if ((n % 3 == 1) && (i == n)) {
                resultList.add(new Data(String.valueOf(i), "", ""));
                continue;
            }
            if ((n % 3 == 2) && (i == n - 1)) {
                resultList.add(new Data(String.valueOf(i), String.valueOf(i + 1), ""));
                continue;
            }
            resultList.add(new Data(String.valueOf(i), String.valueOf(i + 1),
                    String.valueOf(i + 2)));
        }
        return resultList;
    }

}
