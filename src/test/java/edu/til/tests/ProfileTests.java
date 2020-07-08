package edu.til.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTests {

    @Test
    public void whenProfileIsEmptyThenMatchesNothing() {
        Profile profile = new Profile();

        Question question = new BooleanQuestion(1, "Relocation Package?");
        Criterion criterion = new Criterion(new Answer(question, Boolean.TRUE), Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void whenProfileContainsAnswersThenMatchesAnswers() {
        Profile profile = new Profile();
        Question question = new BooleanQuestion(1, "Relocation Package?");
        Answer answer = new Answer(question, Boolean.TRUE);

        profile.add(answer);

        Criterion criterion = new Criterion(answer, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }


}
