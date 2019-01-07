package com.leonenko.epi._8_stackqueue;

import java.util.LinkedList;
import java.util.List;

public class _85_SearchPostingList_TODO {

    static void setJumpOrder(PostingListNode firstNode) {
        setJumpOrder(firstNode, 0);
    }

    private static int setJumpOrder(PostingListNode firstNode, int order) {
        if (firstNode != null && firstNode.order == -1) {
            firstNode.order = order;

            order++;

            order = setJumpOrder(firstNode.jump, order);
            order = setJumpOrder(firstNode.jump, order);
        }

        return order;
    }

    static void setJumOrder(PostingListNode firstNode) {
        var stack = new LinkedList<>(List.of(firstNode));
        var order = 0;

        while (!stack.isEmpty()) {
            var currNode = stack.pop();

            if (currNode != null && currNode.order == -1) {
                currNode.order = order++;
                stack.push(currNode.next);
                stack.push(currNode.jump);
            }
        }
    }

    class PostingListNode {
        private int order;
        private PostingListNode next;
        private PostingListNode jump;
    }
}
