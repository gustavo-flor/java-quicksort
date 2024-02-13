package com.github.gustavoflor.quicksort.pivotselector;

public class LastValuePivotSelector implements PivotSelector {
    @Override
    public int getPivotIndex(int[] arr, int begin, int end) {
        return end;
    }
}
