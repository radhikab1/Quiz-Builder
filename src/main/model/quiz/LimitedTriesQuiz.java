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
        if ((!correct) && (maxMark > 0)) {
            maxMark--;
            throw new AnswerIncorrectException("Re-try Question!");
        }
        if ((!correct) && (maxMark == 0)) {
            questionNumber++;
            if (questions.length() > questionNumber) {
                maxMark = questions.getQuestion(questionNumber).getMaxMark();
            }
            throw new OutOfTriesException("Incorrect answer. No more attempts allowed!");
        }
        if (correct) {
            if (questions.length() > questionNumber) {
                maxMark = questions.getQuestion(questionNumber).getMaxMark();
            }
            questionNumber++;
        }
        return correct ? "Correct!" : "Incorrect!";

//        for (int maxMark = questions.getMaxMark(); maxMark >= 0; maxMark--) {
//            boolean correct = super.checkAnswer(answer);
//            if ((!correct) && (maxMark != 0)) {
//                throw new AnswerIncorrectException("Re-try Question!");
//            }
//
//            if (maxMark == 0) {
//                throw new OutOfTriesException("Incorrect answer. No more attempts allowed!");
//            } else if (correct) {
//                break;
//            }
//        }
//        boolean correct = super.checkAnswer(answer);
//        return correct ? "Correct!" : "Incorrect!";
    }
}
