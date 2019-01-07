package com.leonenko.epi._13_sort;

/**
 * Created by Alex on 5/8/2017.
 */
final class Endpoint implements Comparable<Endpoint> {
    private final int value;
    private final boolean isStart;
    private final boolean isClosed;

    Endpoint(int value, boolean isStart) {
        this(value, isStart, false);
    }

    Endpoint(int value, boolean isStart, boolean isClosed) {
        this.value = value;
        this.isStart = isStart;
        this.isClosed = isClosed;
    }

    public int getValue() {
        return value;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public String toString() {
        if (isStart) {
            return (isClosed ? "[" : "(") + value;
        } else {
            return value + (isClosed ? "]" : ")");
        }
    }

    @Override
    public int compareTo(Endpoint o) {
        return Integer.compare(value, o.value);
    }

    public Endpoint min(Endpoint o) {
        return this.compareTo(o) <= 0 ? this : o;
    }

    public Endpoint max(Endpoint o) {
        return this.compareTo(o) >= 0 ? this : o;
    }
}
