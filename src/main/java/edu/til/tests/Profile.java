package edu.til.tests;

import java.util.HashMap;
import java.util.Map;

public class Profile {

    private Map<String, Answer> answers = new HashMap<>();

    private Answer answer;

    public boolean matches(Criterion criterion) {
        Answer answer = getMatchingProfileAnswer(criterion);
        return answer.match(criterion.getAnswer());
    }

    public void add(Answer answer) {
        answers.put(answer.getQuestionText(), answer);
    }

    private Answer getMatchingProfileAnswer(Criterion criterion) {
        return answers.get(criterion.getAnswer().getQuestionText());
    }

}
