package com.leonenko.epi._13_sort;

public class _1310_FastSortingAlgorithmForList {

    static ListNode<Integer> insertionSort(ListNode<Integer> list) {
        ListNode<Integer> dummyHead = new ListNode<>(0, list);
        ListNode<Integer> it = list;

        while (it != null && it.next != null) {
            if (it.data > it.next.data) {
                var target = it.next;
                var pre = dummyHead;

                while (pre.next.data < target.data) {
                    pre = pre.next;
                }

                ListNode<Integer> temp = pre.next;
                pre.next = target;
                it.next = target.next;
                target.next = temp;
            } else {
                it = it.next;
            }
        }
        return dummyHead.next;
    }

    static ListNode<Integer> stableSortList(ListNode<Integer> list) {
        if (list == null || list.next == null) {
            return list;
        }

        ListNode<Integer> preSlow = null;
        ListNode<Integer> slow = list;
        ListNode<Integer> fast = list;

        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        preSlow.next = null;

        return mergeTwoSortedLists(stableSortList(list), stableSortList(slow));
    }

    private static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> stableSortList,
                                                         ListNode<Integer> stableSortList1) {
        return null;
    }

    private static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T i, ListNode<T> list) {
            this.next = list;
        }
    }
}
