package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._67_ComputeAllMnemonicsForPhoneNumber.enumerateAllMnemonics;
import static org.assertj.core.api.Assertions.assertThat;

class _67_ComputeAllMnemonicsForPhoneNumber_Test {

    @Test
    void testEnumerateAllMnemonics() {
        var mnemonics = enumerateAllMnemonics("1250");
        assertThat(mnemonics).containsExactly(
                "1AJ+", "1AK+", "1AL+", "1BJ+", "1BK+", "1BL+", "1CJ+", "1CK+", "1CL+");
    }

}