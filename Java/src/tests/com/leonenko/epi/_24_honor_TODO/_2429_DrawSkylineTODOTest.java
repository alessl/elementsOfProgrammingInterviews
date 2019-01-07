package com.leonenko.epi._24_honor_TODO;

import com.leonenko.epi._24_honor_TODO._2429_DrawSkyline_TODO.Building;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._24_honor_TODO._2429_DrawSkyline_TODO.drawSkyline;
import static org.assertj.core.api.Assertions.assertThat;

class _2429_DrawSkylineTODOTest {

    @Test
    void testDrawSkylines() {
        List<Building> buildings = List.of(new Building(1, 3, 5),
                new Building(0, 2, 2),
                new Building(2, 7, 1)
        );

        List<Building> skyline = drawSkyline(buildings);

       /*  ___
          |   |
          |   |
         _|_  |
        | | |_|_______
        | | | |       |
        0 1 2 3 4 5 6 7
       */

       assertThat(skyline).containsExactly(new Building(0, 1, 2),
               new Building(1, 4, 5),
               new Building(4, 7, 1));
    }

}