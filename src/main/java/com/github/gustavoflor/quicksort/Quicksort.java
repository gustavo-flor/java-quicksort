package com.github.gustavoflor.quicksort;

import com.github.gustavoflor.quicksort.partitionstrategy.PartitionStrategy;

public class Quicksort {
    private final PartitionStrategy partitionStrategy;

    public Quicksort(PartitionStrategy partitionStrategy) {
        this.partitionStrategy = partitionStrategy;
    }

    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partitionStrategy.partition(arr, begin, end);
            quicksort(arr, begin, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, end);
        }
    }
}
