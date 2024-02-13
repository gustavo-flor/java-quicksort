package com.github.gustavoflor.quicksort;

import com.github.gustavoflor.quicksort.pivotselector.PivotSelector;

public class LomutoQuicksortStrategy implements QuicksortStrategy {
    private final PivotSelector pivotSelector;

    public LomutoQuicksortStrategy(PivotSelector pivotSelector) {
        this.pivotSelector = pivotSelector;
    }

    @Override
    public void quicksort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(arr, begin, end);
            quicksort(arr, begin, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivotIndex = pivotSelector.getPivotIndex(arr, begin, end);
        swap(arr, end, pivotIndex);
        int pivot = arr[end];
        int i = begin;
        for (int x = begin; x < end; x++) {
            if (arr[x] <= pivot) {
                swap(arr, i, x);
                i++;
            }
        }
        swap(arr, end, i);
        return i;
    }
}
