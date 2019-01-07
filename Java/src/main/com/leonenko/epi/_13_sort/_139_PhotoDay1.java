package com.leonenko.epi._13_sort;

import java.util.List;
import java.util.stream.Collectors;

public class _139_PhotoDay1 {

    static class Team {
        private List<Player> players;

        public Team(List<Integer> heights) {
            this.players = heights.stream()
                                  .map(Player::new)
                                  .sorted()
                                  .collect(Collectors.toList());
        }

        int size() {
            return players.size();
        }

        static boolean isValidPlacementExists(Team firstTeam, Team secondTeam) {
            for (int i = 0; i < Math.min(firstTeam.size(), secondTeam.size()); i++) {
                if (firstTeam.players.get(i).compareTo(secondTeam.players.get(i)) >= 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Player implements Comparable<Player> {
        private int height;

        public Player(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Player other) {
            return Integer.compare(height, other.height);
        }
    }
}
