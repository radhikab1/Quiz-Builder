package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

public class LimitedTriesQuiz extends Quiz {
    int questionNumber;
    int maxMark;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
        questionNumber = 0;
        maxMark = questions.getQuestion(questionNumber).getMaxMark();
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectExceptioncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        if ((!correct) && (maxMark > 1)) {
            maxMark--;
            throw new AnswerIncorrectException("Re-try Question!");
        }
        if (((!correct) && (maxMark == 1)) || (correct)) {
            questionNumber++;
            if (questions.length() > questionNumber) {
                maxMark = questions.getQuestion(questionNumber).getMaxMark();
            }
            if (!correct) {
                throw new OutOfTriesException("Incorrect answer. No more attempts allowed!");
            }
        }
        return correct ? "Correct!" : "Incorrect!";
    }
}
