package com.smadan.clrs.sorting;

import com.smadan.clrs.common.BaseSortTest;
import com.smadan.clrs.common.Sorter;

/**
 * Created by zilof on 10/26/19.
 */
public class MergeSorterTest extends BaseSortTest {

    protected Sorter<Integer> getAscendingSorter() {
        return new MergeSorter<>(NATURAL_COMPARATOR);
    }
}
