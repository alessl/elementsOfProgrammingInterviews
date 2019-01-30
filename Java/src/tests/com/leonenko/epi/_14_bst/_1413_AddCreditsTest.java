package com.leonenko.epi._14_bst;

import com.leonenko.epi._14_bst._1413_AddCredits.ClientCredits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _1413_AddCreditsTest {

    private ClientCredits clientCredits;

    @BeforeEach
    void setUp() {
        clientCredits = new ClientCredits();
    }

    @Test
    void testOneClient() {
        String clientId = "client1";
        int credit = 100;

        clientCredits.insert(clientId, credit);
        assertThat(clientCredits.lookup(clientId)).isEqualTo(credit);
        assertThat(clientCredits.max()).isEqualTo(clientId);

        clientCredits.addAll(10);
        assertThat(clientCredits.lookup(clientId)).isEqualTo(credit + 10);

        assertThat(clientCredits.remove(clientId)).isTrue();
        assertThat(clientCredits.lookup(clientId)).isNull();
    }

    @Test
    void testTwoClients() {
        String clientId1 = "client1";
        int credit1 = 100;

        String clientId2 = "client2";
        int credit2 = 200;

        clientCredits.insert(clientId1, credit1);
        assertThat(clientCredits.lookup(clientId1)).isEqualTo(credit1);

        clientCredits.insert(clientId2, credit2);
        assertThat(clientCredits.lookup(clientId2)).isEqualTo(credit2);

        assertThat(clientCredits.max()).isEqualTo(clientId2);

        clientCredits.addAll(20);
        assertThat(clientCredits.lookup(clientId1)).isEqualTo(credit1 + 20);
        assertThat(clientCredits.lookup(clientId2)).isEqualTo(credit2 + 20);

        assertThat(clientCredits.remove(clientId2)).isTrue();
        assertThat(clientCredits.lookup(clientId2)).isNull();

        assertThat(clientCredits.max()).isEqualTo(clientId1);
    }

    @Test
    void testNewClient() {
        String clientId1 = "client1";
        int credit1 = 100;

        clientCredits.insert(clientId1, credit1);
        assertThat(clientCredits.lookup(clientId1)).isEqualTo(credit1);

        clientCredits.addAll(20);

        assertThat(clientCredits.lookup(clientId1)).isEqualTo(credit1 + 20);

        String clientId2 = "client2";
        int credit2 = 200;

        clientCredits.insert(clientId2, credit2);

        assertThat(clientCredits.lookup(clientId2)).isEqualTo(credit2);
    }
}