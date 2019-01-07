package com.leonenko.epi.common.linkedlist;


import lombok.Data;

@Data
public class SingleLinkListNode<T> {

    private final T key;

    private DoubleLinkListNode<T> next;
}
