package edu.til.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTests {

    private Profile profile;
    private BooleanQuestion questionIsThereRelocation;
    private Answer answerThereIsRelocation;
    private Answer answerThereIsNotRelocation;

    @BeforeEach
    public void init() {
        profile = new Profile();
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation Package?");
        answerThereIsRelocation = new Answer(questionIsThereRelocation, Boolean.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Boolean.FALSE);
    }

    @Test
    public void whenProfileIsEmptyThenMatchesNothing() {
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void whenProfileContainsAnswerThenMatchesAnswer() {
        profile.add(answerThereIsRelocation);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }

    @Test
    public void whenNotMatchingAnswerThenNotMatchAnswer() {
        profile.add(answerThereIsNotRelocation);

        Criterion criterion = new Criterion(answerThereIsNotRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void whenProfileContainsMultipleAnswersThenMatchesAnswers() {
        profile.add(answerThereIsRelocation);
        profile.add(answerThereIsNotRelocation);

        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }


}
