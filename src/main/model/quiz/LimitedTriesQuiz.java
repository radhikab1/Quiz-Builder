package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

// Represents a quiz that allows the user to retry the answer as many times as there are marks initially located to the
// question. Moves on to next question if user answers question incorrectly on last try
public class LimitedTriesQuiz extends Quiz {
    Integer maxMark;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        maxMark = this.curQuestion.getMaxMark();
        if ((!correct) && (maxMark > 1)) {
            this.curQuestion.setMaxMark(maxMark - 1);
            throw new AnswerIncorrectException("Re-try Question!");
        } else {
            if (!correct) {
                throw new OutOfTriesException("Incorrect answer. No more attempts allowed!");
            } else {
                return "Correct!";
            }
        }
    }
}
