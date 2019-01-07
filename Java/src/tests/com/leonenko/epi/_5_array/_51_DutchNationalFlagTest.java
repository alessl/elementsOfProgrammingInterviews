package com.leonenko.epi._5_array;

import com.leonenko.epi._5_array._51_DutchNationalFlag.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;

class _51_DutchNationalFlagTest {

    private final ArrayList<Color> colors = new ArrayList<>(
            List.of(Color.BLUE,
                    Color.WHITE,
                    Color.BLUE,
                    Color.RED,
                    Color.WHITE,
                    Color.BLUE,
                    Color.BLUE,
                    Color.RED));

    @Test
    void testPartition1() {
        assertPartition(0, colors, _51_DutchNationalFlag::partition1);
        assertPartition(1, colors, _51_DutchNationalFlag::partition1);
    }

    @Test
    void testPartition2() {
        assertPartition(0, colors, _51_DutchNationalFlag::partition2);
        assertPartition(1, colors, _51_DutchNationalFlag::partition2);
    }

    private void assertPartition(int pivotIndex,
            List<Color> colors, BiConsumer<Integer, List<Color>> partitioner) {

        var pivot = colors.get(pivotIndex);

        System.out.println("Before partitioning: " + colors);

        partitioner.accept(pivotIndex, colors);

        System.out.println("After partitioning: " + colors + " partitioned by " + pivot);

        assertThat(colors.subList(0, colors.indexOf(pivot))).doesNotContain(pivot);

        assertThat(colors.subList(colors.lastIndexOf(pivot) + 1, colors.size()))
                .doesNotContain(pivot);

        assertThat(colors.subList(colors.indexOf(pivot), colors.lastIndexOf(pivot) + 1))
                .containsOnly(pivot);
    }
}