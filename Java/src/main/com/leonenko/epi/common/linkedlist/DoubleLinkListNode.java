package com.leonenko.epi.common.linkedlist;

import lombok.Data;

@Data
public class DoubleLinkListNode<T> {
    
    private final T key;
    
    private DoubleLinkListNode<T> next;
    private DoubleLinkListNode<T> prev;
}
