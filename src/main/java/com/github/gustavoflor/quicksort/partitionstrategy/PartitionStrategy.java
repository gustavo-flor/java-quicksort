package com.github.gustavoflor.quicksort.partitionstrategy;

public interface PartitionStrategy {
    int partition(int[] arr, int begin, int end);

    default void swap(int[] arr, int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException();
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
