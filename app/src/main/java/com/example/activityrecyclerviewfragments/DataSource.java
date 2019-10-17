package com.example.activityrecyclerviewfragments;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final List<Data> listOfData;

    private DataSource(int n) {
        listOfData = getListOfDataByCount(n);
    }

    public static class Data {
        String leftText;
        String middleText;
        String rightText;

        public Data(String leftText, String middleText, String rightText) {
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

    public List<Data> getListOfData() {
        return listOfData;
    }

    public static List<Data> getListOfDataByCount(int n) {
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

    private static DataSource currentInstance;

    public synchronized static DataSource getInstance(int n) {
        if (currentInstance == null) {
            currentInstance = new DataSource(n);
        }
        return currentInstance;
    }
}
