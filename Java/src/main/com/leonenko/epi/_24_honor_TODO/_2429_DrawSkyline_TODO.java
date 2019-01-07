package com.leonenko.epi._24_honor_TODO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.setAll;

public class _2429_DrawSkyline_TODO {

    static List<Building> drawSkyline(List<Building> buildings) {
        int[] minMax = buildings.stream()
                                .reduce(new int[2],
                                        (a, b) -> {
                                            a[0] = Math.min(a[0], b.left);
                                            a[1] = Math.max(a[1], b.right);
                                            return a;
                                        },
                                        (l, r) -> {
                                            int[] both = new int[l.length + r.length];
                                            setAll(both, i -> i < l.length ? l[i] : r[i - r.length]);
                                            return both;
                                        }
                                );

        int minLeft = minMax[0];
        int maxRight = minMax[1];

        List<Integer> heights = Stream.generate(() -> 0)
                                      .limit(maxRight - minLeft + 1)
                                      .collect(Collectors.toList());

        for (Building building : buildings) {
            for (int i = building.left; i <= building.right; i++) {
                heights.set(i - minLeft, Math.max(heights.get(i - minLeft), building.height));
            }
        }

        List<Building> skyline = new ArrayList<>();
        int left = 0;

        for (int i = 1; i < heights.size(); i++) {
            if (heights.get(i) != (int) heights.get(i - 1)) {
                Building building = new Building(minLeft + left,
                        minLeft + i,
                        heights.get(i - 1));
                skyline.add(building);
                left = i;
            }
        }

        skyline.add(new Building(left + minLeft, maxRight, heights.get(heights.size() - 1)));

        return skyline;
    }

    static final class Building {
        private int left;
        private int right;
        private int height;

        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                    .append(left)
                    .append(right)
                    .append(height)
                    .build();
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public boolean equals(Object o) {
            return EqualsBuilder.reflectionEquals(this, o);
        }
    }

}
