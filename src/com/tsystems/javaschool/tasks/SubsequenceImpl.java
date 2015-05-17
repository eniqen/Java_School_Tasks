package com.tsystems.javaschool.tasks;

import java.util.*;

/**
 * Created by Mikhail Nemenko on 16.05.2015.
 */
public class SubsequenceImpl implements Subsequence {
    @Override
    public boolean find(List x, List y) {
        int count = 0;
        int marker = 0;
        for (int i = 0; i < x.size(); i++) {
            for (int j = marker; j < y.size(); j++) {
                if (x.get(i).equals(y.get(j))) {
                    count++;
                    marker = j;
                    break;
                }
            }
        }
        return x.size() == count ? true : false;
    }
}
