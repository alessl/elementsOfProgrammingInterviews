package com.leonenko.epi._7_list_TODO;

/**
 * Created by Alex on 5/12/2017.
 */
public final class ListNode {
    private int key;
    private ListNode next;
    private ListNode prev;

    public ListNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(int nextKey) {
        return this.next = new ListNode(nextKey);
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public ListNode getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        String next = this.next != null ? this.next.toString() : "$";
        return String.format("%s<->%s", key, next);
    }
}
