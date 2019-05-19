package com.leonenko.epi._7_list;

public class _713_AddListIntegers {

    public static ListNode<Integer> sumReversed(ListNode<Integer> firstNum, ListNode<Integer> secondNum) {
        var sumHead = new ListNode<Integer>(null);
        var placeIter = sumHead;
        var carry = 0;

        while (firstNum != null || secondNum != null) {
            int sum = carry;

            if (firstNum != null) {
                sum += firstNum.getKey();
                firstNum = firstNum.getNext();
            }

            if (secondNum != null) {
                sum += secondNum.getKey();
                secondNum = secondNum.getNext();
            }

            placeIter.setNext(new ListNode<>(sum % 10));
            carry = sum / 10;

            placeIter = placeIter.getNext();
        }

        if (carry > 0) {
            placeIter.setNext(new ListNode<>(carry));
        }

        return sumHead.getNext();
    }

    public static ListNode<Integer>  sum(ListNode<Integer> firstNum, ListNode<Integer> secondNum) {
        var firstSize = size(firstNum);
        var firstReversed = _72_ReverseSubList.reverseSubList(firstNum, 0, firstSize - 1);

        var secondSize = size(secondNum);
        var secondReversed = _72_ReverseSubList.reverseSubList(secondNum, 0, secondSize - 1);

        var sumReversed = sumReversed(firstReversed, secondReversed);
        var sumReversedSize = size(sumReversed);

        return _72_ReverseSubList.reverseSubList(sumReversed, 0, sumReversedSize - 1);
    }

    private static int size(ListNode<Integer> head) {
        var size = 0;
        for (var ignored : head) {
            size++;
        }
        return size;
    }
}
