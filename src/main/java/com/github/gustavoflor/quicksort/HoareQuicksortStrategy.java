package com.github.gustavoflor.quicksort;

import com.github.gustavoflor.quicksort.pivotselector.PivotSelector;

public class HoareQuicksortStrategy implements QuicksortStrategy {
    private final PivotSelector pivotSelector;

    public HoareQuicksortStrategy(PivotSelector pivotSelector) {
        this.pivotSelector = pivotSelector;
    }

    @Override
    public void quicksort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(arr, begin, end);
            quicksort(arr, begin, pivotIndex - 1);
            quicksort(arr, pivotIndex, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivotIndex = pivotSelector.getPivotIndex(arr, begin, end);
        swap(arr, end, pivotIndex);
        int pivot = arr[end];
        int i = begin;
        int j = end;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
            }
        }
        return i;
    }
}
