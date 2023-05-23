package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FactTest {

    @Test
    public void whenExceptionCalc() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fact.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenNoExceptionCalc() {
        Fact fact = new Fact();
        int expected = 1;
        int result = fact.calc(1);
        assertThat(result).isEqualTo(expected);
    }
}