package com.leonenko.epi._14_bst;

import java.util.*;

public class _148_MostVisitedPages {

    static class ConstantAddAndLinearKGetImpl {
        private static Map<String, ListNode> idToNode = new HashMap<>();
        private static ListNode mostFrequentNode;
        private static ListNode leastFrequentNode;

        private static final class ListNode {
            private String id;
            private int visitCount;
            private ListNode prev;
            private ListNode next;

            public ListNode(String id, int visitCount) {
                this.id = id;
                this.visitCount = visitCount;
            }
        }

        static List<String> getMostFrequentIds(int num) { // O(num)
            var mostFrequentIds = new ArrayList<String>();

            ListNode curr = mostFrequentNode;
            for (int i = 0; i < num && curr != null; i++) {
                mostFrequentIds.add(curr.id);

                curr = curr.next;
            }

            return mostFrequentIds;
        }

        static int addId(String id) { // O(1)
            ListNode listNode = idToNode.computeIfAbsent(id, k -> new ListNode(id, 0));

            listNode.visitCount++;

            if (mostFrequentNode == null) {
                mostFrequentNode = listNode;
                leastFrequentNode = listNode;
            } else if (listNode.visitCount == 1) {
                leastFrequentNode.next = listNode;
                listNode.prev = leastFrequentNode;
                leastFrequentNode = listNode;
            } else if (listNode != mostFrequentNode && listNode.visitCount > listNode.prev.visitCount) {
                listNode.prev.next = listNode.next;
                listNode.next = listNode.prev;
                listNode.prev = listNode.prev.prev;

                if (listNode.prev == null) {
                    mostFrequentNode = listNode;
                } else {
                    listNode.prev.next = listNode;
                }
            }

            return listNode.visitCount;
        }
    }

    static class OrderStatisticImpl {

    }

    static class BstPredecessorAndHashMapImpl {

    }

    static class TreeSetAndHashMapImpl {

        private static Map<String, TreeEntry> idToEntry = new HashMap<>();
        private static NavigableSet<TreeEntry> tree = new TreeSet<>();

        static List<String> getMostFrequentIds(int num) {
            var mostFrequentIds = new ArrayList<String>();
            var polledEntries = new ArrayList<TreeEntry>();
            var actualNum = Math.min(num, tree.size());

            for (int i = 0; i < actualNum; i++) {
                var entry = tree.pollLast(); // log(n)

                polledEntries.add(entry); // o(1)
                mostFrequentIds.add(entry.id); // o(1)
            }

            tree.addAll(polledEntries); // num * log(n)

            return mostFrequentIds;
        }

        static int addId(String id) {
            var entry = idToEntry.computeIfAbsent(id, k -> new TreeEntry(id, 0));

            if (entry.visitCount > 0) {
                tree.remove(entry);
            }

            entry.visitCount++;

            tree.add(entry);

            return entry.visitCount;
        }

        private static class TreeEntry implements Comparable<TreeEntry> {
            private String id;
            private int visitCount;

            public TreeEntry(String id, int visitCount) {
                this.id = id;
                this.visitCount = visitCount;
            }

            @Override
            public int compareTo(TreeEntry o) {
                var comparedByVisitCount = Integer.compare(visitCount, o.visitCount);

                if (comparedByVisitCount != 0) {
                    return comparedByVisitCount;
                }

                return o.id.compareTo(id);
            }
        }
    }
}
