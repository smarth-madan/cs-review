package com.smadan.clrs.sorting;

import com.smadan.clrs.common.BaseSortTest;
import com.smadan.clrs.common.Sorter;

/**
 * Created by zilof on 10/26/19.
 */
public class SelectionSorterTest extends BaseSortTest {
    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new SelectionSorter<>(NATURAL_COMPARATOR);
    }
}
