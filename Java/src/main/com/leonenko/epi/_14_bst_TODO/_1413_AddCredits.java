package com.leonenko.epi._14_bst_TODO;

import java.util.*;

public class _1413_AddCredits {

    static class ClientCredits {
        private int creditOffset;
        private Map<String, Integer> clientToCredit = new HashMap<>();
        private NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();

        public void insert(String clientId, int creditAmount) {
            remove(clientId);

            clientToCredit.put(clientId, creditAmount - creditOffset);

            Set<String> clients =
                    creditToClients.computeIfAbsent(creditAmount - creditOffset, k -> new HashSet<>());

            clients.add(clientId);
        }

        public boolean remove(String clientId) {
            Integer credit = clientToCredit.get(clientId);

            if (credit != null) {
                creditToClients.get(credit).remove(clientId);

                if (creditToClients.get(credit).isEmpty()) {
                    creditToClients.remove(credit);
                }

                clientToCredit.remove(clientId);

                return true;
            }

            return false;
        }

        public Integer lookup(String clientId) {
            Integer credit = clientToCredit.get(clientId);
            return credit == null ? null : credit + creditOffset;
        }

        public String max() {
            return creditToClients.isEmpty()
                    ? null : creditToClients.lastEntry().getValue().iterator().next();
        }

        public void addAll(int credit) {
            creditOffset += credit;
        }
    }

}
