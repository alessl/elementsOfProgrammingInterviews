package com.leonenko.epi._12_hash_TODO;

import com.leonenko.epi._12_hash_TODO._123_LRU.BookCache;
import com.leonenko.epi._12_hash_TODO._123_LRU.LinkedHashMapLruCache;
import com.leonenko.epi._12_hash_TODO._123_LRU.LinkedListLruCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _123_LRUTest {

    private static final String BOOK_1 = "book1";
    private static final String BOOK_2 = "book2";
    private static final String BOOK_3 = "book3";
    private static final int BOOK_1_PRICE = 10;
    private static final int BOOK_2_PRICE = 20;
    private static final int BOOK_3_PRICE = 30;
    private static final String NEW_BOOK = "newBook";
    private static final int NEW_BOOK_PRICE = 40;

    private LinkedHashMapLruCache linkedHashMapLru;
    private LinkedListLruCache linkedListLru;

    @BeforeEach
    void setUp() {
        linkedHashMapLru = new LinkedHashMapLruCache(3);

        linkedHashMapLru.insertBookPrice(BOOK_1, BOOK_1_PRICE);
        linkedHashMapLru.insertBookPrice(BOOK_2, BOOK_2_PRICE);
        linkedHashMapLru.insertBookPrice(BOOK_3, BOOK_3_PRICE);

        linkedListLru = new LinkedListLruCache(3);

        linkedListLru.insertBookPrice(BOOK_1, BOOK_1_PRICE);
        linkedListLru.insertBookPrice(BOOK_2, BOOK_2_PRICE);
        linkedListLru.insertBookPrice(BOOK_3, BOOK_3_PRICE);
    }

    @Test
    void testLookup() {
        doTestLookup(linkedHashMapLru);
        doTestLookup(linkedListLru);
    }

    private static void doTestLookup(BookCache bookCache) {
        assertThat(bookCache.lookupBookPrice(BOOK_1)).hasValue(BOOK_1_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_2)).hasValue(BOOK_2_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_3)).hasValue(BOOK_3_PRICE);
    }

    @Test
    void testOldestEntryRemovedLinkedHashMapLru() {
        doTestOldestEntryRemoved(linkedHashMapLru);
        doTestOldestEntryRemoved(linkedListLru);
    }

    private static void doTestOldestEntryRemoved(BookCache bookCache) {
        var newBook2 = "newBook2";
        var newBook2Price = 50;

        bookCache.insertBookPrice(NEW_BOOK, NEW_BOOK_PRICE);
        bookCache.insertBookPrice(newBook2, newBook2Price);

        // new books
        assertThat(bookCache.lookupBookPrice(NEW_BOOK)).hasValue(NEW_BOOK_PRICE);
        assertThat(bookCache.lookupBookPrice(newBook2)).hasValue(newBook2Price);

        // removed books
        assertThat(bookCache.lookupBookPrice(BOOK_1)).isEmpty();
        assertThat(bookCache.lookupBookPrice(BOOK_2)).isEmpty();
    }

    @Test
    void testEntryRefreshedOnAccessLinkedHashMapLru() {
        doTestEntryRefreshedOnAccess(linkedHashMapLru);
        doTestEntryRefreshedOnAccess(linkedListLru);
    }

    private static void doTestEntryRefreshedOnAccess(BookCache bookCache) {
        assertThat(bookCache.lookupBookPrice(BOOK_1)).hasValue(BOOK_1_PRICE);

        bookCache.insertBookPrice(NEW_BOOK, NEW_BOOK_PRICE);

        assertThat(bookCache.lookupBookPrice(NEW_BOOK)).hasValue(NEW_BOOK_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_1)).hasValue(BOOK_1_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_2)).isEmpty();
    }

    @Test
    void testInsertDuplicateEntry() {
        doTestEntryRefreshedOnDuplicateInsert(linkedHashMapLru);
        doTestEntryRefreshedOnDuplicateInsert(linkedListLru);
    }

    private static void doTestEntryRefreshedOnDuplicateInsert(BookCache bookCache) {
        bookCache.insertBookPrice(BOOK_1, BOOK_1_PRICE);
        bookCache.insertBookPrice(BOOK_2, BOOK_2_PRICE);

        bookCache.insertBookPrice(NEW_BOOK, NEW_BOOK_PRICE);

        assertThat(bookCache.lookupBookPrice(NEW_BOOK)).hasValue(NEW_BOOK_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_1)).hasValue(BOOK_1_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_2)).hasValue(BOOK_2_PRICE);
        assertThat(bookCache.lookupBookPrice(BOOK_3)).isEmpty();
    }
}