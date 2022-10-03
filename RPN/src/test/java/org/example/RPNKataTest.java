package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RPNKataTest {
    private RPNKata rpnKata;

    @BeforeEach
    public void initEach() {
        this.rpnKata = new RPNKata();
    }

    @AfterEach
    public void endEach() {
        this.rpnKata = null;
    }

    @Test
    void should_calculate_basic_addition() {
        assertEquals(3, rpnKata.process(1, 2, "+"));
    }

    @Test
    void should_calculate_basic_subtraction() {
        assertEquals(1, rpnKata.process(3, 2, "-"));
    }

    @Test
    void should_calculate_basic_multiplication() {
        assertEquals(15, rpnKata.process(3, 5, "*"));
    }

    @Test
    void should_calculate_basic_division() {
        assertEquals(4, rpnKata.process(20, 5, "/"));
    }

    @Test
    void should_calculate_medium_addition() {
        final String operation = "4 2 + 3 -";
        assertEquals(3, rpnKata.process(operation));
    }

    @Test
    void should_calculate_harder_addition() {
        final String operation = "3 5 8 * 7 + *";
        assertEquals(141, rpnKata.process(operation));
    }

    @Test
    void should_calculate_harder_calculation() {
        final String operation = "2 2 3 5 8 * 7 + * * *";
        assertEquals(564, rpnKata.process(operation));
    }

    @Test
    void should_calculate_sqrt() {
        final String operation = "9 SQRT";
        assertEquals(3, rpnKata.process(operation));
    }

    @Test
    void should_find_max() {
        final String operation = "5 3 4 2 9 1 MAX";
        assertEquals(9, rpnKata.process(operation));
    }

    @Test
    void should_mix_max_and_operator() {
        final String operation = "4 5 MAX 1 +";
        assertEquals(6, rpnKata.process(operation));
    }
}
