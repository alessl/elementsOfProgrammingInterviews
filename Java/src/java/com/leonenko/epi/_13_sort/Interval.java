package com.leonenko.epi._13_sort;

/**
 * Created by Alex on 5/8/2017.
 */
final class Interval {
    private final Endpoint start;
    private final Endpoint end;

    Interval(int start, int end) {
        this(start, end, false, false);
    }

    Interval(int start, int end, boolean isStartClosed, boolean isEndClosed) {
        this.start = new Endpoint(start, true, isStartClosed);
        this.end = new Endpoint(end, false, isEndClosed);
    }

    public Endpoint getStart() {
        return start;
    }

    public Endpoint getEnd() {
        return end;
    }

    boolean isBefore(Interval o) {
        return this.getEnd().compareTo(o.getStart()) < 0;
    }

    boolean isAfter(Interval o) {
        return this.getStart().compareTo(o.getEnd()) > 0;
    }

    boolean isStartClosed() {
        return start.isClosed();
    }

    boolean isEndClosed() {
        return end.isClosed();
    }

    @Override
    public String toString() {
        return String.format("%s,%s", start, end);
    }

    static Interval closed(int start, int end) {
        return new Interval(start, end, true, true);
    }

    static Interval open(int start, int end) {
        return new Interval(start, end, false, false);
    }

    static Interval startClosed(int start, int end) {
        return new Interval(start, end, true, false);
    }

    static Interval endClosed(int start, int end) {
        return new Interval(start, end, false, true);
    }
}
