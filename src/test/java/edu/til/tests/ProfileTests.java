package edu.til.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTests {

    @Test
    public void whenProfileIsEmptyThenMatchesNothing() {
        Profile profile = new Profile();

        Question question = new BooleanQuestion(1, "Relocation Package?");
        Criterion criterion = new Criterion(new Answer(question, Boolean.TRUE), Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }


}
