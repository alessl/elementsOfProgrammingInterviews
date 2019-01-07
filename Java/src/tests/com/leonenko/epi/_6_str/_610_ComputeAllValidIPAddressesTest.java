package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._610_ComputeAllValidIPAddresses.getAllValidIpAddresses;
import static org.assertj.core.api.Assertions.assertThat;

class _610_ComputeAllValidIPAddressesTest {

    @Test
    void testGetAllValidIpAddresses() {
        assertThat(getAllValidIpAddresses("19216811")).containsExactly("1.92.168.11",
                "19.2.168.11", "19.21.68.11", "19.216.8.11", "19.216.81.1", "192.1.68.11",
                "192.16.8.11", "192.16.81.1", "192.168.1.1");
    }
}