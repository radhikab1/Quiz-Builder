package model.question;


import model.question.checker.ArithmeticAnswerChecker;

// Represents a question whose answer is an int
public class ArithmeticQuestion extends Question {
    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION
    }

    // REQUIRES: maxMark must be >= 0
    // EFFECTS: constructs arithmetic answer question with given maximum mark, question statement, and correct answer
    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark, questionString(operation, firstOp, secondOp),
                new ArithmeticAnswerChecker(correctAnswer(operation, firstOp, secondOp)));

    }

    static int correctAnswer(Operation operation, int firstOp, int secondOp) {
        switch (operation) {
            case ADDITION:
                return firstOp + secondOp;
            case SUBTRACTION:
                return firstOp - secondOp;
            default:
                return firstOp * secondOp;
        }
    }

    // REQUIRES:
    // EFFECTS:
    static String questionString(Operation operation, int firstOp, int secondOp) {
        switch (operation) {
            case ADDITION:
                return "What is " + firstOp + " " + "+" + " " + secondOp + " ?";
            case SUBTRACTION:
                return "What is " + firstOp + " " + "-" + " " + secondOp + " ?";
            default:
                return "What is " + firstOp + " " + "*" + " " + secondOp + " ?";
        }
    }
}
