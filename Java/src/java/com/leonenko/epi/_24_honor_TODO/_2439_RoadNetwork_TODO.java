package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _2439_RoadNetwork_TODO {

    public static void main(String[] args) {

    }

    static HighwaySection findBestProposals(HighwaySection[] highwayH,
                                            HighwaySection[] highwayP,
                                            int n) {
        var graph = new double[n][n];

        IntStream.range(0, n).forEach(
                i -> Arrays.setAll(graph[i], j -> i != j ? Double.MAX_VALUE : 0));

        for (HighwaySection s : highwayH) {
            graph[s.x][s.y] = s.distance;
        }

        floydWarshall(graph);

        var bestDistanceSaving = Double.MIN_VALUE;

        var bestProposal = new HighwaySection(-1, -1, 0.0);
        for (int i = 0; i < highwayP.length; i++) {
            var proposalSaving = 0.0;

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    var saving = graph[a][b] - (graph[a][highwayP[i].x]  + highwayP[i].distance + graph[highwayP[i].y][b]);
                    proposalSaving += saving > 0.0 ? saving : 0.0;
                }
            }
            if (proposalSaving > bestDistanceSaving) {
                bestDistanceSaving = proposalSaving;
                bestProposal = highwayP[i];
            }
        }

        return bestProposal;
    }

    private static void floydWarshall(double[][] graph) {
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][k] != Double.MAX_VALUE
                            && graph[k][j] != Double.MAX_VALUE
                            && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    private static class HighwaySection {
        private int x;
        private int y;
        private double distance;

        public HighwaySection(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
