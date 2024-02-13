package com.github.gustavoflor.quicksort;

import com.github.gustavoflor.quicksort.pivotselector.FirstValuePivotSelector;
import com.github.gustavoflor.quicksort.pivotselector.LastValuePivotSelector;
import com.github.gustavoflor.quicksort.pivotselector.RandomPivotSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuicksortStrategyTest {
    @ParameterizedTest
    @MethodSource("getPartitionStrategies")
    @DisplayName("""
        GIVEN an array
        WHEN call quicksort
        THEN should be ordered
        """)
    void givenAnArrayWhenCallQuicksortThenShouldBeOrdered(final QuicksortStrategy quicksortStrategy) {
        int[] sorted = {0, 2, 3, 4, 7};
        int[] unsorted = {3, 7, 4, 2, 0};
        int[] array = {3, 7, 4, 2, 0};

        quicksortStrategy.quicksort(array);

        assertThat(array).isEqualTo(sorted);
        assertThat(array).isNotEqualTo(unsorted);
    }

    private static Stream<QuicksortStrategy> getPartitionStrategies() {
        return Stream.of(
            new LomutoQuicksortStrategy(new FirstValuePivotSelector()),
            new LomutoQuicksortStrategy(new LastValuePivotSelector()),
            new LomutoQuicksortStrategy(new RandomPivotSelector()),
            new HoareQuicksortStrategy(new FirstValuePivotSelector()),
            new HoareQuicksortStrategy(new LastValuePivotSelector()),
            new HoareQuicksortStrategy(new RandomPivotSelector())
        );
    }
}
