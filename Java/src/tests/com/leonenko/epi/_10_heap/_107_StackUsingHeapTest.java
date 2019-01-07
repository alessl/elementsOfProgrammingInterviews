package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _107_StackUsingHeapTest {

    @Test
    void pushAndPop() {
        _107_StackUsingHeap stack = new _107_StackUsingHeap();

        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(-1);
    }
}