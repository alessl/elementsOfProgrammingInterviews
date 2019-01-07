package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._611_WriteStringSinusoidally.getStringSinusoidally;
import static org.assertj.core.api.Assertions.assertThat;

class _611_WriteStringSinusoidallyTest {

    @Test
    void testGetStringSinusoidally() {
        String strSinusoidally = getStringSinusoidally("Hello World!");

        System.out.println(strSinusoidally);

        assertThat(strSinusoidally).isEqualTo(" e   _   l  \nH l o W r d \n   l   o   !\n");
    }
}