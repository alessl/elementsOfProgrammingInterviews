package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.TestUtils.assertListContainsKeys;
import static com.leonenko.epi._7_list_TODO._73_DetectCycle.getCycle;
import static org.assertj.core.api.Assertions.assertThat;

class _73_DetectCycleTest {

    private ListNode<Integer> headNode;
    private ListNode<Integer> cycleStartNode;
    private ListNode<Integer> tailNode;

    @BeforeEach
    void setUp() {
        createList();

        assertListContainsKeys(headNode, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testCycleExists() {
        tailNode.setNext(cycleStartNode);

        var cycle = getCycle(headNode);

        assertThat(cycle)
                .extracting(ListNode::getKey)
                .containsExactly(3, 6);
    }

    @Test
    void testCycleDoesNotExist() {
        assertThat(getCycle(headNode)).isEmpty();
    }

    private void createList() {
        var node1 = new ListNode<>(1);
        var node2 = new ListNode<>(2);
        var node3 = new ListNode<>(3);
        var node4 = new ListNode<>(4);
        var node5 = new ListNode<>(5);
        var node6 = new ListNode<>(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        headNode = node1;
        cycleStartNode = node3;
        tailNode = node6;
    }
}