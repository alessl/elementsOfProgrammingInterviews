package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class _62_BaseConversionTest {

    private static final String VALUE_DECIMAL = "27";
    private static final String VALUE_BINARY = "11011";
    private static final String VALUE_OCTAL = "33";
    private static final String VALUE_HEXADECIMAL = "1B";

    private static final Set<Integer> BASES = Set.of(2, 8, 10, 16);

    @Test
    void convertFrom10() {
        assertConvert(10);
    }

    @Test
    void convertFrom2() {
        assertConvert(2);
    }

    @Test
    void convertFrom8() {
        assertConvert(8);
    }

    @Test
    void convertFrom16() {
        assertConvert(16);
    }

    private static void assertConvert(int fromBase) {
        BASES.stream()
             .filter(b -> b != fromBase)
             .forEach(b -> assertConvert(fromBase, b));
    }

    private static void assertConvert(int fromBase, int toBase) {
        String convertedValue = null;

        switch (fromBase) {
            case 2:
                convertedValue = _62_BaseConversion.convert(VALUE_BINARY, fromBase, toBase);
                break;
            case 8:
                convertedValue = _62_BaseConversion.convert(VALUE_OCTAL, fromBase, toBase);
                break;
            case 10:
                convertedValue = _62_BaseConversion.convert(VALUE_DECIMAL, fromBase, toBase);
                break;
            case 16:
                convertedValue = _62_BaseConversion.convert(VALUE_HEXADECIMAL, fromBase, toBase);
                break;
            default:
                fail("Unknown fromBase: " + fromBase);
        }

        assertThat(convertedValue).isNotNull();

        switch (toBase) {
            case 2:
                assertThat(convertedValue).isEqualTo(VALUE_BINARY);
                break;
            case 8:
                assertThat(convertedValue).isEqualTo(VALUE_OCTAL);
                break;
            case 10:
                assertThat(convertedValue).isEqualTo(VALUE_DECIMAL);
                break;
            case 16:
                assertThat(convertedValue).isEqualTo(VALUE_HEXADECIMAL);
                break;
            default:
                fail("Unknown toBase: " + fromBase);
        }
    }
}