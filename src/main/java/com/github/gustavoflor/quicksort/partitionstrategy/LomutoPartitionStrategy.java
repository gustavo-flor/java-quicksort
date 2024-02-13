package com.github.gustavoflor.quicksort.partitionstrategy;

import com.github.gustavoflor.quicksort.pivotselector.FirstValuePivotSelector;
import com.github.gustavoflor.quicksort.pivotselector.LastValuePivotSelector;
import com.github.gustavoflor.quicksort.pivotselector.PivotSelector;
import com.github.gustavoflor.quicksort.pivotselector.RandomPivotSelector;

public class LomutoPartitionStrategy implements PartitionStrategy {
    private final PivotSelector pivotSelector;

    private LomutoPartitionStrategy(PivotSelector pivotSelector) {
        this.pivotSelector = pivotSelector;
    }

    public static LomutoPartitionStrategy firstValuePivotSelector() {
        return new LomutoPartitionStrategy(new FirstValuePivotSelector());
    }

    public static LomutoPartitionStrategy lastValuePivotSelector() {
        return new LomutoPartitionStrategy(new LastValuePivotSelector());
    }

    public static LomutoPartitionStrategy randomPivotSelector() {
        return new LomutoPartitionStrategy(new RandomPivotSelector());
    }

    @Override
    public int partition(int[] arr, int begin, int end) {
        int pivotIndex = pivotSelector.getPivotIndex(arr, begin, end);

        swap(arr, begin, pivotIndex);
        int pivot = arr[begin];
        int lastSwapIndex = begin;

        for (int i = begin + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                lastSwapIndex++;
                swap(arr, lastSwapIndex, i);
            }
        }

        swap(arr, begin, lastSwapIndex);

        return lastSwapIndex;
    }
}
