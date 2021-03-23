package com.playground.android101.datasource;

import com.playground.android101.model.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DummyDataService {

    private final List<DummyData> data = new ArrayList<>();

    public DummyDataService(int amountOfDummyData) {
        fillWithDummyData(amountOfDummyData);
    }

    private void fillWithDummyData(int amount) {
        int initialDimension = 48; //needed only to make different urls
        for (int i = 1; i <= amount; i++) {
            data.add(new DummyData("https://picsum.photos/"+(initialDimension+i), "Dummy title "+i, "Dummy description "+i));
        }
    }

    public List<DummyData> getData() {
        return data;
    }
}
