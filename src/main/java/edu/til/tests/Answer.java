package edu.til.tests;

public class Answer {

    private Question question;
    private boolean isTrue;

    public Answer(Question question, Boolean isTrue) {
        this.question = question;
        this.isTrue = isTrue;
    }

    public boolean match(Answer answer) {

        if (answer == null) return false;

        return isTrue;
    }

    public String getQuestionText() {
        return "";
    }
}
