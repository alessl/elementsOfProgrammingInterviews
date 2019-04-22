package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/13/2017.
 */
public class _123_LRU {

    static final class LinkedHashMapLruCache implements BookCache {

        private final LinkedHashMap<String, Integer> lru;

        public LinkedHashMapLruCache(int maxCapacity) {
            this.lru = new LinkedHashMap<>(maxCapacity, 1, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                    return size() > maxCapacity;
                }
            };
        }

        @Override
        public OptionalInt lookupBookPrice(String bookCode) {
            return lru.containsKey(bookCode) ? OptionalInt.of(lru.get(bookCode)) : OptionalInt.empty();
        }

        @Override
        public void insertBookPrice(String bookCode, int bookPrice) {
            lru.putIfAbsent(bookCode, bookPrice);
        }
    }

    static final class LinkedListLruCache implements BookCache {
        private final int maxSize;

        private final Map<String, ListNode<String, Integer>> bookCodeToListNodeMap = new HashMap<>();
        private ListNode<String, Integer> headNode;
        private ListNode<String, Integer> tailNode;

        public LinkedListLruCache(int maxSize) {
            this.maxSize = maxSize;
        }

        public OptionalInt lookupBookPrice(String bookCode) {
            var node = bookCodeToListNodeMap.get(bookCode);
            if (node == null) {
                return OptionalInt.empty();
            }

            if (node != headNode) {
                removeNode(node);
                setHead(node);
            }

            return OptionalInt.of(node.value);
        }

        private void removeNode(ListNode<String, Integer> node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == tailNode) {
                tailNode = node.prev;
            }
            if (node == headNode) {
                headNode = node.next;
            }
        }

        private void setHead(ListNode<String, Integer> node) {
            if (headNode == null) {
                headNode = node;
                tailNode = node;
            } else {
                headNode.prev = node;
                node.next = headNode;
                headNode = node;
            }
        }

        public void insertBookPrice(String bookCode, int bookPrice) {
            var node = bookCodeToListNodeMap.get(bookCode);

            if (node == null && bookCodeToListNodeMap.size() == maxSize) {
                bookCodeToListNodeMap.remove(tailNode.key);
                removeNode(tailNode);
            }

            if (node != null) {
                node.value = bookPrice;
                removeNode(node);
            } else {
                node = new ListNode<>(bookCode, bookPrice);
                bookCodeToListNodeMap.put(bookCode, node);
            }

            setHead(node);
        }

        private static final class ListNode<K, T> {
            private ListNode<K, T> next;
            private ListNode<K, T> prev;
            private final K key;
            private T value;

            ListNode(K key, T value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public interface BookCache {
        OptionalInt lookupBookPrice(String bookCode);

        void insertBookPrice(String bookCode, int bookPrice);
    }
}
