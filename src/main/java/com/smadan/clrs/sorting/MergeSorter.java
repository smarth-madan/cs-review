package com.smadan.clrs.sorting;

import com.smadan.clrs.common.Sorter;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by zilof on 10/26/19.
 */
public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {
    private final Comparator<E> comparator;

    public MergeSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(E[] items) {
       sort(items, 0, items.length);
    }

    protected void sort(E[] items, int from, int to) {
        if(to - from < 2) {
            return;
        }
        int mid = from + (to-from)/2;
        sort(items, from, mid);
        sort(items, mid, to);
        merge(items, from, mid, to);
    }

    protected void merge(E[] array, int from, int mid, int to) {
        final E[] left= (E[]) Array.newInstance(array.getClass().getComponentType(), mid - from);
        final E[] right = (E[]) Array.newInstance(array.getClass().getComponentType(), to - mid);
        System.arraycopy(array, from, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        int leftCursor = 0;
        int rightCursor = 0;
        int cursor=from;
        while (cursor < to) {
              E leftItem = leftCursor < left.length ? left[leftCursor] : null;
              E rightItem = rightCursor < right.length ? right[rightCursor] : null;
              if(leftItem != null && rightItem != null) {
                  if(comparator.compare(leftItem, rightItem) < 0) {
                      array[cursor++] = leftItem;
                      leftCursor++;
                  } else {
                      array[cursor++] = rightItem;
                      rightCursor++;
                  }
              } else if (leftItem != null) {
                  array[cursor++] = leftItem;
                  leftCursor++;
              }  else if (rightItem != null) {
                  array[cursor++] = rightItem;
                  rightCursor++;
              }
        }
    }
}
