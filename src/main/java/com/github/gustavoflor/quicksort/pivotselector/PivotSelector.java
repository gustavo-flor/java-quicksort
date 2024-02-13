package com.github.gustavoflor.quicksort.pivotselector;

public interface PivotSelector {
    int getPivotIndex(int[] arr, int begin, int end);
}
