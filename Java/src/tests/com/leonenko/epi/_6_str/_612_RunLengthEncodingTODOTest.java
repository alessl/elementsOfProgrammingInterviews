package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _612_RunLengthEncodingTODOTest {

    @Test
    void testEncode() {
        var encodedStr = _612_RunLengthEncoding_TODO.encode("");
        assertThat(encodedStr).isEqualTo("");
    }

    @Test
    void testDecode() {
        var decodedStr = _612_RunLengthEncoding_TODO.decode("");
        assertThat(decodedStr).isEqualTo("");
    }
}