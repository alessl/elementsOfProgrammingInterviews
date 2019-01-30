package com.leonenko.epi._14_bst;

import com.leonenko.epi._14_bst._148_MostVisitedPages.ConstantAddAndLinearKGetImpl;
import com.leonenko.epi._14_bst._148_MostVisitedPages.TreeSetAndHashMapImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class _148_MostVisitedPagesTest {

    @Test
    void testMostVisitedIds1() {
        var num = 3;

        doTest(() -> TreeSetAndHashMapImpl.getMostFrequentIds(num), TreeSetAndHashMapImpl::addId);
    }

    @Test
    void testMostVisitedIds2() {
        var num = 3;

        doTest(() -> ConstantAddAndLinearKGetImpl.getMostFrequentIds(num), ConstantAddAndLinearKGetImpl::addId);
    }

    private void doTest(Supplier<List<String>> mostFrequentSupplier, Function<String, Integer> addIdConsumer) {
        assertThat(mostFrequentSupplier.get()).isEmpty();

        assertThat(addIdConsumer.apply("1")).isEqualTo(1);
        assertThat(mostFrequentSupplier.get()).containsExactly("1");

        assertThat(addIdConsumer.apply("2")).isEqualTo(1);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2");

        assertThat(addIdConsumer.apply("1")).isEqualTo(2);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2");

        assertThat(addIdConsumer.apply("1")).isEqualTo(3);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2");

        assertThat(addIdConsumer.apply("2")).isEqualTo(2);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2");

        assertThat(addIdConsumer.apply("3")).isEqualTo(1);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2", "3");

        assertThat(addIdConsumer.apply("4")).isEqualTo(1);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2", "3");

        assertThat(addIdConsumer.apply("3")).isEqualTo(2);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "2", "3");

        assertThat(addIdConsumer.apply("3")).isEqualTo(3);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "3", "2");

        assertThat(addIdConsumer.apply("1")).isEqualTo(4);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "3", "2");

        assertThat(addIdConsumer.apply("3")).isEqualTo(4);
        assertThat(mostFrequentSupplier.get()).containsExactly("1", "3", "2");

        assertThat(addIdConsumer.apply("3")).isEqualTo(5);
        assertThat(mostFrequentSupplier.get()).containsExactly("3", "1", "2");
    }
}