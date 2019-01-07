package com.leonenko.epi._13_sort;

import com.leonenko.epi._13_sort._133_RemoveFirstNameDuplicates.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static com.leonenko.epi._13_sort._133_RemoveFirstNameDuplicates.removeFirstNameDuplicates;
import static org.assertj.core.api.Assertions.assertThat;

class _133_RemoveFirstNameDuplicatesTest {

    @Test
    void testRemoveFirstNameDuplicates() {
        List<Name> names = new ArrayList<>(List.of(
                new Name("firstName1", "lastName"),
                new Name("firstName2", "lastName"),
                new Name("firstName1", "lastName"),
                new Name("firstName3", "lastName")
        ));

        assertDuplicatesRemoved(names);
    }

    @Test
    void testRemoveFirstNameDuplicatesNoDuplicates() {
        List<Name> names = new ArrayList<>(List.of(
                new Name("firstName1", "lastName"),
                new Name("firstName2", "lastName"),
                new Name("firstName3", "lastName")
        ));

        assertDuplicatesRemoved(names);
    }

    @Test
    void testRemoveFirstNameDuplicatesAllDuplicates() {
        List<Name> names = new ArrayList<>(List.of(
                new Name("firstName1", "lastName"),
                new Name("firstName1", "lastName"),
                new Name("firstName1", "lastName")
        ));

        assertDuplicatesRemoved(names);
    }

    private void assertDuplicatesRemoved(List<Name> names) {
        var expectedNames = new TreeSet<>(Comparator.comparing(Name::getFirstName));
        expectedNames.addAll(names);

        removeFirstNameDuplicates(names);

        assertThat(names).containsExactlyElementsOf(expectedNames);
    }
}