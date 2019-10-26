package com.smadan.clrs.sorting;

import com.smadan.clrs.common.ArrayUtils;
import com.smadan.clrs.common.Sorter;

import java.util.Comparator;

/**
 * Created by zilof on 10/25/19.
 */
public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

    private final Comparator<E> comparator;

    public SelectionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(E[] items) {
        for (int i = 0; i < items.length; i ++) {
            int localMinimum = i;
            for(int j=i+1;j<items.length;j++) {
                localMinimum = comparator.compare(items[j], items[localMinimum]) < 0 ? j : localMinimum;
            }
            ArrayUtils.swap(items, i, localMinimum);
        }
    }
}
