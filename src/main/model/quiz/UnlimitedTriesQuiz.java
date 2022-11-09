package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

// Represents a Quiz that allows the user to retry the answer as man times as they want and the correct answer must be
// entered before the quiz moves on to the next question.
public class UnlimitedTriesQuiz extends Quiz {
    Integer numAttempts;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
        numAttempts = 0;
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        numAttempts++;
        boolean correct = super.checkAnswer(answer);
        if (!correct) {
            throw new AnswerIncorrectException("Re-try Question");
        }
        return correct ? "Correct!" : "Incorrect!";
    }


    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return numAttempts;
    }

    // MODIFIES: this
    // EFFECTS: returns a string providing feedback to the user on their performance in the quiz
    public String endQuiz() {
        return "It took you " + getNumAttempts() + " attempts to answer " + questions.length() + " questions correctly.";
    }
}
