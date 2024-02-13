package com.github.gustavoflor.quicksort;

import com.github.gustavoflor.quicksort.partitionstrategy.LomutoPartitionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuicksortTest {
    private static final LomutoPartitionStrategy FIRST_VALUE_LOMUTO_PARTITION_STRATEGY = LomutoPartitionStrategy.firstValuePivotSelector();
    private static final LomutoPartitionStrategy LAST_VALUE_LOMUTO_PARTITION_STRATEGY = LomutoPartitionStrategy.lastValuePivotSelector();
    private static final LomutoPartitionStrategy RANDOM_LOMUTO_PARTITION_STRATEGY = LomutoPartitionStrategy.randomPivotSelector();

    @Test
    @DisplayName("""
        GIVEN an array
        WHEN call quicksort
        THEN should be ordered
        """)
    void givenAnArrayWhenCallQuicksortThenShouldBeOrdered() {
        int[] sorted = {0, 2, 3, 4, 7};
        int[] unsorted = {3, 7, 4, 2, 0};
        int[] array = {3, 7, 4, 2, 0};
        final var quicksort = new Quicksort(RANDOM_LOMUTO_PARTITION_STRATEGY);

        quicksort.quicksort(array);

        assertThat(array).isEqualTo(sorted);
        assertThat(array).isNotEqualTo(unsorted);
    }

}
