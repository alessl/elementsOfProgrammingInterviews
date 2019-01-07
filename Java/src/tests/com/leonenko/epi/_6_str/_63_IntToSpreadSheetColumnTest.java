package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.leonenko.epi._6_str._63_IntToSpreadSheetColumn.colToInt;
import static com.leonenko.epi._6_str._63_IntToSpreadSheetColumn.intToCol;
import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class _63_IntToSpreadSheetColumnTest {

    private static final Map<String, Integer> COLUMN_TO_NUMBER = Map.ofEntries(
            entry("A", 1),
            entry("B", 2),
            entry("C", 3),
            entry("D", 4),
            entry("AA", 27),
            entry("AB", 28),
            entry("AC", 29),
            entry("AZ", 52),
            entry("BA", 53),
            entry("BZ", 78),
            entry("ZZ", 702),
            entry("ZZZ", 18278));

    @Test
    void testIntToCol() {
        assertAll(createAssertions(e -> assertThat(intToCol(e.getValue())).isEqualTo(e.getKey())));
    }

    @Test
    void testColToInt() {
        assertAll(createAssertions(e -> assertThat(colToInt(e.getKey())).isEqualTo(e.getValue())));
    }

    private List<Executable> createAssertions(Consumer<Entry<String, Integer>> assertion) {
        return COLUMN_TO_NUMBER.entrySet().stream()
                .map(e -> (Executable) () -> assertion.accept(e))
                .collect(Collectors.toList());
    }
}