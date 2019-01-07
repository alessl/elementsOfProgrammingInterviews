package com.leonenko.epi._24_honor_TODO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _2420_ShortestUniquePrefix_TODO {

    public static void main(String[] args) {

    }

    static String findShortestPrefix(String string, Set<String> dictionaryStrings) {
        return new Trie(dictionaryStrings).getShortestUniquePrefix(string);
    }

    private static final class Trie {

        private TrieNode root = new TrieNode();

        public Trie(Collection<String> strings) {
            strings.forEach(this::insert);
        }

        public boolean insert(String string) {
            var node = root;

            for (int i = 0; i < string.length(); i++) {
                node = node.leaves.computeIfAbsent(string.charAt(i), k -> new TrieNode());
            }

            if (node.isString) {
                return false;
            } else {
                node.isString = true;
                return true;
            }
        }

        public String getShortestUniquePrefix(String string) {
            var node = root;
            var prefix = new StringBuilder();

            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                prefix.append(c);

                if (!node.leaves.containsKey(c)) {
                    return prefix.toString();
                }

                node = node.leaves.get(c);

            }

            return "";
        }
    }

    private static final class TrieNode {
        private boolean isString;
        private Map<Character, TrieNode> leaves = new HashMap<>();
    }
}
