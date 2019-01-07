package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class _81_StackWithMax_Test {

    private final _81_StackWithMax stack = new _81_StackWithMax(5);

    @Test
    void isEmpty() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void push() {
        pushToStack(10);

        assertThat(stack.peek()).isEqualTo(10);
        assertThat(stack.max()).isEqualTo(10);
        assertThat(stack.min()).isEqualTo(10);
    }

    @Test
    void pushNewMaxPositive() {
        pushToStack(10, 20);

        assertStackContent(20, 10, 20);
    }

    @Test
    void pushNewMaxNegative() {
        pushToStack(-10, -5);

        assertStackContent(-5, -10, -5);
    }

    @Test
    void pushNewMinPositive() {
        pushToStack(10, 5);

        assertStackContent(5, 5, 10);
    }

    @Test
    void pushNewMinNegative() {
        pushToStack(10, -15);

        assertStackContent(-15, -15, 10);
    }

    @Test
    void pop() {
        pushToStack(10);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(10);
    }

    @Test
    void popNoMinMaxChangePositive() {
        pushToStack(10, 15, 11);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(11);
        assertStackContent(15, 10, 15);
    }

    @Test
    void popNoMinMaxChangeNegative() {
        pushToStack(-10, -15, -11);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(-11);
        assertStackContent(-15, -15, -10);
    }

    @Test
    void popMinNegative() {
        pushToStack(15, -10);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(-10);
        assertStackContent(15, 15, 15);
    }

    @Test
    void popMinPositive() {
        pushToStack(15, 10);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(10);
        assertStackContent(15, 15, 15);
    }

    @Test
    void popMaxNegative() {
        pushToStack(-15, -20);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(-20);
        assertStackContent(-15, -15, -15);
    }

    @Test
    void popMaxPositive() {
        pushToStack(10, 15);

        var popResult = stack.pop();

        assertThat(popResult).isEqualTo(15);
        assertStackContent(10, 10, 10);
    }

    private void assertStackContent(int expectedTopVal, int expectedMinVal, int expectedMaxVal) {
        assertThat(stack.peek()).isEqualTo(expectedTopVal);
        assertThat(stack.min()).isEqualTo(expectedMinVal);
        assertThat(stack.max()).isEqualTo(expectedMaxVal);
    }

    private void pushToStack(int... values) {
        Arrays.stream(values)
                .forEach(stack::push);
    }
}