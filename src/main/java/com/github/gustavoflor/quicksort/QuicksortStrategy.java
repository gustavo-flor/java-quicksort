package com.github.gustavoflor.quicksort;

public interface QuicksortStrategy {

    default void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    void quicksort(int[] arr, int begin, int end);

    default void swap(int[] arr, int index, int otherIndex) {
        int temp = arr[index];
        arr[index] = arr[otherIndex];
        arr[otherIndex] = temp;
    }
}
