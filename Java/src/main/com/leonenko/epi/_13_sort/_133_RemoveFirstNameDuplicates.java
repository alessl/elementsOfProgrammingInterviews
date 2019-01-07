package com.leonenko.epi._13_sort;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Comparator;
import java.util.List;

class _133_RemoveFirstNameDuplicates {

    static void removeFirstNameDuplicates(List<Name> names) {
        names.sort(Comparator.comparing(Name::getFirstName));

        var writeIdx = 1;

        for (int i = 1; i < names.size(); i++) {
            var name = names.get(i);

            if (!names.get(writeIdx - 1).firstName.equals(name.firstName)) {
                names.set(writeIdx++, name);
            }
        }

        names.subList(writeIdx, names.size()).clear();
    }

    static class Name {
        private final String firstName;
        private final String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        @Override
        public boolean equals(Object o) {
            return EqualsBuilder.reflectionEquals(this, o);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this,
                    ToStringStyle.NO_CLASS_NAME_STYLE);
        }
    }
}
