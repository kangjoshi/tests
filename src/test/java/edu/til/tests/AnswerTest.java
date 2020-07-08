package edu.til.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    public void whenAnswerIsEmptyThenReturnFalse() {

        assertFalse(new Answer(new BooleanQuestion(0, ""), Boolean.TRUE).match(null));
    }



}