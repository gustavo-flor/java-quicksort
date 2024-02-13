package com.github.gustavoflor.quicksort.pivotselector;

import java.util.Random;

public class RandomPivotSelector implements PivotSelector {
    private static final Random RANDOM = new Random();

    @Override
    public int getPivotIndex(int[] arr, int begin, int end) {
        return RANDOM.nextInt(begin, end + 1);
    }
}
